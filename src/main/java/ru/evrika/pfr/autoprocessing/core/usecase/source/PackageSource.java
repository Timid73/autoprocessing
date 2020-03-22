package ru.evrika.pfr.autoprocessing.core.usecase.source;

import ru.evrika.pfr.autoprocessing.core.model.PackageInfo;

/**
 * Created by Sergei Balashov on 22.03.2020.
 */
public interface PackageSource<T> {

    PackageInfo get(T packageId);
}
