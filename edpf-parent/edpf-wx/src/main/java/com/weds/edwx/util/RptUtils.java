package com.weds.edwx.util;

import org.apache.commons.io.IOUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class RptUtils {

    public static String getTabInfo(String tableId) throws IOException {
        return getResourceInfo("rpt/" + tableId + ".json");
    }

    public static String getResourceInfo(String path) throws IOException {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("/" + path);
        if (is == null) {
            File file = ResourceUtils.getFile("classpath:" + path);
            is = new FileInputStream(file);
        }
        return IOUtils.toString(is);
    }
}
