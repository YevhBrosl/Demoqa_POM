package com.demoqa.tests.alertsFrameWindows;

import com.demoqa.pages.AlertFrameWindowsPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getAlertsframeWindows();
        new SidePanel(driver).selectAlerts();
    }

    @Test
    public void waitAlertTest() {
        new AlertFrameWindowsPage(driver).waitAlert();
    }

    @Test
    public void selectConfirmTest() {
        new AlertFrameWindowsPage(driver).selectResult("Cancel")
                .verifyResult("Cancel");

    }

    @Test
    public void sendMessageToAlertTest() {
        new AlertFrameWindowsPage(driver).sendMessageToAlert("Hello, Alert!")
                .verifyMessage("Hello, Alert!");
    }
}
