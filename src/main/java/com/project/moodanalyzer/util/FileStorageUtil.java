package com.project.moodanalyzer.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileStorageUtil {

    private static final String UPLOAD_DIR = "uploads/";

    // Save file temporarily
    public static File saveFile(MultipartFile file) throws IOException {
        File dir = new File(UPLOAD_DIR);
        if (!dir.exists()) dir.mkdirs();

        File savedFile = new File(dir, System.currentTimeMillis() + "-" + file.getOriginalFilename());
        file.transferTo(savedFile);
        return savedFile;
    }

    // Optional: delete a file
    public static boolean deleteFile(File file) {
        return file.delete();
    }
}
