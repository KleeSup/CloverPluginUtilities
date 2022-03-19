package de.kleesup.minecraft.cloverpluginutilities.util;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 19.03.2022
 */
public class PluginHelper {

    public static boolean isInt(final String string){
        try {
            Integer.parseInt(string);
            return true;
        }catch (NumberFormatException ignored){
            return false;
        }
    }
    public static boolean isLong(final String string){
        try {
            Long.parseLong(string);
            return true;
        }catch (NumberFormatException ignored){
            return false;
        }
    }
    public static boolean isDouble(final String string){
        try {
            Double.parseDouble(string);
            return true;
        }catch (NumberFormatException ignored){
            return false;
        }
    }
    public static boolean isFloat(final String string){
        try {
            Float.parseFloat(string);
            return true;
        }catch (NumberFormatException ignored){
            return false;
        }
    }
    public static boolean isShort(final String string){
        try {
            Short.parseShort(string);
            return true;
        }catch (NumberFormatException ignored){
            return false;
        }
    }
    public static boolean isByte(final String string){
        try {
            Byte.parseByte(string);
            return true;
        }catch (NumberFormatException ignored){
            return false;
        }
    }

}
