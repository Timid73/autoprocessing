package ru.evrika.pfr.autoprocessing.file;

import com.google.common.io.CharStreams;
import lombok.extern.slf4j.Slf4j;
import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

/**
 * Created by Timid on 20.12.2015.
 */
@Service
@Slf4j
public class XmlServiceImpl implements XmlService {

    @Override
    public Document loadXml(InputStream inputStream) {
        if (inputStream == null) {
            throw new RuntimeException();
        }
        try {
            String content = CharStreams.toString(new InputStreamReader(inputStream, "windows-1251"));
            inputStream.close();
            SAXBuilder saxBuilder = new SAXBuilder();
            return saxBuilder.build(new StringReader(content));
        } catch (IOException e) {
            throw new RuntimeException();
        } catch (JDOMException e) {
            throw new RuntimeException();
        }
    }
}
