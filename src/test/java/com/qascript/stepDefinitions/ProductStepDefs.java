package com.qascript.stepDefinitions;

import com.qascript.pageObjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductStepDefs {
    
    @Given("^User enters product name in Search field$")
    public void UserEntersProductInSearchField(){
        HomePage.enterTextIntoSearch("iphone 11");
    }

    @When("User clicks on Price-low-to-high link")
    public void userClicksOnPriceLowToHighLink() {
        HomePage.clickLinkLowToHigh();
    }

    @And("User clicks on first product with lowest price")
    public void userClicksOnFirstProductWithLowestPrice() {
        HomePage.clickFirstProduct();
    }

    @Then("User adds the product to cart")
    public void productDetailsAreDisplayedToTheUser() {
        HomePage.addProductToCart();
    }
}
