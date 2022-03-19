package de.kleesup.minecraft.cloverpluginutilities.util;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 19.03.2022
 *
 * A class that helps to manage cooldowns for certain functions.
 */
public class Cooldown implements ConfigurationSerializable {

    private static final long DEFAULT_NULL_VALUE = -1;
    public static Cooldown deserialize(final Map<String, Object> map){
        if(map == null)throw new NullPointerException("Map for deserialization cannot be null!");
        if(!map.containsKey("cooldown"))throw new IllegalArgumentException("The deserialization-map must contain the cooldown!");
        return new Cooldown(map);
    }

    private long startMillis = DEFAULT_NULL_VALUE;
    private final long cooldown;
    private final TimeUnit timeUnit;
    public Cooldown(final long cooldown, final TimeUnit timeUnit){
        this.cooldown = cooldown;
        this.timeUnit = timeUnit;
    }
    //deserialization
    private Cooldown(final Map<String, Object> map){
        this.startMillis = map.containsKey("start") ? (long) map.get("start") : DEFAULT_NULL_VALUE;
        this.cooldown = (long) map.get("cooldown");
        this.timeUnit = TimeUnit.valueOf((String) map.get("timeunit"));
    }

    /**
     * Starts the cooldown.
     * @return {@code true} if the cooldown had already been started, {@code false} otherwise
     */
    public boolean start(){
        if(startMillis != DEFAULT_NULL_VALUE)return true;
        this.startMillis = System.currentTimeMillis();
        return false;
    }

    /**
     * Resets the cooldown.
     */
    public void reset(){
        this.startMillis = DEFAULT_NULL_VALUE;
    }

    /**
     * Resets the cooldown and starts it again.
     */
    public void resetAndStart(){
        reset();
        start();
    }

    /**
     * Checks if the cooldown had already been started.
     * @return {@code true} if the cooldown was already started, {@code false} otherwise
     */
    public boolean hasStarted(){
        return startMillis != DEFAULT_NULL_VALUE;
    }

    /**
     * Checks if the cooldown is active.
     * @return {@code true} if the cooldown is still active, {@code false} if it was not started yet or isn't active anymore
     */
    public boolean isActive(){
        return startMillis != DEFAULT_NULL_VALUE && System.currentTimeMillis() - startMillis >= timeUnit.toMillis(cooldown);
    }

    /**
     * Returns the cooldown time.
     * @return The cooldown time.
     */
    public long getCooldown() {
        return cooldown;
    }

    /**
     * Returns the TimeUnit which parses the {@link Cooldown#getCooldown()} into milliseconds for calculation.
     * @return The TimeUnit
     */
    public TimeUnit getTimeUnit() {
        return timeUnit;
    }


    @Override
    public String toString() {
        return "Cooldown{"+
                "startMillis="+startMillis+"," +
                "cooldown="+cooldown+"("+timeUnit.toMillis(cooldown)+"millis)," +
                "timeunit="+timeUnit+"}";
    }

    @Override
    public @NotNull Map<String, Object> serialize() {
        final Map<String, Object> map = new HashMap<>();
        if(startMillis != DEFAULT_NULL_VALUE)map.put("start", startMillis);
        map.put("cooldown", cooldown);
        map.put("timeunit", timeUnit.name());
        return map;
    }
}
