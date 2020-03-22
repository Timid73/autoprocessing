package ru.evrika.pfr.autoprocessing.core.usecase.info;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evrika.pfr.autoprocessing.core.model.PackageInfo;
import ru.evrika.pfr.autoprocessing.core.usecase.source.PackageSource;

/**
 * Created by Sergei Balashov on 22.03.2020.
 */
@Service
@RequiredArgsConstructor
public class XmlPackageCreator extends AbstractPackageCreator<String> {

    private final PackageSource<String> source;

    @Override
    public PackageInfo createFromSource(String packageId) {
        return source.get(packageId);
    }
}
