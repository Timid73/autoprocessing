package ru.evrika.pfr.autoprocessing.file;

import org.jdom.Document;

import java.io.InputStream;

/**
 * Created by Sergei Balashov on 07.03.2020.
 */
public interface XmlService {

    Document loadXml(InputStream inputStream);
}
