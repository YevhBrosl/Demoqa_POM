package com.demoqa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AlertFrameWindowsPage extends BasePage{
    public AlertFrameWindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;
    public AlertFrameWindowsPage waitAlert() {
        click(timerAlertButton);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent()).accept();
        return this;
    }

    @FindBy(id = "confirmButton")
    WebElement confirmButton;
    public AlertFrameWindowsPage selectResult(String text) {
        click(confirmButton);

        if (text != null && text.equals("Ok")) {
            driver.switchTo().alert().accept();
        } else if (text != null && text.equals("Cancel")) {
            driver.switchTo().alert().dismiss();
        }
        return this;
    }

    @FindBy(id = "confirmResult")
    WebElement confirmResult;
    public AlertFrameWindowsPage verifyResult(String result) {
        Assert.assertTrue(shouldHaveText(confirmResult, result, 5));
        return this;
    }

    @FindBy(id = "promtButton")
    WebElement promtButton;

    public AlertFrameWindowsPage sendMessageToAlert(String message) {
        click(promtButton);

        if (message != null) {
            driver.switchTo().alert().sendKeys(message);
            driver.switchTo().alert().accept();
        }
        return this;
    }

    @FindBy(id = "promptResult")
    WebElement promptResult;
    public AlertFrameWindowsPage verifyMessage(String message) {
        Assert.assertTrue(shouldHaveText(promptResult, message,5));
        return this;
    }

    @FindBy(tagName = "iframe")
    List<WebElement> iframes;
    public AlertFrameWindowsPage getListOfIFrames() {
        // finding all web elements on the page using iframe tag
        //System.out.println("Number of iframes on the page: " + iframes.size());

        //using js
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Integer numberOfIFrames = Integer.parseInt(js.executeScript("return window.length").toString());
        System.out.println("Number of iframes on the page: " + numberOfIFrames);
        return this;
    }

    public AlertFrameWindowsPage switchToIFrameByIndex(int index) {
        driver.switchTo().frame(index);
        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;
    public AlertFrameWindowsPage verifyIFrameText(String text) {
        Assert.assertTrue(shouldHaveText(sampleHeading, text,5));
        return this;
    }

    @FindBy(id = "frame1")
    WebElement frame1;
    public AlertFrameWindowsPage switchToIFrameByID() {
        driver.switchTo().frame(frame1);
        return this;
    }

    public AlertFrameWindowsPage returnToMainContent() {
        driver.switchTo().defaultContent();
        return this;
    }

    @FindBy(css = "#framesWrapper>div")
    WebElement mainContentText;
    public AlertFrameWindowsPage verifyMainContentText(String text) {
        Assert.assertTrue(mainContentText.getText().contains(text));
        return this;
    }

    @FindBy(css = "body")
    WebElement body;
    public AlertFrameWindowsPage handleNestedIFrames() {
        System.out.println("Number of iframes on the page: " + iframes.size());

        //switch to parent iframe
        driver.switchTo().frame(frame1);

        //get text from parent iframe
        System.out.println("iframe1 is " + body.getText());
        System.out.println("Number of iframes on the parent iframe: " + iframes.size());

        //switch to child iframe
        driver.switchTo().frame(0);

        //get text from child iframe
        System.out.println("iframe1 is " + body.getText());

        //switch to parent iframe
        //driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();

        //get text from parent iframe
        System.out.println("iframe1 is " + body.getText());
        return this;
    }

    @FindBy(id = "tabButton")
    WebElement tabButton;
    public AlertFrameWindowsPage switchToNewTab(int index) {
        click(tabButton);

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }

    public AlertFrameWindowsPage verifyNewTabTitle(String title) {
        Assert.assertTrue(shouldHaveText(sampleHeading, title,5));
        return this;
    }
}
