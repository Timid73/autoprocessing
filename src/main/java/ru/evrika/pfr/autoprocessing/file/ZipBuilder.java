package ru.evrika.pfr.autoprocessing.file;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by Timid on 19.12.2015.
 */
@Slf4j
public class ZipBuilder {

    private final ZipFile zipFile;

    public ZipBuilder(String zipFileName) {
        try {
            zipFile = new ZipFile(zipFileName);
        } catch (IOException e) {
            log.error("Can not unzip file: [{}]", zipFileName);
            throw new RuntimeException("Unzip error!");
        }
    }

    public InputStream unzipFile(String fileName) {
        ZipEntry zipEntry = zipFile.getEntry(fileName);
        try {
            return this.zipFile.getInputStream(zipEntry);
        } catch (IOException e) {
            log.error("Can not open file: [{}] in zip: [{}]", fileName, zipFile.getName());
            throw new RuntimeException("File read error!");
        }
    }
}
