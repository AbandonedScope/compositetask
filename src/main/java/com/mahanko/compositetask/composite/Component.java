package com.mahanko.compositetask.composite;

public interface Component {
    boolean addChild(Component child);
    boolean removeChild(Component child);
}
