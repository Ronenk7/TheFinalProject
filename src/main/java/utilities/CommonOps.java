package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
//import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base {
    /*
    ###################################################################################
    Method name: getData
    Method description: This method get the data from xml configuration file
    Method parameters : String
    Method Return: String
    ###################################################################################
     */
    public static String getData(String nodeName)
    {
        File fxmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;
        try
        {
            fxmlFile = new File("./Configuration/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fxmlFile);
            doc.getDocumentElement().normalize();
        }
        catch (Exception e)
        {
            System.out.println("Error Reading XML file: " + e);
        }
        finally {
           return doc.getElementsByTagName(nodeName).item(0).getTextContent();
        }
    }
    /*
    ###################################################################################
    Method name: initBrowser
    Method description: This method initialize the chosen browser type
    Method parameters : String
    ###################################################################################
    */
    public static void initBrowser(String browserType) {
        if(browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else if (browserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else
            throw new RuntimeException("Invalid browser type");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("TimeOut")));
        driver.get(getData("url"));
        MangePages.initMortgage();
        listOfLists = new ArrayList<>();
        action = new Actions(driver);

    }
    /*
    ###################################################################################
    Method name: initChromeDriver
    Method description: This method initialize the chrome driver
    Method Return: String
    ###################################################################################
    */
    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }
    /*
    ###################################################################################
    Method name: initFirefoxDriver
    Method description: This method initialize the chrome driver
    Method Return: String
    ###################################################################################
    */
    public static WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }
    /*
    ###################################################################################
    Method name: initIEDriver
    Method description: This method initialize the internetExplorer driver
    Method Return: String
    ###################################################################################
    */
    public static WebDriver initIEDriver() {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }
    /*
    ###################################################################################
    Method name: initMobile
    Method description: This method initialize the mobile driver
    ###################################################################################
    */
    public static void initMobile() {
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("AppActivity"));
        try {
            mobileDriver = new AndroidDriver(new URL(getData("AppiumServer")), dc);
        } catch (Exception e) {
            System.out.println("Can not connect to appium server, see details: " +e);;
        }
        MangePages.initMobileMortgage();
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver, Long.parseLong(getData("TimeOut")));
    }
    /*
    ###################################################################################
    Method name: initApi
    Method description: This method initialize the api request
    ###################################################################################
    */
    public static void initApi(){
        RestAssured.baseURI = getData("urlAPI");
        httpRequest = RestAssured.given().auth().preemptive().basic(getData("UserName"), getData("Password"));
    }
    /*
    ###################################################################################
    Method name: initElectron
    Method description: This method initialize the electron driver
    ###################################################################################
    */
    public static void initElectron(){
        System.setProperty("webdriver.chrome.driver", getData("ElectronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("ElectronAppPath"));
        dc.setCapability("chromeOptions", opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        MangePages.initTodo();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("TimeOut")));
        action = new Actions(driver);
    }
    /*
    ###################################################################################
    Method name: initDesktop
    Method description: This method initialize the desktop driver
    ###################################################################################
    */
    public static void initDesktop() {
        dc.setCapability("app", getData("CalculatorApp"));
        try {
           // driver = new WindowsDriver(new URL(getData("AppiumServerDesktop")), dc);
        } catch (Exception e) {
            System.out.println("Can not connect to appium server, see details: " + e);
        }
        MangePages.initCalculator();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("TimeOut")));
    }
    /*
    ###################################################################################
    Method name: startSession
    Method description: This method starts the session by selecting the chosen platform
    Method parameters : String
    ###################################################################################
    */
    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName)  {
        Platform = PlatformName;
        if(Platform.equalsIgnoreCase("web"))
            initBrowser(getData("BrowserName"));

        else if(Platform.equalsIgnoreCase("webDB"))
            initBrowser(getData("BrowserName"));

        else if(Platform.equalsIgnoreCase("mobile"))
            initMobile();

        else if(Platform.equalsIgnoreCase("api"))
            initApi();

        else if(Platform.equalsIgnoreCase("electron"))
            initElectron();

        else if(Platform.equalsIgnoreCase("desktop"))
            initDesktop();

        else
            throw new RuntimeException("Invalid Platform Name");

        softAssert = new SoftAssert();
        screen = new Screen();
        ManageDB.openConnection(getData("DBURL"),getData("DBUserName"),getData("DBPassword"));
    }
    /*
    ###################################################################################
    Method name: closeSession
    Method description: This method closes the session except api platform
    ###################################################################################
    */
    @AfterClass
    public void closeSession() {
        ManageDB.closeConnection();
        if (!Platform.equalsIgnoreCase("api")) {
            if (!Platform.equalsIgnoreCase("mobile"))
                driver.quit();
            else
                mobileDriver.quit();
        }
    }
    /*
    ###################################################################################
    Method name: beforeMethod
    Method description: This method start recording every test except api platform
    Method parameters : Method
    ###################################################################################
    */
    @BeforeMethod
    public void beforeMethod(Method method){
        if(!Platform.equalsIgnoreCase("api")){
            try {
                MonteScreenRecorder.startRecord(method.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
