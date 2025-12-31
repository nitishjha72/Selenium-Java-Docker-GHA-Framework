package com.nitish.qa.factories;


import com.nitish.qa.enums.SelectBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public final class SelectFactory {

    public static void performSelect(WebElement element, SelectBy selectBy, String value) {
        Select select = new Select(element);
        if (selectBy == SelectBy.VALUE) {
            select.selectByValue(value);
        } else if (selectBy == SelectBy.INDEX) {
            select.selectByIndex(Integer.parseInt(value));
        } else if (selectBy == SelectBy.VISIBLE_TEXT) {
            select.selectByVisibleText(value);
        } else {
            select.selectByValue(value);
        }
    }

    public static List<WebElement> customGetAllOptions(WebElement element) {
        Select select = new Select(element);
        return select.getAllSelectedOptions();
    }
}
