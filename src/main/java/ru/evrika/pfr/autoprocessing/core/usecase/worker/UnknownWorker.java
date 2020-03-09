package ru.evrika.pfr.autoprocessing.core.usecase.worker;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.evrika.pfr.autoprocessing.core.model.PackageInfo;

/**
 * Created by Sergei Balashov on 08.03.2020.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UnknownWorker implements PackageWorker {

    @Override
    public void execute(PackageInfo packageInfo) {
        log.warn("Unknown packageInfo type");
    }
}
