package TestScripts;

import maindriver.DriverFunction;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageobjects.*;
import utility.Constant;
import utility.DeviceList;
import utility.ReadExcel;

import java.io.FileNotFoundException;
import java.io.IOException;

public class GEHC extends DriverFunction {


    LoginPOM loginPOM;

    public void initialisePageObjects() {



        loginPOM = new LoginPOM(androidDriver);
        try {
            createrReport("GEHC", DeviceList.dname, DeviceList.id, DeviceList.osName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            ReadExcel.OpenExcel(Constant.ExcelFilepath);
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }

    }


    @Test(priority = 1)
    public void testOpenARTApp() throws InterruptedException {
        initialisePageObjects();
        startTest("Open ART APP", "Test to opens the app", "smoke");
        try {
            elementDisplayed(androidDriver, loginPOM.installupdate);
            tapButton(androidDriver,loginPOM.installupdate,false);
            Thread.sleep(4000);
        } catch (Exception e) {
        }
    }

    @Test(priority = 2)
    public void testSwipeCarousle() throws InterruptedException {
        startTest("Swipe Carousel", "test to check whether we can swipe carousel", "smoke");
        {
            waitForElementPresent(loginPOM.login, 60);
            try {
            //    elementDisplayed(androidDriver, loginPOM.login);
             //   elementDisplayed(androidDriver, loginPOM.ssologin);
              ///  elementDisplayed(androidDriver, loginPOM.Register);
            } catch (Exception e) {
                e.printStackTrace();
            }
            tapButton(androidDriver, loginPOM.ssologin, false);
            waitForElementPresent(loginPOM.region, 60);
            tapButton(androidDriver, loginPOM.region, false);
            tapButton(androidDriver, loginPOM.savebutton, false);
            waitForElementPresent(loginPOM.Username, 60);
            enterText(androidDriver, loginPOM.Username, "55555555");
            enterText(androidDriver, loginPOM.pwd, "55555555");
            Thread.sleep(5000);
            tapButton(androidDriver,loginPOM.loginButton,false);
            Thread.sleep(5000);
            publishReport();
        }

    }

    @AfterMethod
    public void getResult(ITestResult result) {
        try {
            getTestResult(androidDriver, result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
