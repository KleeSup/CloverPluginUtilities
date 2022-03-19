package de.kleesup.minecraft.cloverpluginutilities.io;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 19.03.2022
 */
public interface Backend<T> {

    /**
     * Checks whether data can be written to a {@link Backend} implementation
     * @return {@code true} if writing to backend is possible, {@code false} otherwise
     */
    boolean canWrite();

    /**
     * Checks whether data can be read from a {@link Backend} implementation
     * @return {@code true} if reading from backend is possible, {@code false} otherwise
     */
    boolean canRead();

}
