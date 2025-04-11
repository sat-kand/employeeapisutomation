package com.example.api.utils;

import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtil {

    //Utility class to parse the response as String
    public static String readFileAsString(String path) throws Exception {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}
