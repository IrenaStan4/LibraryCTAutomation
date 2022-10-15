package com.library.step_definitions;

import com.library.pages.HomePage;
import com.library.pages.LoginPage;
import com.library.utilities.BrowserUtils;
import com.library.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US2 {

    HomePage homePage = new HomePage();

    String actualResult;

    @Given("I am in the homepage of the library app")
    public void i_am_in_the_homepage_of_the_library_app() {

        new LoginPage().login();
        BrowserUtils.waitFor(5);
    }

    @When("I take borrowed books number")
    public void i_take_borrowed_books_number() {

        actualResult = homePage.borrowedBooks.getText();
        System.out.println(actualResult);
    }

    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {
        DB_Util.runQuery("SELECT COUNT(*)\n" +
                "FROM book_borrow\n" +
                "WHERE is_returned = 0");
        String expectedResult = DB_Util.getFirstRowFirstColumn();
        System.out.println("expectedResult from DB = " + expectedResult);

        Assert.assertEquals(actualResult, expectedResult);
    }

}
