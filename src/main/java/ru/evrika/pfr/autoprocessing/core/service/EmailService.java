package ru.evrika.pfr.autoprocessing.core.service;

import ru.evrika.pfr.autoprocessing.core.model.PackageInfo;

/**
 * Created by Sergei Balashov on 08.03.2020.
 */
public interface EmailService {

    void createMessage(PackageInfo packageInfo);
}
