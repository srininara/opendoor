package com.aconex.OpenDoorLib.pageObjRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenDoorPage {

//name
    @FindBy(id = "email")
    private WebElement name;
    public WebElement name(){
        return name;
    }

    //feed back
    @FindBy(id="feedback")
    private WebElement feedBack;

    public WebElement feedBack(){return feedBack;}

    //Location select
    @FindBy(id="location")
    private static WebElement location;

    public static WebElement selectLocation(){
        return location;
    }


    public WebElement selectRating(int rating){
        return this.rating;
    }

    //Rating select
    @FindBy(xpath = "//div[@class=\"bliss\"]/img[5]")
    private WebElement rating;
    //  @FindBy(xpath = "html/body/div[1]/form/div[4]/label[1]")
    //@FindBy(xpath = "html/body/div[1]/form/div[4]/label['+rating+']")
    // find(:xpath, "//option[@label='#{outcome}']", :wait => 60).click
    //li[@title='"+projectName+"']"))




    //Submit button
    @FindBy(xpath = "//button[@class=\"btn btn-default\"]")
    private WebElement submit;

    public WebElement submit(){
        return submit;
    }

    //clicking share feed back
    @FindBy(xpath = "//a[@class=\"share-feedback\"]")
    private WebElement shareFeedBack;

    public WebElement shareFeedBack(){
        return shareFeedBack;
    }

    //Entering title
    @FindBy(id="title")
    private WebElement title;

    public WebElement title(){
        return title;
    }

    //Clicking Idea link
    @FindBy(xpath = "html/body/div[1]/div/category/div[2]/div[1]/a")
    private WebElement idea;

    public WebElement idea(){
        return idea;
    }


}
