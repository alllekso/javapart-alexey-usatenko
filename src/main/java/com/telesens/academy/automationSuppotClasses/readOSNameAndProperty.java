package com.telesens.academy.automationSuppotClasses;

public class readOSNameAndProperty {

    private static String OS = System.getProperty("os.name").toLowerCase();

    public static void main(String[] args) {
        ReadProperty prop = new ReadProperty();
        String propFile = "drivers.properties";
        System.out.println(OS);
        if (isWindows()) {
            String driverPath = prop.readProperty(propFile, "chromeHome.url");
//                String driverPath = prop.readProperty(propFile,"chromeWork.url");
//                String driverPath = prop.readProperty(propFile,"chromeMac.url");
            System.setProperty("webdriver.chrome.driver", driverPath);
            return;

        } else if (isMac()) {
            System.out.println("This is Mac");
        } else if (isUnix()) {
            System.out.println("This is Unix or Linux");
        } else {
            System.out.println("Your OS is not support!!");
        }
    }

    public static boolean isWindows() {

        return (OS.indexOf("win") >= 0);

    }

    public static boolean isMac() {

        return (OS.indexOf("mac") >= 0);

    }

    public static boolean isUnix() {

        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);

    }

    public static boolean isSolaris() {

        return (OS.indexOf("sunos") >= 0);

    }

}