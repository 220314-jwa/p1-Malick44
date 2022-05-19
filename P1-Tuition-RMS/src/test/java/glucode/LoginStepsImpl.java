package glucode;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import java.io.File;

public class LoginStepsImpl {

    static WebDriver driver;
    static HomePage trmspeAppHome;
    @BeforeAll
    public static void setUp() {
        File file = new File("src/test/resources/chromedrivers");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        driver = new ChromeDriver();
        trmspeAppHome = new HomePage(driver);
    }
    @AfterAll
    public static void closeDriver() {
        driver.quit();
    }



    @Given("the user is on the homepage")
    public void the_user_is_on_the_homepage() {
        trmspeAppHome.navigateTo();
    }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        trmspeAppHome.goToLoginPage();
    }
    @Given("the user enters the correct username")
    public void the_user_enters_the_correct_username() {
    trmspeAppHome.userName("Malick");
    }

    @When("the user clicks the SignOn button")
    public void the_user_clicks_the_sign_on_button() {
      trmspeAppHome.submitLogin();
    }

    @Then("the nav will show the user's first name")
    public void the_nav_will_show_the_user_s_first_name() {
        assertTrue(trmspeAppHome.getNavText().contains("Malick"));
        trmspeAppHome.logOut();

    }

    @When("the user enters the correct password")
    public void the_user_enters_the_correct_password() {
        trmspeAppHome.passWord("incorrect");
    }


    @When("the user enters an incorrect username")
    public void the_user_enters_an_incorrect_username() {
       trmspeAppHome.passWord("incorrectness");
    }

    @Given("the user is on the homepageWhen the user clicks the login button")
    public void the_user_is_on_the_homepage_when_the_user_clicks_the_login_button() {
       trmspeAppHome.submitLogin();
    }

    @Then("an incorrect credentials message will be displayed")
    public void an_incorrect_credentials_message_will_be_displayed() {
        String message = trmspeAppHome.getMessageBoxText().toLowerCase();
        assertTrue(message.contains("invalid input"));

    }





    @Given("the user enters the incorrect password")
    public void the_user_enters_the_incorrect_password() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }




}
