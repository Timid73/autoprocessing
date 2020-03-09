package ru.evrika.pfr.autoprocessing.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.evrika.pfr.autoprocessing.config.FileProperty;
import ru.evrika.pfr.autoprocessing.core.usecase.PackageUseCase;
import ru.evrika.pfr.autoprocessing.file.FileService;

import java.util.List;

/**
 * Created by Timid on 19.12.2015.
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class ScheduledTasks {

    @Value("${path.incoming}")
    private String incomingPathName;

    private final PackageUseCase packageUseCase;

    private final FileService fileService;

    private final FileProperty fileProperty;

    @Scheduled(fixedRate = 5000)
    protected void executeInternal() {

        List<String> files = fileService.findAllFiles(incomingPathName, fileProperty.getMaskPattern());
        packageUseCase.process(files);
    }
}
