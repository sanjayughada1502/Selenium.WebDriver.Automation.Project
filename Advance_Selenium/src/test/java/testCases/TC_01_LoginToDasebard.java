package testCases;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import General_Library.Listerners_Implimentations;
import testBase.BaseClass;

@Listeners(Listerners_Implimentations.class)
public class TC_01_LoginToDasebard extends BaseClass {

	@Test
	public void dashboadPage() {
		System.out.println("Login Sucessfully..Now you are on Dashboard");
	}

}
