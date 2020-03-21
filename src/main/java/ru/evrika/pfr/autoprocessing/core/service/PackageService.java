package ru.evrika.pfr.autoprocessing.core.service;

import org.w3c.dom.Document;
import ru.evrika.pfr.autoprocessing.core.model.PackageInfo;

/**
 * Created by Sergei Balashov on 07.03.2020.
 */
public interface PackageService {

    PackageInfo parseXml(Document xml);

    PackageInfo save(PackageInfo packageInfo);
}
