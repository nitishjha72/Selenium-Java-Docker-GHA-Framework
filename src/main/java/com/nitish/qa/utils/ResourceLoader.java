package com.nitish.qa.utils;

import com.nitish.qa.exceptions.FrameworkException;
import com.nitish.qa.exceptions.InvalidPathOfFileException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public final class ResourceLoader {

    private ResourceLoader() {}

    public static InputStream getResourceStream(String fileFullPath) {
        if(fileFullPath.isEmpty()) {
            throw new InvalidPathOfFileException("Resource path cannot be empty");
        }
        InputStream inputStream = ResourceLoader.class.getClassLoader().getResourceAsStream(fileFullPath);
        if(Objects.nonNull(inputStream)) {
            System.out.println("Resource found in classpath: "+fileFullPath);
            return inputStream;
        }
        try {
            return Files.newInputStream(Path.of(fileFullPath));
        } catch (IOException e) {
            throw new FrameworkException("Issues occurred while finding file: "+fileFullPath,e);
        }
    }

}
