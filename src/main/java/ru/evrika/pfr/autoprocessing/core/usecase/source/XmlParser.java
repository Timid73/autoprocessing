package ru.evrika.pfr.autoprocessing.core.usecase.source;

import org.jdom2.Document;
import org.jdom2.Element;
import ru.evrika.pfr.autoprocessing.core.enums.TransactionType;
import ru.evrika.pfr.autoprocessing.core.model.PackageInfo;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sergei Balashov on 22.03.2020.
 */
public class XmlParser {

    private static final List<String> PROTOCOL_TYPES = Arrays.asList("пачкаАДВ", "пачкаИС", "реестрДСВ", "пачкаРСВ", "пачкаСЗВ", "пачкаСПВ");

    public static PackageInfo parseDocument(Document document) {
        PackageInfo packageInfo = new PackageInfo();
        packageInfo.setDate(LocalDateTime.now());
        packageInfo.setUid(document.getRootElement().getAttributeValue("идентификаторДокументооборота"));
        packageInfo.setRegNumFrom(document.getRootElement().getChild("отправитель").getAttributeValue("идентификаторСубъекта"));
        packageInfo.setRegNumTo(document.getRootElement().getChild("получатель").getAttributeValue("идентификаторСубъекта"));
        packageInfo.setType(TransactionType.of(document.getRootElement().getAttributeValue("типТранзакции")));
        packageInfo.setPositive(isProtocolPositive(document));
        return packageInfo;
    }

    private static boolean isProtocolPositive(Document xml) {
        for (Object element : xml.getRootElement().getChildren("документ")) {
            return PROTOCOL_TYPES.contains(((Element) element).getAttributeValue("типДокумента"));
        }
        return false;
    }
}
