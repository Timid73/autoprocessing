package ru.evrika.pfr.autoprocessing.core.service;

import ru.evrika.pfr.autoprocessing.core.model.PackageInfo;
import ru.evrika.pfr.autoprocessing.core.model.TransactionInfo;

/**
 * Created by Sergei Balashov on 07.03.2020.
 */
public interface TransactionService {

    TransactionInfo create(PackageInfo packageInfo);

    TransactionInfo find(String uid);

    TransactionInfo save(TransactionInfo transactionInfo);
}
