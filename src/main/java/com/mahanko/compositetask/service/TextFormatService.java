package com.mahanko.compositetask.service;


import com.mahanko.compositetask.composite.TextComposite;

public interface TextFormatService {
    void removeSentenceLessThan(TextComposite text, int wordAmount);
}
