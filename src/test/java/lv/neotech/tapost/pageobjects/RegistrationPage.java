package lv.neotech.tapost.pageobjects;


import com.google.inject.Inject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.runtime.java.guice.ScenarioScoped;
import lv.neotech.tapost.config.ApplicationProperties;
import lv.neotech.tapost.config.ApplicationProperties.ApplicationProperty;
import lv.neotech.tapost.core.WebElementHelper;
import lv.neotech.tapost.pageobjects.base.Page;

import static java.lang.String.format;

@ScenarioScoped
public class RegistrationPage extends Page {

    @Inject
    private BreadcrumbsBar breadcrumbsBar;

    public RegistrationPage() {
    }

    @Override
    protected WebElement getControlElement() {
        return null;
    }

    @Override
    public boolean isPageDisplayed() {
        return breadcrumbsBar != null && breadcrumbsBar.getLastCrumb().equals("Register");
    }

    public void setInputFieldValue(String fieldName, String value) {
        WebElement element = driver.findElement(By.cssSelector(format("input[placeholder='%s']", fieldName)));
        element.sendKeys(value);
    }

    public static RegistrationPage navigate() {
        WebElementHelper.navigateToPage(ApplicationProperties.getString(ApplicationProperty.APP_URL));
        return new RegistrationPage();
    }

}