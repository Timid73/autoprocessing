package ru.evrika.pfr.autoprocessing.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.evrika.pfr.autoprocessing.core.usecase.UseCase;

/**
 * Created by Timid on 19.12.2015.
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class ScheduledTasks {

    @Value("${path.incoming}")
    private String incomingPathName;

    private final UseCase useCase;

    @Scheduled(fixedRate = 5000)
    protected void executeInternal() {

        useCase.processFiles(incomingPathName);
    }
}
