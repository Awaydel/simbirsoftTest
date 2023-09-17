import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterFirstName(String firstName) {
        //Имя
        driver.findElement(By.id("firstName")).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        //Фамилия
        driver.findElement(By.id("lastName")).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        //Емайл
        driver.findElement(By.id("userEmail")).sendKeys(email);
    }

    public void selectGender() {
        //Пол
        driver.findElement(By.cssSelector("label[for='gender-radio-3']")).click();
    }

    public void enterMobileNumber(String number) {
        //Nomer
        driver.findElement(By.id("userNumber")).sendKeys(number);
    }

    public void selectDateOfBirth(String month, String year, String day) {
        //Data
        driver.findElement(By.id("dateOfBirthInput")).click();
        driver.findElement(By.cssSelector(".react-datepicker__month-select")).sendKeys(month);
        driver.findElement(By.cssSelector(".react-datepicker__year-select")).sendKeys(year);
        driver.findElement(By.cssSelector(".react-datepicker__day--" + day)).click();
    }

    public void selectSubject(String subject) {
        //Subject
        WebElement subjectsInputContainer = driver.findElement(By.className("subjects-auto-complete__value-container"));
        subjectsInputContainer.click();
        WebElement subjectsInput = driver.findElement(By.id("subjectsInput"));
        subjectsInput.sendKeys(subject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'subjects-auto-complete__option') and text()='" + subject + "']"))).click();
    }

    public void selectHobby(String hobby) {
        //Hobby
        driver.findElement(By.xpath("//label[text()='" + hobby + "']")).click();
    }

    public void uploadPicture(String filePath) {
        //Png
        driver.findElement(By.id("uploadPicture")).sendKeys(filePath);
    }

    public void enterCurrentAddress(String address) {
        //address
        driver.findElement(By.id("currentAddress")).sendKeys(address);
    }

    public void selectState(String state) {
        //state
        driver.findElement(By.id("state")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='" + state + "']"))).click();
    }

    public void selectCity(String city) {
        //city
        driver.findElement(By.id("city")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='" + city + "']"))).click();
    }

    public void clickSubmitButton() {
        //button
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
        submitButton.click();
    }

    public String getSuccessMessage() {
        //ending
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("example-modal-sizes-title-lg")));
        return successMessage.getText();
    }
}
