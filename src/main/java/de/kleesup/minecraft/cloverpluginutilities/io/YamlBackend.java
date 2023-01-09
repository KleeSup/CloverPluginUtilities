package de.kleesup.minecraft.cloverpluginutilities.io;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 19.03.2022
 */
public class YamlBackend extends KeyedFileBackend<String, Object> {

    private final YamlConfiguration configuration;
    public YamlBackend(File file, YamlConfiguration configuration) {
        super(file);
        if(configuration == null)throw new IllegalArgumentException("Configuration cannot be null!");
        this.configuration = configuration;
    }

    public YamlBackend(File file){
        this(file, YamlConfiguration.loadConfiguration(file));
    }

    @Override
    public boolean canWrite() {
        return configuration != null;
    }

    @Override
    public boolean canRead() {
        return configuration != null;
    }

    @Override
    public boolean isSet(String key) {
        return configuration.isSet(key);
    }

    @Override
    public Object set(String key, Object value) {
        final Object old = get(key);
        configuration.set(key,value);
        return old;
    }

    @Override
    public Object get(String key) {
        return configuration.get(key);
    }

    @Override
    public Object remove(String key) {
        return set(key,null);
    }

    @Override
    public void save() {
        try {
            configuration.save(file);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
