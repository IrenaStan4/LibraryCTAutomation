package com.library.step_definitions;

import com.library.utilities.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class US1 {

    List <String> expectedList;

    @When("Execute query to get all IDs from users")
    public void execute_query_to_get_all_i_ds_from_users() {

        DB_Util.runQuery("Select count('id') From users");
        int expectedIDsCount = Integer.parseInt(DB_Util.getFirstRowFirstColumn());
        System.out.println("expectedIDsCount = " + expectedIDsCount);
    }

    @Then("verify all users has unique ID")
    public void verify_all_users_has_unique_id() {

        DB_Util.runQuery("SELECT count(\"id\") As \"Total Entries\" FROM users where id is null");
        int actualNonIDsCount = 0;
        int expectedNonIDsCount = Integer.parseInt(DB_Util.getFirstRowFirstColumn());
        Assert.assertEquals(expectedNonIDsCount, actualNonIDsCount);

    }

    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {

        DB_Util.runQuery("SELECT * FROM users");
        expectedList = DB_Util.getAllColumnNamesAsList();

    }

    @Then("verify the below columns are listed in result")
    public void verify_the_below_columns_are_listed_in_result(List<String> actualList) {

        System.out.println("actualList = " + actualList);
        System.out.println("expectedList = " + expectedList);
        Assert.assertEquals(expectedList, actualList);

    }
}
