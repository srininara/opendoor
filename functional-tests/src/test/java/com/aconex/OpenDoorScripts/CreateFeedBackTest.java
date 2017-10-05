package com.aconex.OpenDoorScripts;

import com.aconex.OpenDoorLib.CreateFeedBackpg;
import com.aconex.OpenDoorLib.genericLib.ExcelLib;
import com.aconex.OpenDoorLib.genericLib.WebDriverCommonLib;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.aconex.OpenDoorLib.genericLib.Driver.DRIVER;

public class CreateFeedBackTest {
    ExcelLib excelLib;
    WebDriverCommonLib webDriverCommonLib;
    CreateFeedBackpg createFeedBack;

    //Data Setting
    String name = "OpenDoorLib"+ Math.random();
    String feedBack="Something"+Math.random();
    String location = "Mumbai";
    int rating = 5;
    String title="Ashoka Title"+Math.random();

    @BeforeClass
    public void createFeedBack() throws IOException, InvalidFormatException, InterruptedException {
        excelLib = new ExcelLib();
        String URL = excelLib.getExcelData("DATA", 1, 0);
        DRIVER.get(URL);
        createFeedBack = new CreateFeedBackpg();
    }

    //Create feed back
    @Test(priority = 1)
    public void userFeedBack() throws InterruptedException {
        Thread.sleep(2000);
        WebDriverCommonLib.waitForPageToLoad();
        createFeedBack.shareFeedBack();
        createFeedBack.idea();
        createFeedBack.enterName(name);
        createFeedBack.selectRating(rating);
        createFeedBack.enterFeedBack(feedBack);
        createFeedBack.selectLocation(location);
        createFeedBack.enterTitle(title);
        createFeedBack.verifySubmitButton();
        createFeedBack.submit();

    }

    @AfterClass
    public void after() {
        DRIVER.quit();
    }

}
