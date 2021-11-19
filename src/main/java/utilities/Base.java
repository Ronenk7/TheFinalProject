package utilities;

import io.appium.java_client.AppiumDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageObjects.mobileMortgage.AmortizationTables;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class Base {
   // General
   protected static WebDriverWait wait;
   protected static Actions action;
   protected static SoftAssert softAssert;
   protected static List<List<Double>> listOfLists;
   public static String rate;
   protected static Screen screen;
   protected static String Platform;

   // Web
   protected static WebDriver driver;

   // Mobile
   protected static AppiumDriver mobileDriver;
   protected static DesiredCapabilities dc = new DesiredCapabilities();

   // Rest Api
   protected static RequestSpecification httpRequest;
   protected static Response response;
   protected static JSONObject params = new JSONObject();
   protected static JsonPath jp;

   // Database
   protected static Connection con;
   protected static Statement stmt;
   protected static ResultSet rs;

   // Page Objects - Web
   protected static pageObjects.mortgageORG.MainPage mortgageMain;
   protected static pageObjects.mortgageORG.GraphPage mortgageGraph;
   protected static pageObjects.mortgageORG.MenuPage mortgageMenu;
   protected static pageObjects.mortgageORG.RatesLinksPage mortgageRatesLinks;
   protected static pageObjects.mortgageORG.MortgageRepaymentSummary mortgageSummary;
   protected static pageObjects.mortgageORG.CurrentMortgageRates mortgageCurrentRates;

   // Page Objects - Mobile
   protected static pageObjects.mobileMortgage.MainPage mobileMortgageMain;
   protected static AmortizationTables mobileAmortization;

   // pages Objects - Electron
   protected static pageObjects.todo.MainPage todoMain;

   // pages Objects - Desktop
   protected static pageObjects.calculator.MainPage calcMain;
}
