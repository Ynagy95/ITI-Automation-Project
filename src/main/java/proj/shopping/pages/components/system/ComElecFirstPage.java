package proj.shopping.pages.components.system;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import proj.shopping.drivers.Driver;

public class ComElecFirstPage {
    private Driver driver;
    public NavigationBar navg ;



    public ComElecFirstPage(Driver driver) {
        this.driver = driver;
        this.navg = new NavigationBar(driver);
    }


    private By productTitle(String productTitle) {
        return By.xpath("//h2[@class='title']/a[normalize-space(text())='" + productTitle + "']");
    }
    private By productImage(String productTitle) {
        return By.xpath("//img[@alt='Picture for category " + productTitle + "']");
    }




    @Step("click on product Title")
    public ProductsPage clickonproducttitle(String productTitle) {
        driver.element().click(productTitle(productTitle));
        return new ProductsPage(driver);
    }
    @Step("click on product Image")
    public ProductsPage clickonproductimage(String productTitle) {
        driver.element().click(productImage(productTitle));
        return new ProductsPage(driver);
    }
}


