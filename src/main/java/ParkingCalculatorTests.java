import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


public class ParkingCalculatorTests {

    private WebDriver driver = new FirefoxDriver();
    private ParkingCalculatorPage page = new ParkingCalculatorPage(driver);

    public Iterator<Object> getData(String filePath) {
        ArrayList<Object> testCases = new ArrayList<Object>();
        String temp = "";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((temp = br.readLine()) != null) {
                String[] parkingData = temp.split(",");
                testCases.add(new TestCaseData(parkingData));
            }
        } catch (IOException e) {  e.printStackTrace(); }

        return testCases.iterator();
    }

    @DataProvider
    public Iterator<Object> getShortTermParkingData() {
        return getData("src/main/shortTermParkingData.csv");
    }

    @DataProvider
    public Iterator<Object> getLongTermParkingData() {
        return getData("src/main/longTermParkingData.csv");
    }

    @BeforeTest
    void setup() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        driver.get("http://adam.goucher.ca/parkcalc/");
    }

    @Test(dataProvider = "getShortTermParkingData")
    void shortTermParkingTest(TestCaseData testData) {
        page.chooseParkingLot("Short-Term Parking");
        page.enterParkingData(testData);
        Assert.assertTrue(page.getCostResult(testData.getCost()));
    }

    @Test(dataProvider = "getLongTermParkingData")
    void test2(TestCaseData testData) {
        page.chooseParkingLot("Long-Term Surface Parking");
        page.enterParkingData(testData);
        Assert.assertTrue(page.getCostResult(testData.getCost()));
    }

    @AfterTest
    void tearDown() {
        System.out.println("Teardown");
        driver.close();
    }
}
