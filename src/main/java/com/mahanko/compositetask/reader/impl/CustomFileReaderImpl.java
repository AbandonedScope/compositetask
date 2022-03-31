package com.mahanko.compositetask.reader.impl;

import com.mahanko.compositetask.exception.CustomCompositeException;
import com.mahanko.compositetask.reader.CustomFileReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomFileReaderImpl implements CustomFileReader {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public String read(String path) throws CustomCompositeException {
        String text = "";
        try (FileReader reader = new FileReader(path);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            while (bufferedReader.ready()) {
                text = text.concat(bufferedReader.readLine());
            }
        } catch (IOException e) {
            logger.log(Level.ERROR, e);
            throw new CustomCompositeException(e);
        }
        return text;
    }
}
