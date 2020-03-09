package ru.evrika.pfr.autoprocessing.file;

import java.util.List;

/**
 * Created by Sergei Balashov on 07.03.2020.
 */
public interface FileService {

    List<String> getAllFiles(String pathName);

    List<String> findAllFiles(String pathName, String maskPattern);

    boolean move(String fileName, String targetPath);

    boolean copy(String fileName, String targetPath);

    boolean create(String content, String fileName);
}
