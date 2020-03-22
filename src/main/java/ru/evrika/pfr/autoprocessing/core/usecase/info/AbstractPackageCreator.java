package ru.evrika.pfr.autoprocessing.core.usecase.info;

import lombok.AllArgsConstructor;
import ru.evrika.pfr.autoprocessing.core.model.PackageInfo;

/**
 * Created by Sergei Balashov on 07.03.2020.
 */
@AllArgsConstructor
public abstract class AbstractPackageCreator<T> implements PackageCreator<T> {

    @Override
    public abstract PackageInfo createFromSource(T packageId);
}
