import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebTest {
    private WebDriver driver;
    private String baseUrl = "https://demoqa.com/automation-practice-form";
    private RegistrationPage registrationPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Андрей\\Documents\\Simbirsoft\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    public void testRegistrationForm() {
        // Вызываем методы  заполнения формы
        registrationPage.enterFirstName("R");
        registrationPage.enterLastName("Val");
        registrationPage.enterEmail("name@example.com");
        registrationPage.selectGender();
        registrationPage.enterMobileNumber("1234567890");
        registrationPage.selectDateOfBirth("September", "2023", "017");
        registrationPage.selectSubject("English");
        registrationPage.selectHobby("Reading");
        registrationPage.uploadPicture("C:\\Users\\Андрей\\Desktop\\photo_2023-08-06_16-15-19.jpg");
        registrationPage.enterCurrentAddress("Washington");
        registrationPage.selectState("Haryana");
        registrationPage.selectCity("Karnal");
        registrationPage.clickSubmitButton();

        // Проверка результата
        String successMessage = registrationPage.getSuccessMessage();
        Assert.assertEquals(successMessage, "Thanks for submitting the form");
    }

    @AfterClass
    public void tearDown() {
        // Пауза в 5 секунд перед закрытием
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
