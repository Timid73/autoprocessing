package ru.evrika.pfr.autoprocessing.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jdom.Document;
import org.springframework.stereotype.Service;
import ru.evrika.pfr.autoprocessing.core.model.PackageInfo;
import ru.evrika.pfr.autoprocessing.core.service.ArchiveManager;
import ru.evrika.pfr.autoprocessing.core.service.PackageService;
import ru.evrika.pfr.autoprocessing.core.usecase.worker.WorkerFactory;
import ru.evrika.pfr.autoprocessing.file.XmlService;
import ru.evrika.pfr.autoprocessing.file.ZipBuilder;

import java.util.List;

/**
 * Created by Sergei Balashov on 08.03.2020.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PackageUseCase {

    private final String DESCRIPTION = "packageDescription.xml";

    private final String SIGN = "packageDescription.sign";

    private final XmlService xmlService;

    private final PackageService packageService;

    private final ArchiveManager archiveManager;


    private final WorkerFactory workerFactory;

    public void process(List<String> files) {

        files.forEach(this::processFile);
    }

    private void processFile(String fileName) {
        ZipBuilder zipBuilder = new ZipBuilder(fileName);
        Document xmlDocument = xmlService.loadXml(zipBuilder.unzipFile(DESCRIPTION));
        PackageInfo packageInfo = packageService.parseXml(xmlDocument);
        packageInfo.setFileName(fileName);
        packageService.save(packageInfo);
        workerFactory.getWorker(packageInfo.getType().getType()).execute(packageInfo);
        archiveManager.archiving(fileName);
    }
}
