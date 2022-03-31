package com.mahanko.compositetask.reader;

import com.mahanko.compositetask.exception.CustomCompositeException;

public interface CustomFileReader {
    public String read(String path) throws CustomCompositeException;
}
