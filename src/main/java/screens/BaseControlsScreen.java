package screens;

import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public abstract class BaseControlsScreen extends Screen {

    protected BaseControlsScreen(By locator, String name) {
        super(locator, name);
    }

    protected final String PACKAGE = "com.kickstarter.kickstarter";
    protected final String ELEMENT_LOCATOR_TEMPLATE = PACKAGE + ":id/%s";

    protected ILabel getLabel(String resource_id, String name){
        return getElementFactory().getLabel(
                By.id(String.format(ELEMENT_LOCATOR_TEMPLATE, resource_id)),
                resource_id + " label");
    }

    protected IButton getButton(String resource_id, String name){
        return getElementFactory().getButton(
                By.id(String.format(ELEMENT_LOCATOR_TEMPLATE, resource_id)),
                resource_id + " button");
    }

    protected ITextBox getTextBox(String resource_id, String name){
        return getElementFactory().getTextBox(
                By.id(String.format(ELEMENT_LOCATOR_TEMPLATE, resource_id)),
                resource_id + " text box");
    }
}
