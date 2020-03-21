package ru.evrika.pfr.autoprocessing.file.impl;

import lombok.extern.slf4j.Slf4j;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import ru.evrika.pfr.autoprocessing.file.XmlService;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by Timid on 20.12.2015.
 */
@Service
@Slf4j
public class XmlServiceImpl implements XmlService {

    @Override
    public Document loadXml(@NonNull String content) {
        try {
            SAXBuilder saxBuilder = new SAXBuilder();
            return saxBuilder.build(new StringReader(content));
        } catch (JDOMException e) {
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
