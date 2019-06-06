import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class ParkingCalculatorPage {

    WebDriver driver;

    public ParkingCalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    By lotDropdown = By.id("Lot");
    By entryTimeTextField = By.id("EntryTime");
    By entryDateTextField = By.id("EntryDate");
    By entryDateAMRadioButton = By.xpath("//input[(@name='EntryTimeAMPM') and (@value = 'AM')]");
    By entryDatePMRadioButton = By.xpath("//input[(@name='EntryTimeAMPM') and (@value = 'PM')]");
    By exitTimeTextField = By.id("ExitTime");
    By exitDateTextField = By.id("ExitDate");
    By exitDateAMRadioButton = By.xpath("//input[(@name='ExitTimeAMPM') and (@value = 'AM')]");
    By exitDatePMRadioButton = By.xpath("//input[(@name='ExitTimeAMPM') and (@value = 'PM')]");
    By calculateButton = By.name("Submit");


    public void checkEntryAMRadioButton() {
        driver.findElement(entryDateAMRadioButton).click();
    }

    public void checkEntryPMRadioButton() {
        driver.findElement(entryDatePMRadioButton).click();
    }

    public void checkExitAMRadioButton() {
        driver.findElement(exitDateAMRadioButton).click();
    }

    public void checkExitPMRadioButton() {
        driver.findElement(exitDatePMRadioButton).click();
    }

    public void chooseParkingLot(String lot) {
        new Select(driver.findElement(lotDropdown)).selectByVisibleText(lot);
    }

    public void enterParkingData(TestCaseData data) {
        chooseEntryTime(data.getEntryTime());
        chooseEntryDate(data.getEntryDate());
        setEntryAMPM(data.isEntryTimeIsAM());
        chooseExitTime(data.getExitTime());
        chooseExitDate(data.getExitDate());
        setExitAMPM(data.isEntryTimeIsAM());
        checkEntryPMRadioButton();
        checkExitPMRadioButton();
        clickCalculateButton();
    }

    public void chooseEntryTime(String time) {
        driver.findElement(entryTimeTextField).clear();
        driver.findElement(entryTimeTextField).sendKeys(time);
    }

    public void chooseEntryDate(String date) {
        driver.findElement(entryDateTextField).clear();
        driver.findElement(entryDateTextField).sendKeys(date);
    }

    public void chooseExitTime(String time) {
        driver.findElement(exitTimeTextField).clear();
        driver.findElement(exitTimeTextField).sendKeys(time);
    }

    public void chooseExitDate(String date) {
        driver.findElement(exitDateTextField).clear();
        driver.findElement(exitDateTextField).sendKeys(date);
    }

    public void setEntryAMPM(boolean isAM) {
        if (isAM)
            checkEntryAMRadioButton();
        else
            checkEntryPMRadioButton();
    }

    public void setExitAMPM(boolean isAM) {
        if (isAM)
            checkExitAMRadioButton();
        else
            checkExitPMRadioButton();
    }

    public void clickCalculateButton() {
        driver.findElement(calculateButton).click();
    }

    public Boolean getCostResult(String cost) {
        return driver.getPageSource().contains(cost);
    }
}
