package utility;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumManager {

    static AppiumDriverLocalService appiumDriverLocalService;
    static AppiumServiceBuilder appiumServiceBuilder;

    public static void startAppiumServer()
    {
        appiumDriverLocalService = AppiumDriverLocalService.buildDefaultService();
        appiumDriverLocalService.start();
    }

    public static String getAppiulURL()
    {
        return appiumDriverLocalService.getUrl().toString();
    }

    public static void stopAppiumServer()
    {
        appiumDriverLocalService.stop();
    }

    public static void main(String args[])
    {
        startAppiumServer();
        System.out.print(getAppiulURL());
        stopAppiumServer();
    }
}
