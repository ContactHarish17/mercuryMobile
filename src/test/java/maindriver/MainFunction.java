package maindriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.PixelGrabber;
import java.io.*;
import java.text.SimpleDateFormat;
//import java.time.Duration;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.testng.Assert.assertEquals;


public class MainFunction {

    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;


    public static String workingDirectory = System.getProperty("user.dir");
    private static Date curDate = new Date();
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    public static String reportsFilePath = "./Reports";


    public static void createrReport(String reportname, String deviceName, String deviceId,String deviceOS) throws Exception
    {
        System.out.println("Inside the report method");
        try {
            Date curDate = new Date();
            System.out.println("date "+ curDate.toString());

            // String dateName = new SimpleDateFormat("hh:mm").format(new Date());


            String SubDirectory = "Reports";
            String ResultsPaths;

            ResultsPaths = createFolder(SubDirectory);
            File file = new File(ResultsPaths);
            System.out.println("the report path Folder is :- " + file.getAbsolutePath());


            htmlReporter = new ExtentHtmlReporter(file.getAbsolutePath() + File.separator + reportname + ".html");
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            htmlReporter.setAppendExisting(false);
            extent.setSystemInfo("Device ID", deviceId);
            extent.setSystemInfo("Firmware version", deviceOS);
            extent.setSystemInfo("Device Name ", deviceName);
            extent.setSystemInfo("Run Started on", curDate.toString());


            htmlReporter.config().setChartVisibilityOnOpen(true);
            htmlReporter.config().setDocumentTitle("ART Mobile App Android Report ");
            htmlReporter.config().setReportName("ART Mobile Automation Test Report");
            htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
            htmlReporter.config().setTheme(Theme.STANDARD);
            htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static void startTest(String testName, String testDecsription, String category) {
        try {
            test = extent.createTest(testName, testDecsription);
            test.assignCategory(category);
        } catch (Exception e) {

        }


    }

    public static void publishReport() {
        extent.flush();

    }


    public static void getTestResult(AppiumDriver<MobileElement> appiumDriver, ITestResult result) throws IOException{
        try {
            if (result.getStatus() == ITestResult.FAILURE) {

                test.fail(MarkupHelper.createLabel(result.getName() + " Test Case is FAILED", ExtentColor.RED));
                test.fail(result.getThrowable());
                try {
                    String screenshotPath = getScreenshot(appiumDriver, result.getName());
                    test.log(Status.FAIL,"Failed"+test.addScreenCaptureFromPath(screenshotPath));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (result.getStatus() == ITestResult.SUCCESS) {
                test.pass(MarkupHelper.createLabel(result.getName() + " Test Case is PASSED", ExtentColor.GREEN));

            } else if (result.getStatus() == ITestResult.SKIP) {
                test.skip(MarkupHelper.createLabel(result.getName() + " Test Case is SKIPPED", ExtentColor.YELLOW));
                test.skip(result.getThrowable());

            }
        } catch (NullPointerException e) {

        }

    }

    /**
     Function to enter the text into a textfeld
     @param, driverType, element and string that's need to be entered
     */

    public  static void enterText(AppiumDriver<MobileElement> appiumDriver, MobileElement element, String textkey)
    {
        try
        {
            element.sendKeys(textkey);
        }catch (Exception e){}
    }

    /**
     Function to check, whether given element is selected or not
     @param, drivertype, element name
     */
    public  static boolean elementIsSelected(AppiumDriver<MobileElement> appiumDriver, MobileElement element)
    {
        if(element.isSelected())
        {
            test.log(Status.INFO,"Eelement selected");
            return true;

        } else {
            test.log(Status.INFO,"Eelement not selected");
            return false;

        }
    }


    /**
     Function to scroll on TopStories - Videos and Stories carousel
     @param, driverType, element and path for screenshot to be taken

     */

    public  static void scrolltoEndofStories(AppiumDriver<MobileElement> appiumDriver, MobileElement element,
                                             String elements[],MobileElement element2
    ) {
        boolean flag = false;
        for (int i = 0; i <= 20; i++) {
            try {
                String element_title=element.getText();
                test.log(Status.INFO,element_title);
                for(int j=0;j<elements.length;j++)
                {
                    isElementPresent(appiumDriver, By.id(elements[j]));
                    test.log(Status.PASS, elements[j].toString());
                }
                element2.isDisplayed();
                break;
            } catch (Exception e) {

                horizontalSwipe(appiumDriver);

            }

        }
    }


    /**
     Function to scroll on TopStories - Videos and Stories carousel
     @param, driverType, element and path for screenshot to be taken

     */

    public  static void scrollHorizontal(AppiumDriver<MobileElement> appiumDriver,MobileElement element) {

        for (int i = 0; i <= 10; i++) {
            try {
                element.isDisplayed();
                break;
            } catch (Exception e) {

                horizontalSwipe(appiumDriver);

            }

        }
    }


    /**
     * Appium Android default method
     * even though the AndroidKeycode is deprected in latest appium and java client
     *
     * @param, androidDriver, only works with Android
     */

    public static void navigateBack(AndroidDriver<MobileElement> androiddriver) {
        androiddriver.pressKey(new KeyEvent(AndroidKey.BACK));

    }


    /**
     * function to check whether WiFi Connection enabled or not.
     * If not, enables the WiFi Connection
     * @param androidDriver
     */

    public static void checkConnection(AndroidDriver<MobileElement> androidDriver)
    {
        try
        {
            ConnectionState state = androidDriver.setConnection(new ConnectionStateBuilder()
                    .withWiFiEnabled()
                    .build());
            System.out.println("The WiFi Status is "+ state.isWiFiEnabled());
            if(!state.isWiFiEnabled())
            {
                androidDriver.setConnection(state);
            }}catch (NullPointerException e)
        {

        }
    }



    /**
     wait method
     */
    public static  void sleepmethod(long seconds)
    {
        try
        {
            Thread.sleep(seconds);}catch (Exception e){}
    }




    /**
     * Function on click on any button or link on the app
     *
     * @param, driverType, element Type
     * boolean to take screenshot ( true = takes screenshot and attached to testReport, fail= wont take screenshot)
     * Screenshot path
     */
    public static void tapButton(AppiumDriver<MobileElement> appiumDriver, MobileElement element, boolean takescreenshot) {
        try {

            element.click();
            Thread.sleep(800);
            if (takescreenshot==true) {
                String screenshotpath = getScreenshot(appiumDriver, element.getText());
                System.out.println("Taken Screenshotpath is " + screenshotpath);
                test.log(Status.INFO, "Screenshot Attached:-" +
                        test.addScreenCaptureFromPath(screenshotpath));

            } else {

            }
        } catch (Exception e) {
        }

    }


    /**
     * Function to check whether an element is displayed , return true if present else fail
     * If true, then the element text will be attached the report name. If element text not present, it uses the
     * element attribute
     *
     * @param, drivertype, element name
     */

    public static void elementDisplayed(AppiumDriver<MobileElement> appiumDriver, MobileElement element) throws Exception {

        try {
            waitForScreenToLoad(appiumDriver, element, 6);
            Assert.assertTrue(element.isDisplayed());
            if (element.isDisplayed())
            {
                // if (element.getText().length() <= 0)
                if(element.getText().isEmpty())
                {
                    test.log(Status.PASS, element.getAttribute("contentDescription") + "  Displayed");
                } else {
                    test.log(Status.PASS, element.getText() + "  Displayed");
                }

            } else {
                test.log(Status.FAIL, element.getText() + "  isn't Displayed");
            }


        } catch (AssertionError e) {
            e.printStackTrace();
            org.testng.Assert.fail();
        }
    }


    public static void linksDisplayed(AppiumDriver<MobileElement> driver, MobileElement element) throws Exception {

        try {

            if (element.isDisplayed()) {
                if (element.getText().length() <= 0) {
                    test.log(Status.PASS, element.getAttribute("contentDescription") + "  Displayed");
                } else {
                    test.log(Status.PASS, element.getText() + "  Displayed");
                }

            } else {
                test.log(Status.FAIL, element.getText() + "  isn't Displayed");
            }

        } catch (Exception e) {

        }
    }


    public static boolean elementPresent(MobileElement element)
    {

        if(element.isDisplayed())
        {
            return true;
        }else {
            return false;
        }


    }

    /**
     Function to wait until the screen is fully loaded
     @param, drivertype , element and seconds to wait for page to load
     */

    public static void waitForScreenToLoad(AppiumDriver<MobileElement> driver, MobileElement element, int seconds) {

        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOf(element));

    }


    /**
     * @param, drivertype, screenshot path, screenshot name
     * attaches the screenshot to the test report
     */

    public static String capture_ScreenShots(AppiumDriver<MobileElement> driver, String screenshot_path, String screenshot_name) {

        try {
            String dateName = new SimpleDateFormat("dd-M-yyyy hh:mm").format(new Date());
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String dest = screenshot_path + File.separator + screenshot_name + "_" + dateName + ".png";
            System.out.println("Screenshot path name:------" + dest);
            File destination = new File(dest);
            FileUtils.copyFile(source, destination);
            System.out.println("ScreenShot Taken");
            return dest;
        } catch (Exception e) {
            System.out.println("Exception While Taking screenshot" + e.getMessage());
            return e.getMessage();
        }

    }


    /**
     * Function to check whether an Element is present or not
     */

    public static boolean isElementPresent(AppiumDriver<MobileElement> appiumDriver, By locatorKey) {
        try {
            appiumDriver.findElement(locatorKey);
            test.log(Status.PASS,appiumDriver.findElement(locatorKey).getText() +"Element Present");
            return true;

        }

        catch (NoSuchElementException e) {
            test.log(Status.INFO,appiumDriver.findElement(locatorKey).getText() +"Element Not Present");
            return false;
        }
        // return false;
    }

    /**
     function to get the element text
     @param, drivertype and element
     */

    public  static String getText(MobileElement element)
    {
        return element.getText();
    }


    /**
     * @param, drivertype, screenshot path, screenshot name
     * attaches the screenshot to the test report
     */
    private static String getScreenshot(AppiumDriver<MobileElement> appiumdriver, String screenshotName) throws IOException {

        String SubDirectory = "Screenshots";
        String ScreenshotPaths;

        try {
            String dateName = new SimpleDateFormat("dd-M-yyyy hh:mm").format(new Date());
            TakesScreenshot ts = (TakesScreenshot) appiumdriver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            ScreenshotPaths = createFolder(SubDirectory);
            File file = new File(ScreenshotPaths);
            System.out.println("the ScreenShot  Folder is :- " + file.getAbsolutePath());

            String dest = file.getAbsolutePath() + File.separator + screenshotName+".png";
            System.out.println("Screenshot path name:------" + dest);
            File destination = new File(dest);
            FileUtils.copyFile(source, destination);
            System.out.println("ScreenShot Taken");
            return dest;
        } catch (Exception e) {
            System.out.println("Exception While Taking screenshot" + e.getMessage());
            return e.getMessage();
        }

    }


    /**
     Function to create a folder with the project path
     @param, Directory path
     */
    public  static String createFolder(String path)
    {
        String strManyDirectories=null;
        try{
            //  String strDirectoy = path;
            strManyDirectories= path;

            // Create one directory
            boolean
                    // Create multiple directories
                    success = (new File(strManyDirectories)).mkdirs();
            if (success) {
                System.out.println("Directories: "
                        + strManyDirectories + " created");
            }

        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
        return strManyDirectories;
    }

    /**
     * Function to scroll to an element, if the list if very big
     *
     * @param, driverType, element to be scrolled, screenshot
     */
    public  static void scrolltoElement(AppiumDriver<MobileElement> appiumDriver, MobileElement element) {
        boolean flag = false;
        String element_title = null;
        for (int i = 0; i <= 20; i++) {
            try {
                element_title = element.getText();
                element.isDisplayed();
                test.log(Status.INFO, "Text " + element_title);
//                logger.log(LogStatus.INFO, "Snapshot below: "
//                        + logger.addScreenCapture(capture_ScreenShots(appiumDriver,Screenshotname)));
                // element.click();
                break;
            } catch (Exception e) {
                verticalSwipe(appiumDriver, "Down");
            }

        }
    }

    /**
     * Function to scroll to an element, if the list if very big
     *
     * @param, driverType, element to be scrolled, screenshot
     */
    public  static void scrolltoElementUp(AppiumDriver<MobileElement> appiumDriver, MobileElement element) {
        boolean flag = false;
        String element_title = null;
        for (int i = 0; i <= 20; i++) {
            try {
                element_title = element.getText();
                element.isDisplayed();
                test.log(Status.INFO, "Text " + element_title);
//                logger.log(LogStatus.INFO, "Snapshot below: "
//                        + logger.addScreenCapture(capture_ScreenShots(appiumDriver,Screenshotname)));
                // element.click();
                break;
            } catch (Exception e) {
                verticalSwipe(appiumDriver, "Down");
            }

        }
    }
    /**
     * Function to seek the video, you need pass the percentage of seeking
     * @param driver
     * @param element
     * @param d
     * @throws InterruptedException
     */


    public static void videoplaybackseeking(AppiumDriver<MobileElement> driver, MobileElement element, double d) throws InterruptedException
    {
        int startX = element.getLocation().getX();
        System.out.println("Startx :" + startX);

        int endX = element.getSize().getWidth();
        System.out.println("Endx  :" + endX);
        System.out.println("Endx  :" + endX);

        int yAxis = element.getLocation().getY();
        System.out.println("Yaxis  :" + yAxis);

        int moveToXDirectionAt = (int) (endX * d);
        System.out.println("Moving seek bar at " + moveToXDirectionAt + " In X direction.");
        Thread.sleep(3000);

        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(startX, yAxis))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .moveTo(PointOption.point(moveToXDirectionAt, yAxis)).release().perform();
    }


    /**
     Function to seek horizontal on the app.
     Yaxis remains horizontal
     StartXaxis and endXaxis are the two main parameters to swipe vertically
     @param, driverType

     */
    public  static void horizontalSwipe(AppiumDriver<MobileElement> driver)
    {
        org.openqa.selenium.Dimension dimension = driver.manage().window().getSize();
        int height = dimension.getHeight();
        int width = dimension.getWidth();
        int startXaxis = (int)(width*0.90);
        int Yaxis = (int)(height*0.20);
        int endXaxis = (int)(width*0.10);



        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(startXaxis, Yaxis))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endXaxis, Yaxis)).release().perform();
    }

