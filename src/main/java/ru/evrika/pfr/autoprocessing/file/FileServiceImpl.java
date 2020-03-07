package ru.evrika.pfr.autoprocessing.file;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.RegexFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Timid on 19.12.2015.
 */
@Slf4j
@Service
public class FileServiceImpl implements FileService {

    @Override
    public List<String> getAllFiles(String pathName) {
        File path = new File(pathName);

        if (!path.exists()) {
            log.debug("Path [{}] is not exist", pathName);
            return Collections.emptyList();
        }
        Collection<File> files = FileUtils.listFiles(path, TrueFileFilter.TRUE, TrueFileFilter.TRUE);
        if (files.isEmpty()) {
            log.debug("Files in path [{}] not found", pathName);
            return Collections.emptyList();
        }
        return files.stream().map(File::getName).collect(Collectors.toList());
    }

    @Override
    public List<String> findAllFiles(String pathName, String maskPattern) {
        if(StringUtils.isBlank(pathName)) {
            throw new RuntimeException("PathName must be present!");
        }
        if(StringUtils.isBlank(maskPattern)) {
            throw new RuntimeException("MaskPattern must be present!");
        }

        File path = new File(pathName);

        if (!path.exists()) {
            log.warn("Path [{}] does not exist", pathName);
            throw new RuntimeException("Path does not exist");
        }
        Collection<File> files = FileUtils.listFiles(path, new RegexFileFilter(maskPattern), TrueFileFilter.TRUE);
        if (files.isEmpty()) {
            log.info("Files with mask [{}] not found in path [{}] ", maskPattern, pathName);
            return Collections.emptyList();
        }
        return files.stream().map(File::getName).collect(Collectors.toList());
    }

    @Override
    public boolean move(File file, String targetPath) {
        try {
            FileUtils.moveFile(file, new File(targetPath));
            return true;
        } catch (IOException e) {
            log.info("File [{}] can not moved in the path [{}] ", file.getName(), targetPath);
            return false;
        }
    }

    @Override
    public boolean copy(File file, String targetPath) {
        try {
            FileUtils.copyFile(file, new File(targetPath));
            return true;
        } catch (IOException e) {
            log.info("File [{}] can not copied in the path [{}] ", file.getName(), targetPath);
            return false;
        }
    }
}
