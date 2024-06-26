package pageFactory;

import Variables.configReader;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Listeners;
import utils.TestListeners;
import Variables.configReader;
//@Listeners(utils.TestListeners.class)
public class LoginPage {

    protected String LoginUser;
    protected String LoginPass;
    final WebDriver driver;

    @FindBy(how = How.CSS, using = "input[placeholder='Username']")
    public WebElement Input_UserName;

    @FindBy(how = How.CSS, using = "input[placeholder='Password']")
    public WebElement Input_LoginPass;

    @FindBy(how = How.ID, using = "login-button")
    public WebElement Login_btn;
    @FindBy(how = How.CSS, using = "div[class='login_logo']")
    public WebElement Login_logo;



    public void LoginPage_isdisplayed()
    {
        if(Login_logo.isDisplayed()) {
            //System.out.println(TestListeners.extentTest.get());
        TestListeners.extentTest.get().log(Status.PASS, "Login Page is loaded successfully");
    }
    }

    public void LoginPage_inputUser()
    {
        if(Input_UserName.isDisplayed()) {
            Input_UserName.sendKeys(LoginUser);
            TestListeners.extentTest.get().log(Status.PASS, "Inserting username");
        }

    }

    public void LoginPage_inputPass()
    {
        if(Input_LoginPass.isDisplayed()) {
            Input_LoginPass.sendKeys(LoginPass);
            TestListeners.extentTest.get().log(Status.PASS, "Inserting UserPassword");
        }

    }

    public void LoginPage_LoginbuttonClick()
    {
        if(Login_btn.isDisplayed()) {
            Login_btn.click();
            TestListeners.extentTest.get().log(Status.PASS, "Clicking Login button");
        }

    }


    public LoginPage(WebDriver driver){
        LoginUser = configReader.property.getProperty("Login_User");
        LoginPass = configReader.property.getProperty("Login_Pass");
        this.driver = driver;

    }
}
