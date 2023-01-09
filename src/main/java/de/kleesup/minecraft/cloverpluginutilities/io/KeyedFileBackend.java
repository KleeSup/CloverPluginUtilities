package de.kleesup.minecraft.cloverpluginutilities.io;

import java.io.File;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 19.03.2022
 */
public abstract class KeyedFileBackend<K, V> implements KeyedBackend<K,V>  {

    protected File file;
    public KeyedFileBackend(final File file) {
        if(file == null)throw new IllegalArgumentException("File cannot be null!");
        this.file = file;
    }
    public KeyedFileBackend(final String file) {
        this(new File(file));
    }
    public KeyedFileBackend(final String parent, final String child) {
        this(new File(parent, child));
    }
}
