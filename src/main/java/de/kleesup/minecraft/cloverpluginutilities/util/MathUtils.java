package de.kleesup.minecraft.cloverpluginutilities.util;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 19.03.2022
 */
public class MathUtils {

    public static int clamp(final int min, final int max, final int value){
        return value < min ? min : Math.min(value, max);
    }
    public static long clamp(final long min, final long max, final long value){
        return value < min ? min : Math.min(value, max);
    }
    public static double clamp(final double min, final double max, final double value){
        return value < min ? min : Math.min(value, max);
    }
    public static float clamp(final float min, final float max, final float value){
        return value < min ? min : Math.min(value, max);
    }
    public static short clamp(final short min, final short max, final short value){
        return (short)(value < min ? min : Math.min(value, max));
    }
    public static byte clamp(final byte min, final byte max, final byte value){
        return (byte)(value < min ? min : Math.min(value, max));
    }



}

