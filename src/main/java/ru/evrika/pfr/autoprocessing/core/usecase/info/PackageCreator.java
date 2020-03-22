package ru.evrika.pfr.autoprocessing.core.usecase.info;

import ru.evrika.pfr.autoprocessing.core.model.PackageInfo;

/**
 * Сервис для управления {@link PackageInfo}
 * @param <T> тип индентификатора ресурса
 */
public interface PackageCreator<T> {

    PackageInfo createFromSource(T packageId);
}
