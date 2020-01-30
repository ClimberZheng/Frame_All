package com.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class EnviorData {

    public static String comPicSavePath;
    public static String projectPath = new File("").getAbsolutePath();

    @Autowired
    public EnviorData(@Value("${file.upload.path}") String comPicSavePath) {
        EnviorData.comPicSavePath = comPicSavePath;
    }
}
