package api_learning;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class PageHelper {
    private final static String SCROLL_TO_BOTTOM_SCRIPT = "window.scrollTo(0,document.body.scrollHeight)";
    private final static String SCROLL_TO_TOP_SCRIPT = "window.scrollTo(document.body.scrollHeight,0)";
    private final JavascriptExecutor javascriptExecutor;

    public PageHelper(JavascriptExecutor javascriptExecutor) {
        this.javascriptExecutor = javascriptExecutor;
    }

    public void scrollToBottom() {
        javascriptExecutor.executeScript(SCROLL_TO_BOTTOM_SCRIPT);

    }

    public void scrollToTop() {
        javascriptExecutor.executeScript(SCROLL_TO_TOP_SCRIPT);


    }

    public void removeElement(WebElement toBeRemovedElem) {
        javascriptExecutor.executeScript("arguments[0].remove()", toBeRemovedElem);


    }

    public void changeElemStyleToFocusMode(WebElement toBeChangedElem) {
        javascriptExecutor.executeScript("arguments[0].setAttribute('style', border:4px solid  red;')", toBeChangedElem);


    }

    public void changeElemStyleToFocusMode(WebElement toBeChangedElem, String customStyle) {
        //TODO: to be implemented
    }

}
