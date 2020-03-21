package ru.evrika.pfr.autoprocessing.file;

import com.google.common.io.CharStreams;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by Timid on 19.12.2015.
 */
@Slf4j
public class ZipManager {

    private final ZipFile zipFile;

    public ZipManager(String zipFileName) {
        try {
            this.zipFile = new ZipFile(zipFileName);
        } catch (IOException e) {
            log.warn("Can not load file: [{}]", zipFileName);
            throw new RuntimeException("Load error!", e);
        }
    }

    public ZipManager(File zipFile) {
        try {
            this.zipFile = new ZipFile(zipFile);
        } catch (IOException e) {
            log.warn("Can not load file: [{}]", zipFile.getName());
            throw new RuntimeException("Load error!", e);
        }
    }

    public String getUnzipFileContent(String fileName, String charsetName) {
        ZipEntry zipEntry = zipFile.getEntry(fileName);
        try (InputStream inputStream = this.zipFile.getInputStream(zipEntry)) {
            return CharStreams.toString(new InputStreamReader(inputStream, charsetName));
        } catch (IOException e) {
            log.warn("Can not open file: [{}] in zip: [{}]", fileName, zipFile.getName());
            throw new RuntimeException("File read error!", e);
        }
    }
}
