package com.aconex.OpenDoorLib.genericLib;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebDriverCommonLib {

 /*   WebDriver driver;
    public WebDriverCommonLib(WebDriver driver){
        this.driver = driver;
    }
*/

    boolean flag = false;

    public static void waitForPageToLoad(){
        Driver.DRIVER.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    public static void waitForLinkPresent(String linkName){
        WebDriverWait wait = new WebDriverWait(Driver.DRIVER, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.linkText(linkName)));

    }


    public static void waitForXpathPresent(String wbXpath){
        WebDriverWait wait = new WebDriverWait(Driver.DRIVER, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath(wbXpath)));

    }
    public static void waitForElementPresent(WebElement wbElement){
        WebDriverWait wait = new WebDriverWait(Driver.DRIVER, 20);
        wait.until(ExpectedConditions.visibilityOf(wbElement));

    }


    public static boolean verifyText(String wbXpath ,String expectText){
        boolean flag = false;
        String actText = Driver.DRIVER.findElement(By.xpath(wbXpath)).getText();
        if(expectText.equals(actText)){
            flag = true;
        }
        return flag;
    }

    public static boolean verifyTextPresent(String expectedText){
        boolean flag = false;
        String entirePageSource = Driver.DRIVER.getPageSource();
        if(entirePageSource.contains(expectedText)) {
            flag = true;
        }
        return flag;
    }

    public static void select(String selXpath , String value){
        WebElement wbSel = Driver.DRIVER.findElement(By.xpath(selXpath));
        Select sel = new Select(wbSel);
        sel.selectByVisibleText(value);

    }

    public static void select(String selXpath , int index){
        WebElement wbSel = Driver.DRIVER.findElement(By.xpath(selXpath));
        Select sel = new Select(wbSel);
        sel.selectByIndex(index);

    }

    public static void select(WebElement selWb , String val){

        Select sel = new Select(selWb);
        sel.selectByVisibleText(val);

    }
    public static void multipleSelect(List<String> strSearch,String xpath) {   ///need to handle multiple Data

        List<WebElement> listWeElements = Driver.DRIVER.findElements(By.xpath(xpath));
        for(WebElement element: listWeElements){

            for(String searchText:strSearch){
                Select select = new Select(element);
                if (element.getText().equals(searchText)){
                    select.selectByVisibleText(searchText);
                }
            }
        }

       /* Select oSelect = new Select(findElement(xpath));
        List multiSelect = oSelect.getOptions();
        int iListSize = multiSelect.size();
        for (int i = 0; i < iListSize; i++) {

            String sValue = oSelect.getOptions().get(i).getText();
            if (sValue.equals(strSearch)) {
                oSelect.selectByIndex(i);
                break;
            }
        }
*/
    }
    public static void acceptAlert() throws InterruptedException {
        Alert alt = Driver.DRIVER.switchTo().alert();
        Thread.sleep(500);
        System.out.println(alt.getText());
        alt.accept();

    }

    public static void cancelAlert(){
        Alert alt = Driver.DRIVER.switchTo().alert();
        System.out.println(alt.getText());
        alt.dismiss();

    }
    public static WebElement findElement(String locator) {

        WebElement element;
        try{
            element = Driver.DRIVER.findElement(By.id(locator));
        }catch (NoSuchElementException e1){
            try {
                element = Driver.DRIVER.findElement(By.xpath(locator));
            }catch (NoSuchElementException e2){
                try {
                    element = Driver.DRIVER.findElement(By.name(locator));
                }catch (NoSuchElementException e3){
                    try {
                        element = Driver.DRIVER.findElement(By.linkText(locator));
                    }catch (NoSuchElementException e4){
                        try {
                            element = Driver.DRIVER.findElement(By.className(locator));
                        }catch (NoSuchElementException e5){
                            try {
                                element = Driver.DRIVER.findElement(By.tagName(locator));
                            }catch (NoSuchElementException e6){
                                try {
                                    element = Driver.DRIVER.findElement(By.partialLinkText(locator));
                                }catch (NoSuchElementException e7){
                                    element = Driver.DRIVER.findElement(By.cssSelector(locator));
                                }

                            }
                        }
                    }
                }
            }
        }

        return element;

    }


    //This method is used to click the Enter Key
    public static void clickEnter()
    {
        Actions actions=new Actions(Driver.DRIVER);
        actions.sendKeys(Keys.RETURN).perform();

    }
}
