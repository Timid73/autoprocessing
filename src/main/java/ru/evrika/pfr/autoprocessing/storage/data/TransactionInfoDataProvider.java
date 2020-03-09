package ru.evrika.pfr.autoprocessing.storage.data;

import ru.evrika.pfr.autoprocessing.core.model.PackageInfo;
import ru.evrika.pfr.autoprocessing.core.model.TransactionInfo;

import java.util.List;

/**
 * Created by Sergei Balashov on 08.03.2020.
 */
public interface TransactionInfoDataProvider {

    TransactionInfo save(PackageInfo packageInfo);

    TransactionInfo findByUid(String uid);

    List<TransactionInfo> findAll();
}
