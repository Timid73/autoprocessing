package ru.evrika.pfr.autoprocessing.core.service;

import org.jdom.Document;
import org.springframework.stereotype.Service;
import ru.evrika.pfr.autoprocessing.core.model.PackageInfo;

/**
 * Created by Sergei Balashov on 07.03.2020.
 */
@Service
public class PackageServiceImpl implements PackageService{

    @Override
    public PackageInfo parseXml(Document xml) {
        return null;
    }

    @Override
    public PackageInfo save(PackageInfo packageInfo) {
        return null;
    }
}
