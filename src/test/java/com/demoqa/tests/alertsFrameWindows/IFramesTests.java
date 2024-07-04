package com.demoqa.tests.alertsFrameWindows;

import com.demoqa.pages.AlertFrameWindowsPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IFramesTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getAlertsframeWindows();
        new SidePanel(driver).selectFrames();
    }

    @Test
    public void framesTest() {
        new AlertFrameWindowsPage(driver).getListOfIFrames();
    }

    @Test
    public void switchToIFrameByIndexTest() {
        new AlertFrameWindowsPage(driver).switchToIFrameByIndex(1)
                .verifyIFrameText("This is a sample page");
    }

    @Test
    public void switchToIFrameByIdTest() {
        new AlertFrameWindowsPage(driver).switchToIFrameByID().returnToMainContent()
                .verifyMainContentText("There are 2 Iframes in this page.");
    }
}
