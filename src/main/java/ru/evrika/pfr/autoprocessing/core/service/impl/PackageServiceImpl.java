package ru.evrika.pfr.autoprocessing.core.service.impl;

import org.jdom.Document;
import org.jdom.Element;
import org.springframework.stereotype.Service;
import ru.evrika.pfr.autoprocessing.core.model.PackageInfo;
import ru.evrika.pfr.autoprocessing.core.enums.TransactionType;
import ru.evrika.pfr.autoprocessing.core.service.PackageService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sergei Balashov on 07.03.2020.
 */
@Service
public class PackageServiceImpl implements PackageService {

    private final List<String> PROTOCOL_TYPES = Arrays.asList("пачкаАДВ", "пачкаИС", "реестрДСВ", "пачкаРСВ", "пачкаСЗВ", "пачкаСПВ");

    @Override
    public PackageInfo parseXml(Document xml) {
        PackageInfo packageInfo = new PackageInfo();
        packageInfo.setDate(LocalDateTime.now());
        packageInfo.setUid(xml.getRootElement().getChild("пакет").getAttributeValue("идентификаторДокументооборота"));
        packageInfo.setRegNumFrom(xml.getRootElement().getChild("пакет").getChild("отправитель").getAttributeValue("идентификаторСубъекта"));
        packageInfo.setRegNumTo(xml.getRootElement().getChild("пакет").getChild("получатель").getAttributeValue("идентификаторСубъекта"));
        packageInfo.setType(TransactionType.of(xml.getRootElement().getChild("пакет").getAttributeValue("типТранзакции")));
        packageInfo.setPositive(isProtocolPositive(xml));
        return packageInfo;
    }

    @Override
    public PackageInfo save(PackageInfo packageInfo) {
        return null;
    }

    private boolean isProtocolPositive(Document xml) {
        for (Object element: xml.getRootElement().getChild("пакет").getChildren("документ")) {
            return PROTOCOL_TYPES.contains(((Element)element).getAttributeValue("типДокумента"));
        }
        return false;
    }
}
