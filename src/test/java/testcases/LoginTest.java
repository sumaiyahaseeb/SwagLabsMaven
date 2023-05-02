package testcases;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import pages.LoginPage;

public class LoginTest extends BaseClass {

	@Test
	public void positive(Method method) throws FilloException {
		LoginPage login = new LoginPage(driver);
		Recordset recordset = connection.executeQuery("select * from data where Testcase= '" + method.getName() + "'");
		recordset.next();
		String username = recordset.getField("UserName");
		String password = recordset.getField("Password");

		login.Loginfunction(username, password);

		String actualurl = driver.getCurrentUrl();
		String expectedurl = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(actualurl, expectedurl);
	}

	@Test
	public void negative(Method method) throws FilloException {
		LoginPage login = new LoginPage(driver);
		Recordset recordset = connection.executeQuery("select * from data where Testcase= '" + method.getName() + "'");
		recordset.next();
		String username = recordset.getField("UserName");
		String password = recordset.getField("Password");

		login.Loginfunction(username, password);

		// validation
		WebElement error = driver.findElement(By.cssSelector("h3[data-test='error']"));

		String Actualerror = error.getText();
		String Expectederror = "Epic sadface: Username and password do not match any user in this service";

		Assert.assertEquals(Actualerror, Expectederror);

	}

}
