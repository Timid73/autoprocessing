package ru.evrika.pfr.autoprocessing.file;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Sergei Balashov on 21.03.2020.
 */
public class ZipManagerTest {

    @Test
    void getUnzipFileContent() {
        File zipFile = new File("src/test/resources/testZip.zip");
        ZipManager zipManager = new ZipManager(zipFile);
        String fileContent = zipManager.getUnzipFileContent("test.txt", "utf-8");
        assertEquals("test text!", fileContent);
    }

}