package ru.evrika.pfr.autoprocessing.file;

import org.jdom2.Document;

/**
 * Created by Sergei Balashov on 07.03.2020.
 */
public interface XmlService {

    Document loadXml(String xmlContent);
}
