package fr.selenium.MichaelAllogo;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	private static final String URL = "https://www.fr.jal.co.jp/frl/en/";
	private static final String PATH_CHROME_DRIVER = "C:\\chromedriver.exe";
	public static WebDriver driver;

	public static void firstTest() {
		System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER);// System.setProprety(key,value)
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String VilleDepart = "VilleDepart";
		String VillArrivee = "VilleArrivee";
		String FlightNb = " ", horaire, prix;

		driver.get(URL);

		pausa(3);
		// driver.findElement(By.className("JS_ciBox_submit")).click();
		driver.findElements(By.cssSelector("#JS_ciBox_contents img")).get(1).click();
		Select s = new Select(driver.findElement(By.id("mdlDepLocation1")));
		s.selectByValue("NCE");
		Select s1 = new Select(driver.findElement(By.id("mdlArrLocation1")));
		s1.selectByValue("TYO");
		// DEPART
		Select s2 = new Select(driver.findElement(By.id("DEPARTURE_DATE_1_MONTH")));
		s2.selectByValue("10");
		Select s3 = new Select(driver.findElement(By.id("DEPARTURE_DATE_1_DAY")));
		s3.selectByValue("14");
		// RETURN
		Select s4 = new Select(driver.findElement(By.id("DEPARTURE_DATE_2_MONTH")));
		s4.selectByValue("11");
		Select s5 = new Select(driver.findElement(By.id("DEPARTURE_DATE_2_DAY")));
		s5.selectByValue("18");
		// CLASSE
		Select s6 = new Select(driver.findElement(By.id("CFF_1")));
		s6.selectByValue("1YE");
		// NB PASSAGERS
		Select s7 = new Select(driver.findElement(By.id("mdlNbAdt")));
		s7.selectByValue("1");
		Select s8 = new Select(driver.findElement(By.id("mdlNbChd")));
		s8.selectByValue("0");
		Select s9 = new Select(driver.findElement(By.id("mdlNbInf")));
		s9.selectByValue("0");

		pausa(3);
		// Rechercher
		driver.findElement(By.id("mdlFormSubmit")).click();
		pausa(2);

		// Rechercher ville depart
		String VilleDepart1 = "VilleDepart";
		VilleDepart1 = driver.findElement(By.id("bound-departure-0")).getText();
		System.out.println("La ville de depart1 est :" + VilleDepart1);

		// Rechercher ville arrivee
		String VilleArrivee1 = "VilleDepart";
		VilleArrivee1 = driver.findElement(By.id("bound-arrival-0")).getText();
		System.out.println("La ville de d'arrivee1 est :" + VilleArrivee1);

		// Rechercher Flight Number en mettant une fonction wait avant(attendre 15s si l'elemt est visible)
		    try {
				System.out.println(LocalDateTime.now());
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#flightNumber-0-0 .flight-identifier"))));
		    }catch (TimeoutException e) {
		    	System.out.println("j'ai pas trouvé l'element est :"+LocalDateTime.now());
		    }
		    
		
		if (driver.findElement(By.cssSelector("#flightNumber-0-0 .flight-identifier")).isDisplayed()) {
			System.out.println("Le flight number s'affiche");
		} else {
			System.out.println("Le flight number ne s'affiche pas, on click pour l'afficher");
			driver.findElement(By.cssSelector(".medium-pattern.mb1.p5")).click();
		}
		
		System.out.println("Le flight number est : " + driver.findElement(By.cssSelector("#flightNumber-0-0 .flight-identifier")).getText());
		
		
		try {
			System.out.println(LocalDateTime.now());
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#flightNumber-0-0 .flight-identifier"))));
		System.out.println("j'ai bien trouvé l'element est maintenant :"+LocalDateTime.now());
	    }catch (TimeoutException e) {
	    	System.out.println("j'ai bien trouvé l'element est maintenant :"+LocalDateTime.now());
	    }
		
		/*String horaire1 = "horaire";
		horaire1 = driver.findElement(By.className("worldClock hour")).getText();
		System.out.println("Le vol part à :" + horaire1);*/

		String prix1 = "prix";
		prix1 = driver.findElement(By.id("sidebarPriceSummaryTotalPrice")).getText();
		System.out.println("Le vol coute :" + prix1);
		
		
		

		/*
		 * WebElement element =
		 * driver.findElement(By.cssSelector("#flightNumber-0-0.flight-identifier"));
		 * String FlightNb1 = element.getText();
		 * System.out.println("Le flight number est :" +FlightNb1);
		 */

		// continuer
		pausa(5);
		driver.findElement(By.id("continueButton")).click();

		// Remplir les infos
		Select s10 = new Select(driver.findElement(By.id("0-title")));
		s10.selectByValue("MR");
		Select s11 = new Select(driver.findElement(By.id("0-gender")));
		s11.selectByValue("string:MALE");

		driver.findElement(By.id("0-last-name")).sendKeys("Michael");
		driver.findElement(By.id("0-first-name")).sendKeys("ALLOGO");
		driver.findElement(By.id("0-middle-name")).sendKeys("EKOGHA");
		driver.findElement(By.id("0-birth-date-day")).sendKeys("29");
		driver.findElement(By.id("0-birth-date-month")).sendKeys("03");
		driver.findElement(By.id("0-birth-date-year")).sendKeys("1987");
		driver.findElement(By.id("0-passport-number")).sendKeys("25GB87368");
		driver.findElement(By.id("0-nationality")).sendKeys("French");
		driver.findElement(By.id("0-issuing-country")).sendKeys("France");
		driver.findElement(By.id("0-validity-day")).sendKeys("10");
		driver.findElement(By.id("0-validity-month")).sendKeys("05");
		driver.findElement(By.id("0-validity-year")).sendKeys("2022");

		pausa(3);
		Select s12 = new Select(driver.findElement(By.id("phone1-phone-country-0")));
		s12.selectByValue("FRA");

		driver.findElement(By.id("phone1-phone-number-0")).sendKeys("0609793771");

		driver.findElement(By.id("email-guest-address")).sendKeys("allogo9@yahoo.fr");
		driver.findElement(By.id("email-confirm-new")).sendKeys("allogo9@yahoo.fr");

		pausa(3);

		driver.findElement(By.id("continueButton")).click();
		pausa(2);
		driver.findElement(By.id("continueButton-PCOF")).click();
		pausa(2);
		driver.findElement(By.id("seatContinue")).click();

		// Rechercher ville depart
		String VilleDepart2 = "VilleDepart";
		VilleDepart2 = driver.findElement(By.id("originLocation-0")).getText();
		System.out.println("La ville de depart est :" + VilleDepart2);

		// Rechercher ville arrivee
		String VilleArrivee2 = "VilleDepart";
		VilleArrivee2 = driver.findElement(By.id("destinationLocation-0")).getText();
		System.out.println("La ville de d'arrivee est :" + VilleArrivee2);
		//Rechercher le numéro de vol

	    String FlightNb2 = "FlightNb";
		FlightNb2 = driver.findElement(By.id("flightNumber-0-0")).getText();
		System.out.println("Le numéro du vol est :" + FlightNb2);

		String horaire2 = "horaire";
		horaire2 = driver.findElement(By.id("segmentOriginDate-0-0")).getText();
		System.out.println("Le vol part à :" + horaire2);

		String prix2 = "prix";
		prix2 = driver.findElement(By.id("sidebarPriceSummaryTotalPrice")).getText();
		System.out.println("Le vol coute :" + prix2);

		pausa(5);
		driver.findElement(By.id("purchaseButton")).click();

		driver.findElement(By.id("CCnb")).sendKeys("4012888888881881");
		Select s13 = new Select(driver.findElement(By.id("expiration-month-id")));
		s13.selectByValue("number:3");
		Select s14 = new Select(driver.findElement(By.id("expiration-year-id")));
		s14.selectByValue("number:2021");
		driver.findElement(By.id("sec-code")).sendKeys("123");

		{
			//Faire les comparaisons avec les asserts
			
			assertEquals("Les villes de departs sont elles les memes? ", VilleDepart1, VilleDepart2);
			assertEquals("Les villes d'arrivees sont elles les memes? ", VilleArrivee1,VilleArrivee2);
			assertEquals("Les deux prix sont ils les memes?" , prix1, prix2 );
			assertTrue("Le numero de vol", FlightNb2.contains( driver.findElement(By.cssSelector("#flightNumber-0-0 .flight-identifier")).getText()));
		}
		
		
				

	}

	private static void pausa(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}

	}

}
