package com.demoqa.tests.alertsFrameWindows;

import com.demoqa.pages.AlertFrameWindowsPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserWindowsTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getAlertsframeWindows();
        new SidePanel(driver).selectBrowserWindows().hideIFrames();
    }

    @Test
    public void handleNewTabTest() {
        new AlertFrameWindowsPage(driver).switchToNewTab(1)
                .verifyNewTabTitle("sample");
    }

}
