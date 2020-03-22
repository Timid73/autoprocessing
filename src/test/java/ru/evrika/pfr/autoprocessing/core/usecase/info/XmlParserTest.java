package ru.evrika.pfr.autoprocessing.core.usecase.info;

import org.jdom2.Document;
import org.junit.jupiter.api.Test;
import ru.evrika.pfr.autoprocessing.core.enums.TransactionType;
import ru.evrika.pfr.autoprocessing.core.model.PackageInfo;
import ru.evrika.pfr.autoprocessing.core.usecase.source.XmlParser;
import ru.evrika.pfr.autoprocessing.file.XmlService;
import ru.evrika.pfr.autoprocessing.file.impl.XmlServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Sergei Balashov on 21.03.2020.
 */
class XmlParserTest {

    private final static String XML_TEXT = "<?xml version=\"1.0\" encoding=\"windows-1251\"?>\n" +
            "<пакет типТранзакции=\"ДокументПФР\" типДокументооборота=\"ДокументПФР\" идентификаторДокументооборота=\"341d4d17b7b97189760be899fbf43383\" версияФормата=\"ПФР:2.0\">\n" +
            "<СКЗИ типСКЗИ=\"Крипто-Про\"/>\n" +
            "<отправитель идентификаторСубъекта=\"083-028-000000\" типСубъекта=\"абонент\"/>\n" +
            "<получатель идентификаторСубъекта=\"PFR-001\" типСубъекта=\"ПФР\"/>\n" +
            "<документ идентификаторДокумента=\"e66f4598dab0c62a19ad366b20067955\" исходноеИмяФайла=\"ПФР_083-028-000000_000000_ЗПЭД_20200303_094C11DE-6315-4428-A120-71A13423766B.XML.gz.enc\" сжат=\"true\" зашифрован=\"true\" типДокумента=\"СлужДокПФР\" типСодержимого=\"xml\">\n" +
            "<содержимое имяФайла=\"61d64885049e528926627a3d1bea82e5.bin\"/>\n" +
            "</документ>\n" +
            "<документ идентификаторДокумента=\"b9d441cae2b4ad529da49b8e6b7cc241\" исходноеИмяФайла=\"ad3bdb64c5fc718410163595600fd6d01aa2f5f9.der\" сжат=\"false\" зашифрован=\"false\" типДокумента=\"СертификатШифрования\" типСодержимого=\"cert\">\n" +
            "<содержимое имяФайла=\"10fc4bf68b90b52777a968f6031e53fb.bin\"/>\n" +
            "<подпись имяФайла=\"b6674a93b09bf9ace514aaae7ce245fe.bin\" роль=\"руководитель\"/>\n" +
            "</документ>\n" +
            "<документ идентификаторДокумента=\"772b48cacd8f91b130dc231b2951b908\" исходноеИмяФайла=\"ПФР_083-028-000000_000000_ОСП_20200303_2c204655-02a3-bbef-5226-211aebb8f47c.xml\" сжат=\"false\" зашифрован=\"false\" типДокумента=\"ОписьПакетаПФР\" типСодержимого=\"xml\">\n" +
            "<содержимое имяФайла=\"6715460c768a4a6eded6a32a2c73e38c.bin\"/>\n" +
            "</документ>\n" +
            "<документ идентификаторДокумента=\"2e9146675fa532380cd60852fbeee82d\" исходноеИмяФайла=\"\" сжат=\"true\" зашифрован=\"false\" типДокумента=\"Описание\" типСодержимого=\"xml\">\n" +
            "<содержимое имяФайла=\"76bd44a3439a0ea8d9b98ac3fc6e46ef.bin\"/>\n" +
            "</документ>\n" +
            "</пакет>";

    @Test
    void parseXml() {

        XmlService xmlService = new XmlServiceImpl();
        Document document = xmlService.loadXml(XML_TEXT);
        PackageInfo packageInfo = XmlParser.parseDocument(document);
        assertEquals("341d4d17b7b97189760be899fbf43383", packageInfo.getUid());
        assertEquals("083-028-000000", packageInfo.getRegNumFrom());
        assertEquals(TransactionType.unknown, packageInfo.getType());
    }

    @Test
    void save() {
    }
}