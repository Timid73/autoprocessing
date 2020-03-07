package ru.evrika.pfr.autoprocessing.storage.data;

import ru.evrika.pfr.autoprocessing.core.model.PackageInfo;

import java.util.List;

/**
 * Created by Sergei Balashov on 08.03.2020.
 */
public interface PackegeInfoDataProvider {

    PackageInfo save(PackageInfo packageInfo);

    List<PackageInfo> findAll();
}
