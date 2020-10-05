package maindriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class CommonFunctions {


    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;


    public static String workingDirectory = System.getProperty("user.dir");
    private static Date curDate = new Date();
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    public static String reportsFilePath = "./Reports";
    public static String screenpath = "./Screenshots";


    public static void createrReport(String reportname, String browserName, String browserversion, String browserOS) throws Exception {
        System.out.println("Inside the report method");
        try {
            Date curDate = new Date();
            System.out.println("date " + curDate.toString());

            // String dateName = new SimpleDateFormat("hh:mm").format(new Date());

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();

            String SubDirectory = "Reports";
            String ResultsPaths;

            ResultsPaths = createFolder(SubDirectory);
            File file = new File(ResultsPaths);
            System.out.println("the report path Folder is :- " + file.getAbsolutePath());


            htmlReporter = new ExtentHtmlReporter(file.getAbsolutePath() + File.separator + reportname + ".html");
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            htmlReporter.setAppendExisting(false);
            extent.setSystemInfo("browser name ", browserName);
            extent.setSystemInfo("browser version", browserversion);
            extent.setSystemInfo("browser OS ", browserOS.toString());
            extent.setSystemInfo("Run Started on", curDate.toString());


            htmlReporter.config().setChartVisibilityOnOpen(true);
            htmlReporter.config().setDocumentTitle("ART WebApp Report ");
            htmlReporter.config().setReportName("ART Web Automation Test Report");
            htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
            htmlReporter.config().setTheme(Theme.STANDARD);
            htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        } catch (Exception e) {
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


    public static void getTestResult(WebDriver driver, ITestResult result) throws IOException {
        try {
            if (result.getStatus() == ITestResult.FAILURE) {

                test.fail(MarkupHelper.createLabel(result.getName() + " Test Case is FAILED", ExtentColor.RED));
                test.fail(result.getThrowable());
                try {
                    String screenshotPath = getScreenshot(driver, result.getName());
                    test.log(Status.FAIL, "Failed" + test.addScreenCaptureFromPath(screenshotPath));
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
     * Function to enter the text into a textfeld
     *
     * @param, driverType, element and string that's need to be entered
     */

    public static void enterText(WebDriver webDriver, WebElement element, String textkey) {
        try {
            element.sendKeys(textkey);
        } catch (Exception e) {
        }
    }

    /**
     * @param element
     * @return element title
     */

    public static String getText(WebElement element) {
        try {
            return element.getText();
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * Function to wait until the screen is fully loaded
     *
     * @param, drivertype , element and seconds to wait for page to load
     */

    public static void waitForScreenToLoad(WebDriver driver, WebElement element, int seconds) {

        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    /**
     * Function to click on link/button on web pages
     *
     * @param webDriver
     * @param element
     */
    public static void clickButton(WebDriver webDriver, WebElement element) {
        try {
            //waitForScreenToLoad(webDriver, element, 10);
            element.click();
            Thread.sleep(2000);
        } catch (ElementNotVisibleException e) {
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @throws InterruptedException
     * @throws AWTException
     */

    public void zoomWindow() throws InterruptedException, AWTException {
//         WebElement html = driver.findElement(By.cssSelector("body"));
//         for(int i=0; i<3; i++)
//         {
//             html.sendKeys(Keys.chord(Keys.CONTROL,Keys.SUBTRACT));
//         }

        Robot robot = new Robot();
        System.out.println("About to zoom in");
        for (int i = 0; i < 3; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }
        Thread.sleep(4000);
    }

    /**
     * @param, drivertype, screenshot path, screenshot name
     * attaches the screenshot to the test report
     */
    private static String getScreenshot(WebDriver webdriver, String screenshotName) throws IOException {

        String SubDirectory = "Screenshots";
        String ScreenshotPaths;

        try {
            String dateName = new SimpleDateFormat("dd-M-yyyy hh:mm").format(new Date());
            TakesScreenshot ts = (TakesScreenshot) webdriver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            ScreenshotPaths = createFolder(SubDirectory);
            File file = new File(ScreenshotPaths);
            System.out.println("the ScreenShot  Folder is :- " + file.getAbsolutePath());

            String dest = file.getAbsolutePath() + File.separator + screenshotName + ".png";
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

    public static void comparevalues(LinkedList<String> databasevalues,List excelvalues)
    {
        for(int i=0,j=1;i<databasevalues.size() && j<excelvalues.size();i++,j++)
        {
            if (databasevalues.get(i).equals(excelvalues.get(j)))
            {
                test.log(Status.FAIL,"Values didn't matched with Database");

            } else {
                test.log(Status.PASS, " Vakues matched with database");

            }
        }
    }


    /**
     * Function to create a folder with the project path
     *
     * @param, Directory path
     */
    public static String createFolder(String path) {
        String strManyDirectories = null;
        try {
            //  String strDirectoy = path;
            strManyDirectories = path;

            // Create one directory
            boolean
                    // Create multiple directories
                    success = (new File(strManyDirectories)).mkdirs();
            if (success) {
                System.out.println("Directories: "
                        + strManyDirectories + " created");
            }

        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
        return strManyDirectories;
    }

    /**
     * Function to check whether an element is displayed , return true if present else fail
     * If true, then the element text will be attached the report name. If element text not present, it uses the
     * element attribute
     *
     * @param, drivertype, element name
     */

    public static void elementDisplayed(WebDriver webDriver, WebElement element) throws Exception {

        try {
            waitForScreenToLoad(webDriver, element, 6);
            Assert.assertTrue(element.isDisplayed());
            if (element.isDisplayed()) {
                // if (element.getText().length() <= 0)
                if (element.getText() == null) {
                    // test.log(Status.PASS, element.getAttribute("contentDescription") + "  Displayed");
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


    public void scrollpage(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }


    /**
     * Function to get current system date
     */
    public static String getDate()
    {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        return date;
    }

    /**
     * function to scroll to a particular element on the page
     * @param driver
     * @param element
     */
    public void scrolltoElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    /**
     * Function to get the options from a drop down
     *
     * @param driver
     * @param element
     */

    public void getValues(WebDriver driver, WebElement element) {
        Select selectoptions = new Select(element);
        List<WebElement> optionvalues = selectoptions.getOptions();
        for (WebElement values : optionvalues) {
            System.out.println("the values are :" + values.getText());
        }

    }

    public List<WebElement> getOptions(WebElement element)
    {
        Select options = new Select(element);
        List<WebElement> flightoptions = options.getOptions();
        return flightoptions;
    }

    public void assertOptions(WebElement elements, String expected[])
    {
        Select options = new Select(elements);
        List <WebElement> elementcount = options.getOptions();
        System.out.println(elementcount.size());
        for(int i=0 ;i<elementcount.size();i++)
        {
            String value = elementcount.get(i).getText();
            System.out.println("the options are :- "+ value);
            Assert.assertEquals(value,expected[i],"text Matched");

        }

    }



    public void selectBytext(WebElement webElement, String text)
    {
        Select selectitem = new Select(webElement);
        selectitem.selectByVisibleText(text);
    }

    public void selectByid(WebElement element, int itemindex)
    {
        Select selectid = new Select(element);
        selectid.selectByIndex(itemindex);
    }


    /**
     * Function to mouse over a menu
     *
     * @param driver
     * @param menuselement
     * @param tosubmenuelement
     * @throws InterruptedException
     */

    public void mouseHover(WebDriver driver, WebElement menuselement, WebElement tosubmenuelement) throws InterruptedException {
//        Actions actions = new Actions(driver);
//        actions.moveToElement(fromelement).moveToElement(toelement).click().build().perform();
//        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.moveToElement(menuselement).perform();
        Thread.sleep(3000);
        actions.moveToElement(tosubmenuelement);
        actions.click().build().perform();
        Thread.sleep(3000);
    }

    /**
     * Function to resize the browser window
     *
     * @param driver
     */
    public void resizebrowsrWindow(WebDriver driver) {
        Dimension d = new Dimension(900, 900);
        driver.manage().window().setSize(d);
    }

    /**
     * Function to empty the  folder
     */
    public static void emptyFolder(String filepath) {

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

    public List<String> arrayProperties(String propertyfilepath) {
        List<String> propertiesvalues = new ArrayList<String>();
        try {
            File file = new File(propertyfilepath);
            FileInputStream fileInput = null;
            fileInput = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fileInput);
            fileInput.close();

            Enumeration enuKeys = properties.keys();
            while (enuKeys.hasMoreElements())
            {
                String key = (String) enuKeys.nextElement();
                String value = properties.getProperty(key);
                propertiesvalues.add(value);
                //String value = properties.getProperty(key);
                //System.out.println(key);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propertiesvalues;
    }


    public static List<String> getExcelValues(String filepath, String filenmae,String Sheetname) throws IOException {
        File file = new File(filepath+"//"+filenmae);
        List<String> propertiesvalues = new ArrayList<String>();
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook excelworkbook = new XSSFWorkbook(inputStream);
        String fileExtensionName = filenmae.substring(filenmae.indexOf("."));
//        if (fileExtensionName.equals("xlsx"))
//        {
//            excelworkbook = new XSSFWorkbook(inputStream);
//        } else if (fileExtensionName.equals("xls")) {
//            excelworkbook = new HSSFWorkbook(inputStream);
//        }
        System.out.println(Sheetname);
        XSSFSheet excelsheetname = excelworkbook.getSheet(Sheetname);
        int rowcount = excelsheetname.getLastRowNum() - excelsheetname.getFirstRowNum();
        for (int i = 0; i < rowcount; i++) {
            Row row = excelsheetname.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                System.out.print(row.getCell(j).getStringCellValue()+"|| ");
                propertiesvalues.add(row.getCell(j).getStringCellValue());
            }
        }
        return propertiesvalues;
    }


    /**
     * function to wait, till page is completely loaded
     * @param driver
     */
    public void waitForPageLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }

    /**
     *function to click on URL's with href
     * @param driver
     * @param href
     */
    public void clickLinkByHref(WebDriver driver,String href) {
        List<WebElement> anchors = driver.findElements(By.tagName("a"));
        Iterator<WebElement> i = anchors.iterator();

        while(i.hasNext()) {
            WebElement anchor = i.next();
            if(anchor.getAttribute("href").contains(href)) {
                anchor.click();
                break;
            }
        }
    }
}