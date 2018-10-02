package lv.neotech.tapost.pageobjects;


import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lv.neotech.tapost.config.ApplicationProperties;
import lv.neotech.tapost.config.ApplicationProperties.ApplicationProperty;
import lv.neotech.tapost.core.DriverBase;
import lv.neotech.tapost.core.WebElementHelper;
import lv.neotech.tapost.pageobjects.base.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopBar extends Page {

    @FindBy(id = "menu")
    private WebElement navNavigationBarContainer;


    @FindBy(css = "#search.input")
    private WebElement inputSearchBar;


    @FindBy(css = ".navbar-nav > li")
    private List<WebElement> navBarElements;

    private WebElement getShoppingCartElement(){
        return DriverBase.getDriver().findElement(By.xpath("//*[@id='top']//a[@title='Shopping Cart']"));
    }


    public TopBar() {
        waitUntilLoaded();
    }

    @Override
    protected WebElement getControlElement() {
        return navNavigationBarContainer;
    }

    public static TopBar navigate() {
        WebElementHelper.navigateToPage(ApplicationProperties.getString(ApplicationProperty.APP_URL));
        return new TopBar();
    }

    public void navigateToShoppingCart() {
        getShoppingCartElement().click();
    }
    public boolean isPageDisplayed() {
        return WebElementHelper.isElementDisplayed(navNavigationBarContainer);
    }


    public boolean isSearchBarDisplayed() {
        return WebElementHelper.isElementDisplayed(navNavigationBarContainer);
    }



    public WebElement getNavBarElement(String navBarName){
        List<WebElement> list = navBarElements.stream().filter(el -> el.getText().equals(navBarName))
            .collect(Collectors.toList());

        if(list.size() > 1) throw new RuntimeException("More than one element is found for: " + navBarName);

        return list.get(0);
    }

    public void navigateTo(String navBarName){
        WebElement navBarElement = getNavBarElement(navBarName);

        if(navBarElement.getAttribute("class").contains("dropdown")){

        }else{
            WebElementHelper.click(navBarElement);
        }
    }


}