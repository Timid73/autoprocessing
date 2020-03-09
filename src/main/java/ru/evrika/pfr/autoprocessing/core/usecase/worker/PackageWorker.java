package ru.evrika.pfr.autoprocessing.core.usecase.worker;

import ru.evrika.pfr.autoprocessing.core.model.PackageInfo;

/**
 * Created by Sergei Balashov on 08.03.2020.
 */
public interface PackageWorker {

    void execute(PackageInfo packageInfo);
}
