package ru.evrika.pfr.autoprocessing.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jdom.Document;
import org.springframework.stereotype.Service;
import ru.evrika.pfr.autoprocessing.core.model.PackageInfo;
import ru.evrika.pfr.autoprocessing.core.service.ArchiveManager;
import ru.evrika.pfr.autoprocessing.core.service.EmailService;
import ru.evrika.pfr.autoprocessing.core.service.PackageService;
import ru.evrika.pfr.autoprocessing.file.FileService;
import ru.evrika.pfr.autoprocessing.file.XmlService;
import ru.evrika.pfr.autoprocessing.file.ZipBuilder;

import java.util.List;

/**
 * Created by Sergei Balashov on 08.03.2020.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UseCase {

    private final String DESCRIPTION = "packageDescription.xml";

    private final String FILE_NAME_PATTERN = "*083*";

    private final XmlService xmlService;

    private final PackageService packageService;

    private final ArchiveManager archiveManager;

    private final EmailService emailService;

    private final FileService fileService;

    public void processFiles(String incomingPathName) {
        List<String> files = fileService.findAllFiles(incomingPathName, FILE_NAME_PATTERN);
    }

    private void processFile(String fileName) {
        ZipBuilder zipBuilder = new ZipBuilder(fileName);
        Document xmlDocument = xmlService.loadXml(zipBuilder.unzipFile(DESCRIPTION));
        PackageInfo packageInfo = packageService.parseXml(xmlDocument);
        packageService.save(packageInfo);
        emailService.sendPackageInfo(packageInfo);
        archiveManager.archiving(fileName);
    }
}
