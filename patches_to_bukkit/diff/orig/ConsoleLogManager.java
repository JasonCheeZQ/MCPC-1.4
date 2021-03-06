package net.minecraft.server;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleLogManager
{
    /** Reference to the logger. */
    public static Logger a = Logger.getLogger("Minecraft");

    /**
     * Initialises the console logger.
     */
    public static void init()
    {
        ConsoleLogFormatter var0 = new ConsoleLogFormatter();
        a.setUseParentHandlers(false);
        ConsoleHandler var1 = new ConsoleHandler();
        var1.setFormatter(var0);
        a.addHandler(var1);

        try
        {
            FileHandler var2 = new FileHandler("server.log", true);
            var2.setFormatter(var0);
            a.addHandler(var2);
        }
        catch (Exception var3)
        {
            a.log(Level.WARNING, "Failed to log to server.log", var3);
        }
    }
}
