package ru.evrika.pfr.autoprocessing.core.usecase.worker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import ru.evrika.pfr.autoprocessing.core.enums.PackageType;

import java.util.Map;

/**
 * Created by Sergei Balashov on 09.03.2020.
 */
@Component
@Slf4j
public class WorkerFactory {

    private final Map<String, PackageWorker>  workers;

    @Autowired
    private ApplicationContext context;

    public WorkerFactory() {
        workers = context.getBeansOfType(PackageWorker.class);
    }

    public PackageWorker getWorker(PackageType type) {
        switch (type) {
            case Pension: return workers.get(PensionWorker.class.getCanonicalName());
            case ReSign:  return workers.get(ReSignWorker.class.getCanonicalName());
            case Protocol: return workers.get(ProtocolWorker.class.getCanonicalName());
            default: return workers.get(UnknownWorker.class.getCanonicalName());
        }
    }
}
