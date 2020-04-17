package com.k.docker.jenkins.util;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class PathBaseUtil {
    public static String PRE_PATH;

    static {
        try {
            PRE_PATH = FileUtils.readFileToString(new File(PathUtil.getResource("txt/prefix.txt")), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}