package cpw.mods.fml.common;

import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.ReflectionHelper$UnableToAccessFieldException;
import cpw.mods.fml.relauncher.ReflectionHelper$UnableToFindFieldException;
import java.util.Arrays;
import java.util.logging.Level;

public class ObfuscationReflectionHelper
{
    public static boolean obfuscation;

    public static Object getPrivateValue(Class var0, Object var1, int var2)
    {
        try
        {
            return ReflectionHelper.getPrivateValue(var0, var1, var2);
        }
        catch (ReflectionHelper$UnableToAccessFieldException var4)
        {
            FMLLog.log(Level.SEVERE, var4, "There was a problem getting field index %d from %s", new Object[] {Integer.valueOf(var2), var0.getName()});
            throw var4;
        }
    }

    public static Object getPrivateValue(Class var0, Object var1, String ... var2)
    {
        try
        {
            return ReflectionHelper.getPrivateValue(var0, var1, var2);
        }
        catch (ReflectionHelper$UnableToFindFieldException var4)
        {
            FMLLog.log(Level.SEVERE, var4, "Unable to locate any field %s on type %s", new Object[] {Arrays.toString(var2), var0.getName()});
            throw var4;
        }
        catch (ReflectionHelper$UnableToAccessFieldException var5)
        {
            FMLLog.log(Level.SEVERE, var5, "Unable to access any field %s on type %s", new Object[] {Arrays.toString(var2), var0.getName()});
            throw var5;
        }
    }

    @Deprecated
    public static void setPrivateValue(Class var0, Object var1, int var2, Object var3)
    {
        setPrivateValue(var0, var1, var3, var2);
    }

    public static void setPrivateValue(Class var0, Object var1, Object var2, int var3)
    {
        try
        {
            ReflectionHelper.setPrivateValue(var0, var1, var2, var3);
        }
        catch (ReflectionHelper$UnableToAccessFieldException var5)
        {
            FMLLog.log(Level.SEVERE, var5, "There was a problem setting field index %d on type %s", new Object[] {Integer.valueOf(var3), var0.getName()});
            throw var5;
        }
    }

    @Deprecated
    public static void setPrivateValue(Class var0, Object var1, String var2, Object var3)
    {
        setPrivateValue(var0, var1, var3, new String[] {var2});
    }

    public static void setPrivateValue(Class var0, Object var1, Object var2, String ... var3)
    {
        try
        {
            ReflectionHelper.setPrivateValue(var0, var1, var2, var3);
        }
        catch (ReflectionHelper$UnableToFindFieldException var5)
        {
            FMLLog.log(Level.SEVERE, var5, "Unable to locate any field %s on type %s", new Object[] {Arrays.toString(var3), var0.getName()});
            throw var5;
        }
        catch (ReflectionHelper$UnableToAccessFieldException var6)
        {
            FMLLog.log(Level.SEVERE, var6, "Unable to set any field %s on type %s", new Object[] {Arrays.toString(var3), var0.getName()});
            throw var6;
        }
    }

    public static void detectObfuscation(Class var0)
    {
        obfuscation = !var0.getSimpleName().equals("World");
    }
}
