package ru.evrika.pfr.autoprocessing.file;

import java.io.File;
import java.util.List;

/**
 * Created by Sergei Balashov on 07.03.2020.
 */
public interface FileService {

    List<String> getAllFiles(String pathName);

    List<String> findAllFiles(String pathName, String maskPattern);

    boolean move(File file, String targetPath);

    boolean copy(File file, String targetPath);
}
