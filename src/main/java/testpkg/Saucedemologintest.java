package testpkg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import basepkg.Baseclass;

import pagepkg.Saucedemologinpage;
import utilities.Excelutils;

public class Saucedemologintest extends Baseclass
{
	
    @Test(priority=1)
    
    public void logintest()
    {
	    Saucedemologinpage ob=new Saucedemologinpage(driver);

       String xl="C:\\Users\\Acer\\Desktop\\ARATHY\\LUMINAR\\excel work\\saucedemo.xlsx";
       String Sheet="Sheet1";
       int rowCount=Excelutils.getRowCount(xl,Sheet);
    
       for(int i=1;i<=rowCount;i++)
       {
    	   String Un=Excelutils.getCellValue(xl,Sheet,i,0);
    	   System.out.println("username...." +Un);
    	 
    	   String Pwd=Excelutils.getCellValue(xl,Sheet,i,1);
    	   System.out.println("password...." +Pwd);
    	 
    	   ob.setvalues(Un, Pwd);                                    //passing un and pwd as parameters
    	   ob.loginclick();                                          //clicking login button
       }	
    }
    
    @Test(priority=2)
    public void addtocart() 
    {
    	List<WebElement> li=driver.findElements(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div/div[2]/div[2]/button"));           //driver.findElement(by.xpath("//*[@id="add-to-cart-sauce-labs-backpack"]")).click();
    	for (WebElement ele:li)                                                                                                             //driver.findElement(by.xpath("//*[@id="add-to-cart-sauce-labs-bike-light"]")).click();;
    	{                                                                                                                                   //driver.findElement(by.xpath
    		String text=ele.getText();                                                                                                       //driver.findElement(by.xpath
    		if(text.equals("Add to cart"))                                                                                                   //driver.findElement(by.xpath
    		{                                                                                                                                 //driver.findElement(by.xpath     (another method ,all seperatly)
		      ele.click();
    		}
    	}
    }
    
    @Test(priority=3)
    
    public void othermethods() throws Exception
    {
    	
    	driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();              //cart icon
    	driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();                               //checkout button

    	driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("Arathy");                  //firstname,lastname,pin
    	driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("Gopinath");
    	driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("671316");
    	
    	Thread.sleep(5000);                                                                          //if continue button is not clicking after entering fn etc, give thread.sleep
    					
    	driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();                              //continue button
    	
    	driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();                                //finish button
        driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();                      //back to home button
    	
        driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();                 //hamburger menu click
        
        Thread.sleep(5000);
     	driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();                   //logout
    }

}


