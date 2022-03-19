package de.kleesup.minecraft.cloverpluginutilities.io;

import de.kleesup.minecraft.cloverpluginutilities.util.Saveable;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 19.03.2022
 */
public interface KeyedBackend<K, V> extends Backend<V>, Saveable {

    /**
     * Checks whether a key is set in the backend and assigned with a value
     * @param key The key to check for
     * @return {@code true} if the key is set, {@code false} otherwise
     */
    boolean isSet(final K key);

    /**
     * Assigns a value for a given key in the {@link Backend} implementation
     * @param key The key to assign a value for
     * @param value The value
     * @return The old value that was previously assigned fot the key
     */
    V set(final K key, final V value);

    /**
     * Returns the assigned value for the given key
     * @param key The key to get its value for
     * @return The assigned value (could also be null in some implementations)
     */
    V get(final K key);

    /**
     * Removes a key and its assigned value from the backend
     * @param key The key to remove
     * @return The value that was assigned to the key
     */
    V remove(final K key);




}
