package ru.evrika.pfr.autoprocessing.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.evrika.pfr.autoprocessing.core.model.PackageInfo;
import ru.evrika.pfr.autoprocessing.core.service.ArchiveManager;
import ru.evrika.pfr.autoprocessing.core.usecase.info.PackageCreator;
import ru.evrika.pfr.autoprocessing.core.usecase.worker.WorkerFactory;

import java.util.List;

/**
 * Created by Sergei Balashov on 08.03.2020.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class FileProcessor {

    private final PackageCreator<String> packageCreator;

    private final ArchiveManager archiveManager;

    private final WorkerFactory workerFactory;

    public void process(List<String> files) {

        files.forEach(this::processFile);
    }

    private void processFile(String fileName) {
        PackageInfo packageInfo = packageCreator.createFromSource(fileName);
        packageInfo.setFileName(fileName);
        packageCreator.save(packageInfo);
        workerFactory.getWorker(packageInfo.getType().getType()).execute(packageInfo);
        archiveManager.archiving(fileName);
    }
}
