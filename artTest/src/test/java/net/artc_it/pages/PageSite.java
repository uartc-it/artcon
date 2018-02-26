package net.artc_it.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.chrome.ChromeOptions;

public class PageSite {

    final String SITEURL = "http://artc-it.net";

    public PageSite(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver.get(SITEURL);
    }

    public WebDriver driver;

    //    @FindBy(id = "name")
    @FindBy(how = How.ID, using = "name")
    private WebElement name;

    @FindBy(id = "tel")
    private WebElement phone;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "msg")
    private WebElement message;

    @FindBy(xpath = "//input[@value='Send']")
    private WebElement sendButton;

    @FindBy(how = How.XPATH, using = "id(\"contacts\")/div[2]/form[1]/span[1]")
    private WebElement resultMessage;

    @FindBy(how = How.XPATH, using = "id(\"main-nav\")/div[1]/a[2]")
    private WebElement langEn;

    public void setName(String name) {
        this.name.sendKeys(name);
    }

    public void setPhone(String phone) {
        this.phone.sendKeys(phone);
    }

    public void setEmail(String email) {
        this.email.sendKeys(email);
    }

    public void setMessage(String message) {
        this.message.sendKeys(message);
    }

    public void clickSendButton() {
        sendButton.click();
    }

    public String getExpectedResultMessage() {
        String langEnColor = langEn.getCssValue("color"); //rgba(0, 27, 51, 1) - active
        if (langEnColor.equals("rgba(0, 27, 51, 1)"))
            return "Your message has been sent";
        else return "Сообщение отправлено";
    }

    public String getTextResultMessage() {
        return resultMessage.getText();
    }

    public boolean isPresentResultMessage() {
        // пока не различиет, когда сообщение невидно !?
        //ExpectedConditions.visibilityOf(page.getResultMessage())
        return resultMessage.isDisplayed();
    }

    public void sendMessageForm(String name, String phone, String email, String message) {
        setName(name);
        setPhone(phone);
        setEmail(email);
        setMessage(message);
        clickSendButton();
    }
}