    public  static void swipeElement(AppiumDriver<MobileElement> driver, MobileElement element)
    {
        int startX = element.getLocation().getX();
        System.out.println("The Startx is :-" + startX);
        int endX = element.getSize().getWidth()/2;
        System.out.println("The endX is :-" + endX);
        int yAxis = element.getLocation().getY();
        System.out.println("The yAxis is :-" + yAxis);

        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(endX, yAxis))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000)))
                .moveTo(PointOption.point(startX, yAxis)).release().perform();
    }



    /**
     Function to swipe from top to bottom .
     Startx remains constant
     StartY and EndY are the two main parameters to swipe vertically
     @param, driverType

     */

    public  static void verticalSwipe(AppiumDriver<MobileElement> driver, String swipingdirection)
    {
        org.openqa.selenium.Dimension dimension = driver.manage().window().getSize();
        int height = dimension.getHeight();
        int width = dimension.getWidth();
        int startX = width/2;
        int startY = (int)(height*0.75);
        int endY = (int)(height*0.35);
        if(swipingdirection.equalsIgnoreCase("Down")) {
            TouchAction action = new TouchAction(driver);
            action.press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                    .moveTo(PointOption.point(startX, endY)).release().perform();
        }else if(swipingdirection.equalsIgnoreCase("Up")){
            TouchAction action = new TouchAction(driver);
            action.press(PointOption.point(startX, endY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                    .moveTo(PointOption.point(startX, startY)).release().perform();
        }
    }



    /**
     * Function to compare the images by pixel
     * @param
     * @param
     */


    public static void processImage(String expected,String actual)
    {
        Image imagesrc =  Toolkit.getDefaultToolkit().getImage(expected);
        Image imagecom =  Toolkit.getDefaultToolkit().getImage(actual);

        try
        {
            PixelGrabber grab1 = new PixelGrabber(imagesrc, 0, 0, -1, -1, false);
            PixelGrabber grab2 = new PixelGrabber(imagecom, 0, 0, -1, -1, false);

            int[] data1 = null;

            if (grab1.grabPixels())
            {
                int width = grab1.getWidth();
                int height = grab1.getHeight();
                data1 = new int[width * height];
                data1 = (int[]) grab1.getPixels();
            }

            int[] data2 = null;

            if (grab2.grabPixels()) {
                int width = grab2.getWidth();
                int height = grab2.getHeight();
                data2 = new int[width * height];
                data2 = (int[]) grab2.getPixels();
            }

            System.out.println("Pixels equal: " + Arrays.equals(data1, data2));
            test.log(Status.INFO, "Pixels equal: " + Arrays.equals(data1, data2));

        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }


    /**
     * Function to compare two images and display the diffrence
     * @param fileA
     * @param fileB
     * @return
     */
    public  static float compareImage(File fileA, File fileB)
    {

        float percentage = 0;
        try {
            // take buffer data from both image files //
            BufferedImage biA = ImageIO.read(fileA);
            DataBuffer dbA = biA.getData().getDataBuffer();
            int sizeA = dbA.getSize();
            BufferedImage biB = ImageIO.read(fileB);
            DataBuffer dbB = biB.getData().getDataBuffer();
            int sizeB = dbB.getSize();
            int count = 0;
            // compare data-buffer objects //
            if (sizeA == sizeB) {

                for (int i = 0; i < sizeA; i++) {

                    if (dbA.getElem(i) == dbB.getElem(i)) {
                        count = count + 1;
                    }

                }
                percentage = (count * 100) / sizeA;
                System.out.println("Image Difference Percentage --> :- " + percentage);
                test.log(Status.PASS,"Image Difference Percentage --> :- " + percentage);

            } else {
                System.out.println("Both the images are not of same size");
                // test.log(Status.FAIL,"Both the images are not of same size");
            }

        } catch (Exception e) {
            System.out.println("Failed to compare image files ...");
        }
        return percentage;
    }


    /**
     * Returns all png images from a directory in an array.
     *
     * @param directory                 the directory to start with
     * @param descendIntoSubDirectories should we include sub directories?
     * @return an ArrayList<String> containing all the files or nul if none are found..
     * @throws IOException
     */
    public static  ArrayList<String> getAllImages(File directory, boolean descendIntoSubDirectories) throws IOException {
        ArrayList<String> resultList = new ArrayList<String>(256);
        File[] f = directory.listFiles();
        for (File file : f) {
            if (file != null && file.getName().toLowerCase().endsWith(".png"))
            {
                resultList.add(file.getCanonicalPath());
            }
            if (descendIntoSubDirectories && file.isDirectory()) {
                ArrayList<String> tmp = getAllImages(file, true);
                if (tmp != null) {
                    resultList.addAll(tmp);
                }
            }
        }
        if (resultList.size() > 0)
            return resultList;
        else
            return null;
    }

    /**
     Function to seek forward on the video/audio playing
     @param, driverType, Element type
     double the seeking position ex(.30) means 30% seek
     */

    public static void seeking(AppiumDriver<MobileElement> driver, MobileElement element, double d, String seekingtype) throws InterruptedException
    {
        int startX = element.getLocation().getX();
        int endX = element.getSize().getWidth();
        int yAxis = element.getLocation().getY();
        int moveToXDirectionAt = (int) (endX * d);

        if(seekingtype.equalsIgnoreCase("forward")) {
            TouchAction action = new TouchAction(driver);
            action.press(PointOption.point(startX, yAxis))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                    .moveTo(PointOption.point(moveToXDirectionAt, yAxis)).release().perform();

        }else  if(seekingtype.equalsIgnoreCase("backward")) {
            TouchAction action = new TouchAction(driver);
            action.press(PointOption.point(endX, yAxis))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                    .moveTo(PointOption.point(moveToXDirectionAt, yAxis)).release().perform();
        }

    }



    /**
     * Function which compare the images
     *
     * @throws IOException
     */

    public static void comparetwoimages() throws IOException
    {
        File expected = new File("./Screenshots/Before");
        File actual = new File("./Screenshots/After");

        ArrayList<String> expectedresults = new ArrayList<>();
        expectedresults = getAllImages(expected,false);
        String expectedimages[] = expectedresults.toArray(new String[expectedresults.size()]);

        ArrayList<String> actualresults = new ArrayList<>();
        actualresults = getAllImages(actual,false);
        String actualimages[] = actualresults.toArray(new String[actualresults.size()]);
        for(int i=0;i<expectedimages.length && i<actualimages.length;i++)
        {
            System.out.println("Expected Image :="+expectedimages[i]);
            System.out.println("Actual Image :="+actualimages[i]);

            compareImage(new File(expectedimages[i]), new File(actualimages[i]));
            processImage(expectedimages[i], actualimages[i]);

//            if(expectedresults.get(i).toString().equalsIgnoreCase(actualresults.get(i).toString()))
//            {
//
//                BufferedImage expectedImage = ImageIO.read(new File(expectedresults.get(i)));
//                BufferedImage actula_image = ImageIO.read(new File(actualresults.get(i)));
//                ImageDiffer imagediffer = new ImageDiffer();
//                ImageDiff diff = imagediffer.makeDiff(expectedImage, actula_image);
//                if(diff.hasDiff()!=true)
//                {
//                    System.out.println("Images are Same" );
//                    test.log(Status.PASS,"Image are same");
//                }else{
//                    System.out.println("Images aren't Same");
//                    test.log(Status.PASS,"Image aren't same");
//                }
//            }

        }
    }


    /**
     *
     * @param locator
     * @return
     */

//    public static ExpectedCondition<Boolean> elementFoundAndClicked(By locator) {
//        return new ExpectedCondition<Boolean>() {
//            @Override
//            public Boolean apply(WebDriver driver) {
//                MobileElement el = driver.findElement(locator);
//                el.click();
//                return true;
//            }
//        };
//    }

    /**
     *function to drag and drop an element
     * @param androidDriver
     * @param elementfrom
     * @param elementto
     */

    public static void elementdragdrop(AndroidDriver<MobileElement> androidDriver, MobileElement elementfrom, MobileElement elementto) {
        TouchAction action = new TouchAction((MobileDriver) androidDriver);
        action.longPress(ElementOption.element(elementfrom)).
                moveTo(ElementOption.element(elementto)).release().perform();

    }


    /**
     *function to read the text from a recyclerview
     * @param androidDriver
     */
    public static void readRecyclerView(AndroidDriver<MobileElement> androidDriver, String text)
    {

        List<MobileElement> elements = androidDriver.findElementByClassName("android.support.v7.widget.RecyclerView").findElements(By.id("bbc.mobile.news.uk.internal:id/text"));
        for(MobileElement element : elements)
        {
            //System.out.println("Topics After  Re-Ordering :- "+element.getText());
            test.log(Status.INFO,text + element.getText());
        }
    }


    /**
     *
     * @param csv
     * @param statsdata
     * @throws InterruptedException
     * @throws IOException
     */

    public static void comapreStatsData(String csv, String[] statsdata) throws InterruptedException, IOException {

        //  String csvFile = "/Users/ramakh02/Desktop/AppiumBBCNewsAndroid/sesson.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        String cvssplit = "&";
        String[] country = null;
        String[] staturl = null;
        // ArrayList<String> list = new ArrayList();
        try {

            br = new BufferedReader(new FileReader(csv));
            while ((line = br.readLine()) != null)
            {
                // use comma as separator
                country = line.split(cvsSplitBy);
                staturl = country[0].split("&");
                //  System.out.println("Stat's URL " + country[0]);




                for (int i = 0; i < staturl.length; i++)
                {

                    //System.out.println("The New Generated Stats " + staturl[i]);
                    for (int j = 0; j < statsdata.length; j++)
                    {
                        if (staturl[i].equalsIgnoreCase(statsdata[j]))
                        {
                            assertEquals(staturl[i], statsdata[j], "Stat's Matched");
                            String matchedstats = staturl[i];
                            test.log(Status.PASS,"Stat's are :-" + matchedstats.replaceAll("[-+^:,%2E5BD3AF]", ""));
                            System.out.println("The New Generated Stats " + matchedstats.replaceAll("[-+^:,%2E5BD3AF]", ""));

                            //test.log(Status.PASS,"Stat's are :-" + matchedstats.replaceAll("[^a-zA-Z0-9 ]", "="));
                            // System.out.println("The New Generated Stats " + matchedstats);//list.add(staturl[i].toString()));
                        }
                    }

                }

            }

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();

        } finally
        {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }

    }

    public static void textpresent(AppiumDriver<MobileElement> appiumDriver,String text, String text1) throws Exception {
        //  MobileElement textpresent = appiumDriver.findElement(By.xpath("//[android.widget.TextView[@text='"+text+"'"+text1+"' My News']"));

        MobileElement textpresent = appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='"+text+" "+text1+" "+"My News']"));
        test.log(Status.PASS, "Element Present");

    }


    /**
     Function to empty the  folder
     */
    public static void emptyFolder(String filepath)
    {

        File file = new File(filepath);
        String[] myFiles;
        if (file.isDirectory()) {
            myFiles = file.list();
            for (int i = 0; i < myFiles.length; i++) {
                File myFile = new File(file, myFiles[i]);
                myFile.delete();
            }
        }
    }


    /**
     * Function to check whether an Element is present or not
     */

    public static boolean ElementPresent(AppiumDriver<MobileElement> appiumDriver, By locatorKey) {
        try {
            appiumDriver.findElement(locatorKey);
            return true;
        }
        catch (NoSuchElementException e) {
            test.log(Status.INFO,appiumDriver.findElement(locatorKey).getText() +"Element Not Present");
            return false;
        }
        // return false;
    }


    /**
     *
     * @param appiumDriver
     * @param elementID
     */
    public static void getElements(AppiumDriver<MobileElement> appiumDriver, String elementID)
    {
        List<MobileElement> Elements = new ArrayList<MobileElement>();
        Elements = appiumDriver.findElements(By.id(elementID));
        System.out.println("The elements counts are" + Elements.size());
        for(int i=0;i<Elements.size();i++)
        {
            System.out.println("The Text are "+ Elements.get(i).getText());
        }
    }



    public static void comapre_StatsData(String csvfile , String statsdata[]) throws InterruptedException, IOException {

        // String csvFile = "./CharlesFolder/BBCNews.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        String[] country = null;
        String[] staturl = null;
        ArrayList<String> aListColors = new ArrayList<String>();
        try {

            br = new BufferedReader(new FileReader(csvfile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                country = line.split(cvsSplitBy);
                staturl = country[0].split("&");
                for (int i = 0; i < staturl.length; i++) {
                    if (!aListColors.contains(staturl[i])) {
                        aListColors.add(staturl[i]);
                    }
                }
            }

            staturl = aListColors.toArray(new String[aListColors.size()]);
            for (int i = 0; i < staturl.length; i++)
            {
                for (int j = 0; j < statsdata.length; j++) {
                    if (staturl[i].equalsIgnoreCase(statsdata[j])) {
                        String matchedstats = staturl[i];
                        System.out.println("The New Generated Stats " + matchedstats.replaceAll("[-+^:,%2E5BD3AF]", ""));
                    }
                }
            }




        }catch (FileNotFoundException e)
        {
            e.printStackTrace();

        } finally
        {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }

    }






    /**

     * This function will take screenshot

     //* @param androidDriver

     * @param fileWithPath

     * @throws Exception

     */

    public static  File takeSnapShot(AppiumDriver<MobileElement> appiumDriver,String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)appiumDriver);

        //Call getScreenshotAs method to create image file

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

        File DestFile=new File(fileWithPath);

        //Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);

        return DestFile;

    }


    public void selectBirthyear(AppiumDriver<MobileElement> appiumDriver, String year) throws Exception
    {
        try {
            scrolltoElementUp(appiumDriver,appiumDriver.findElement(By.xpath("//android.widget.TextView[@text="+year+"]")));
            appiumDriver.findElement(By.xpath("//android.widget.TextView[@text="+year+"]")).click();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }



    public  File takeScreenshot(ITestResult result, AppiumDriver appiumDriver) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        TakesScreenshot screenShot = (TakesScreenshot) appiumDriver;
        File srcFile = screenShot.getScreenshotAs(OutputType.FILE);
        File destFile=new File("screenshots/"+timeStamp+"_"+ result.getName() +".png");
        FileUtils.copyFile(srcFile, destFile);
        return destFile;
    }

}
