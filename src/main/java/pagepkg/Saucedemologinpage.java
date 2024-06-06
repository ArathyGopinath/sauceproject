package pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Saucedemologinpage {

WebDriver driver;
	
	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(name="login-button")
	WebElement login;
	

	public Saucedemologinpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setvalues(String Un,String pswd)
	 {
		username.clear();                     //if username is overlapping while running
		username.sendKeys(Un);
		password.clear();                     //if password is overlapping while running
		password.sendKeys(pswd);
     }

	 public void loginclick()
	 {
		login.click();
	 } 
}