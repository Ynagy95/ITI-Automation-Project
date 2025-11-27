package proj.shopping.pages.components.system;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import proj.shopping.drivers.Driver;

public class ProductsPage2 {
    private Driver driver;
    public NavigationBar navg ;
    public ProductsPage productspage;



    public ProductsPage2(Driver driver) {
        this.driver = driver;
        this.navg = new NavigationBar(driver);
        this.productspage = new ProductsPage(driver);
    }
    private final By pageno = By.xpath( "//div[@class='pager']//a[text()='1']");
    private final By Previousbutton = By.xpath("//a[text()=\"Previous\"]");


    @Step("Click on Page Number")
    public ProductsPage clickonpageno() {
        driver.element().click(pageno);
        return new ProductsPage(driver);
    }
    @Step("Click on previous button")
    public ProductsPage clickonprev() {
        driver.element().click(Previousbutton);
        return new ProductsPage(driver);
    }


}
