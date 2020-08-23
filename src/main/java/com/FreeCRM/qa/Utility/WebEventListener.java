package com.FreeCRM.qa.Utility;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.FreeCRM.qa.Baseclass.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener{ 



public void beforeAlertAccept(WebDriver driver) {
	
	
}

public void afterAlertAccept(WebDriver driver) {
	// TODO Auto-generated method stub
	
}

public void afterAlertDismiss(WebDriver driver) {
	// TODO Auto-generated method stub
	
}

public void beforeAlertDismiss(WebDriver driver) {
	// TODO Auto-generated method stub
	
}

public void beforeNavigateTo(String url, WebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println("BeforeNavigateTo: "+url+"'");
	
}

public void afterNavigateTo(String url, WebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println("AftrNavigateTo: "+url+"'");
}

public void beforeNavigateBack(WebDriver driver) {
	// TODO Auto-generated method stub
	
}

public void afterNavigateBack(WebDriver driver) {
	// TODO Auto-generated method stub
	
}

public void beforeNavigateForward(WebDriver driver) {
	// TODO Auto-generated method stub
	
}

public void afterNavigateForward(WebDriver driver) {
	// TODO Auto-generated method stub
	
}

public void beforeNavigateRefresh(WebDriver driver) {
	// TODO Auto-generated method stub
	
}

public void afterNavigateRefresh(WebDriver driver) {
	// TODO Auto-generated method stub
	
}

public void beforeFindBy(By by, WebElement element, WebDriver driver) {
	// TODO Auto-generated method stub
	
}

public void afterFindBy(By by, WebElement element, WebDriver driver) {
	// TODO Auto-generated method stub
	
}

public void beforeClickOn(WebElement element, WebDriver driver) {
	// TODO Auto-generated method stub
	
}

public void afterClickOn(WebElement element, WebDriver driver) {
	// TODO Auto-generated method stub
	
}

public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
	// TODO Auto-generated method stub
	System.out.println("Value of the: "+element.toString()+"before any changes mode");
}

public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
	// TODO Auto-generated method stub
	System.out.println("Element value changed to :"+element.toString());
}

public void beforeScript(String script, WebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println("beforeScript :"+script.toString());
	
}

public void afterScript(String script, WebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println("afterScript :"+script.toString());
	
}

public void beforeSwitchToWindow(String windowName, WebDriver driver) {
	// TODO Auto-generated method stub
	
}

public void afterSwitchToWindow(String windowName, WebDriver driver) {
	// TODO Auto-generated method stub
	
}

public void onException(Throwable throwable, WebDriver driver) {
	// TODO Auto-generated method stub
	try {
		TestUtil.takeScreenShotAtEndOfTest();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public <X> void beforeGetScreenshotAs(OutputType<X> target) {
	// TODO Auto-generated method stub
	
}

public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
	// TODO Auto-generated method stub
	
}

public void beforeGetText(WebElement element, WebDriver driver) {
	// TODO Auto-generated method stub
	
}

public void afterGetText(WebElement element, WebDriver driver, String text) {
	// TODO Auto-generated method stub
}	

}