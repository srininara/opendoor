package com.aconex.OpenDoorLib;

import com.aconex.OpenDoorLib.genericLib.Driver;
import com.aconex.OpenDoorLib.genericLib.WebDriverCommonLib;
import com.aconex.OpenDoorLib.pageObjRepo.OpenDoorPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.aconex.OpenDoorLib.genericLib.Driver.DRIVER;
import static com.aconex.OpenDoorLib.genericLib.Driver.systemPropeties;
import static com.aconex.OpenDoorLib.genericLib.WebDriverCommonLib.select;

public class CreateFeedBackpg {
    OpenDoorPage openDoorPage;

    //This method is for entering the name
    public void enterName(String name) throws InterruptedException {
        openDoorPage = PageFactory.initElements(DRIVER, OpenDoorPage.class);
        WebDriverCommonLib.waitForPageToLoad();
        openDoorPage.name().sendKeys(name);
    }

    //This method is for entering the message
    public void enterFeedBack(String feedBack) throws InterruptedException {
        openDoorPage = PageFactory.initElements(DRIVER, OpenDoorPage.class);
        WebDriverCommonLib.waitForPageToLoad();
        openDoorPage.feedBack().sendKeys(feedBack);
    }

    //This method is for selecting the location
    public void selectLocation(String location) throws InterruptedException{
        openDoorPage = PageFactory.initElements(DRIVER, OpenDoorPage.class);
        WebDriverCommonLib.waitForPageToLoad();
        select(OpenDoorPage.selectLocation(),location);
    }

    //This method is for selecting stars
    public void selectRating(int rating) throws InterruptedException{
        openDoorPage = PageFactory.initElements(DRIVER, OpenDoorPage.class);
        WebDriverCommonLib.waitForPageToLoad();
        openDoorPage.selectRating(rating).click();
    }

    //This method is for submitting the feed back
    public void submit() throws InterruptedException{
        openDoorPage = PageFactory.initElements(DRIVER, OpenDoorPage.class);
        WebDriverCommonLib.waitForPageToLoad();
        openDoorPage.submit().click();
    }

    //This method is for clicking share feedback button
    public void shareFeedBack() throws InterruptedException{
        openDoorPage = PageFactory.initElements(DRIVER, OpenDoorPage.class);
        WebDriverCommonLib.waitForPageToLoad();
        openDoorPage.shareFeedBack().click();
    }

    //This method is for adding the title
    public void enterTitle(String title) throws InterruptedException{
        openDoorPage = PageFactory.initElements(DRIVER, OpenDoorPage.class);
        WebDriverCommonLib.waitForPageToLoad();
        openDoorPage.title().sendKeys(title);
    }

    //This method is for clicking Idea link
    public void idea() throws InterruptedException{
        openDoorPage = PageFactory.initElements(DRIVER, OpenDoorPage.class);
        WebDriverCommonLib.waitForPageToLoad();
        openDoorPage.idea().click();
    }

    //This method is for verifying submit btn is enabled or not
    public void verifySubmitButton() throws InterruptedException{
        Boolean var;
        openDoorPage = PageFactory.initElements(DRIVER, OpenDoorPage.class);
        WebDriverCommonLib.waitForPageToLoad();
        var=openDoorPage.submit().isEnabled();
        Assert.assertTrue(var);
    }

}
