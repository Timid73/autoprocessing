package ru.evrika.pfr.autoprocessing.core.usecase.source;

import lombok.AllArgsConstructor;
import org.jdom2.Document;
import org.springframework.stereotype.Service;
import ru.evrika.pfr.autoprocessing.core.model.PackageInfo;
import ru.evrika.pfr.autoprocessing.file.XmlService;
import ru.evrika.pfr.autoprocessing.file.ZipManager;

import static ru.evrika.pfr.autoprocessing.core.usecase.source.XmlParser.parseDocument;

/**
 * Created by Sergei Balashov on 22.03.2020.
 */
@Service
@AllArgsConstructor
public class XmlPackageSource implements PackageSource<String> {

    private final String DESCRIPTION = "packageDescription.xml";

    private final String SIGN = "packageDescription.sign";

    private final XmlService xmlService;

    @Override
    public PackageInfo get(String packageId) {
        ZipManager zipManager = new ZipManager(packageId);
        Document xmlDocument = xmlService.loadXml(zipManager.getUnzipFileContent(DESCRIPTION, "windows-1251"));
        return parseDocument(xmlDocument);
    }
}
