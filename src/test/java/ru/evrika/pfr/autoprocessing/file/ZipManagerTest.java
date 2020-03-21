package ru.evrika.pfr.autoprocessing.file;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Sergei Balashov on 21.03.2020.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ZipManagerTest {

    @Test
    void getUnzipFileContent() throws IOException {
        Resource stateFile = new ClassPathResource("testZip.zip");
        ZipManager zipManager = new ZipManager(stateFile.getFile());
        String fileContent = zipManager.getUnzipFileContent("test.txt", "utf-8");
        assertEquals("test text!", fileContent);
    }

}