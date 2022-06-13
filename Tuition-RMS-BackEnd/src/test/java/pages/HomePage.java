package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


// the following is implement the page object  model design patter
public class HomePage {
 WebDriver driver;
    @FindBy(id = "Loginlogout")
    WebElement Loginlogout;
    @FindBy(id="userName")
    WebElement userName;
    @FindBy(id="passWord")
    WebElement passWord;
    @FindBy(id="logInBtn")
    WebElement logInBtn;
    WebElement messageBox;

    public HomePage(WebDriver driver) {
        this.driver= driver;
        // tells Selenium to find the elements based on the annotations above
        PageFactory.initElements(driver, this);
    }

    public void navigateTo (){
        driver.get("");
    }

    public void goToLoginPage() {
        Loginlogout.click();
    }
    public void userName(String username) {
        userName.sendKeys(username);
    }

    public void passWord(String password) {
        passWord.sendKeys(password);
    }

    public void submitLogin() {
        logInBtn.click();
    }

    public void logOut() {
        if (logInBtn.getText().equals("Log Out")) {
            logInBtn.click();
        }
    }

        public String getMessageBoxText() {
            Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofMillis(500));
            fluentWait.until(ExpectedConditions
                    .textToBePresentInElement(messageBox, "i"));

            return messageBox.getText();
        }


        public String getNavText(){
            Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofMillis(500));
            fluentWait.until(ExpectedConditions
                    .numberOfElementsToBe(By.id("nameDisplay"), 1));

            return driver.findElement(By.id("nameDisplay")).getText();
        }













}
