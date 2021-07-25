package automation.utility;

import deersheep.automation.utility.PropertiesTool;

public class Utility {

    public static String getEnv() { return PropertiesTool.getProperty("environment", "env"); }

    public static String getBrowser() {
        return PropertiesTool.getProperty("environment", "browser");
    }

    public static String getMachine() {
        return PropertiesTool.getProperty("environment", "machine");
    }

    public static String getBuildNum() {
        return PropertiesTool.getProperty("buildNum", "build");
    }

    public static String getLoginEmail() { return PropertiesTool.getProperty("userinfo", "name"); }

    public static String getLoginPassword() { return PropertiesTool.getProperty("userinfo", "password"); }

}
