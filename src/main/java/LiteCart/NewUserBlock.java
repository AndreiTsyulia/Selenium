package LiteCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Andrei_Tsyulia on 5/2/2017.
 */
public class NewUserBlock
{
    protected WebDriver driver;
    protected WebDriverWait wait;

    public NewUserBlock(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    private String pageFlag = "//div[@id='box-create-account']/h1[text()='Create Account']";
    private String formTaxID = "//input[@name='tax_id']";
    private String formCompany = "//input[@name='company']";
    private String formFirstname = "//input[@name='firstname']";
    private String formLastname = "//input[@name='lastname']";
    private String formAddress1 = "//input[@name='address1']";
    private String formAddress2 = "//input[@name='address2']";
    private String formPostcode = "//input[@name='postcode']";
    private String formCity = "//input[@name='city']";
    private String formCountryCode = "//select[@name='country_code']";
    private String formOptionCountryCodeTemplate = "//select[@name='country_code']/option[text()='%s']";
    private String formZoneCode = "//select[@name='zone_code']";
    private String formOptionZoneCodeTemplate = "//select[@name='zone_code']/option[text()='%s']";
    private String formEmail = "//div[@id='box-create-account']//input[@name='email']";
    private String formPhone = "//input[@name='phone']";
    private String formPassword = "//div[@id='box-create-account']//input[@name='password']";
    private String formConfirmedPassword = "//input[@name='confirmed_password']";
    private String formCreateAccount = "//button[@name='create_account']";


    public boolean isNewUserBlock()
    {
        By lPageFlag = By.xpath(pageFlag);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lPageFlag));
        return driver.findElement(lPageFlag).isDisplayed();
    }

    public void fillTaxID(String taxID)
    {
        By lFormTaxID = By.xpath(formTaxID);
        driver.findElement(lFormTaxID).sendKeys(taxID);
    }

    public void fillCompany(String company)
    {
        By lFormCompany = By.xpath(formCompany);
        driver.findElement(lFormCompany).sendKeys(company);
    }

    public void fillFirstName(String firstname)
    {
        By lFormFirstname = By.xpath(formFirstname);
        driver.findElement(lFormFirstname).sendKeys(firstname);
    }

    public void fillLastName(String lastname)
    {
        By lFormLastname = By.xpath(formLastname);
        driver.findElement(lFormLastname).sendKeys(lastname);
    }

    public void fillAddress1(String address1)
    {
        By lFormAddress1 = By.xpath(formAddress1);
        driver.findElement(lFormAddress1).sendKeys(address1);
    }

    public void fillAddress2(String address2)
    {
        By lFormAddress2 = By.xpath(formAddress2);
        driver.findElement(lFormAddress2).sendKeys(address2);
    }

    public void fillPostcode(String postcode)
    {
        By lFormPostcode = By.xpath(formPostcode);
        driver.findElement(lFormPostcode).sendKeys(postcode);
    }

    public void fillCity(String city)
    {
        By lFormCity = By.xpath(formCity);
        driver.findElement(lFormCity).sendKeys(city);
    }

    public void fillCountry(String countryCode)
    {
        By lFormCountryCode = By.xpath(formCountryCode);
        driver.findElement(lFormCountryCode).click();
        By lFormOptionCountryCode = By.xpath(String.format(formOptionCountryCodeTemplate, countryCode));
        wait.until(ExpectedConditions.visibilityOfElementLocated(lFormOptionCountryCode));
        driver.findElement(lFormOptionCountryCode).click();
    }

    public void fillState(String state)
    {
        By lFormZoneCode = By.xpath(formZoneCode);
        driver.findElement(lFormZoneCode).click();
        By lFormOptionZoneCode = By.xpath(String.format(formOptionZoneCodeTemplate, state));
        wait.until(ExpectedConditions.visibilityOfElementLocated(lFormOptionZoneCode));
        driver.findElement(lFormOptionZoneCode).click();
    }

    public void fillEmail(String email)
    {
        By lFormEmail = By.xpath(formEmail);
        driver.findElement(lFormEmail).sendKeys(email);
    }

    public void fillPhone(String phone)
    {
        By lFormPhone = By.xpath(formPhone);
        driver.findElement(lFormPhone).sendKeys(phone);
    }

    public void fillPassword(String password)
    {
        By lFormPassword = By.xpath(formPassword);
        driver.findElement(lFormPassword).sendKeys(password);
    }

    public void fillConfirmPassword(String password)
    {
        By lFormConfirmPassword = By.xpath(formConfirmedPassword);
        driver.findElement(lFormConfirmPassword).sendKeys(password);
    }

    public void createAccount()
    {
        By lFormCreateAccount = By.xpath(formCreateAccount);
        driver.findElement(lFormCreateAccount).click();
    }


}