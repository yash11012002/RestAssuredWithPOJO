package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ResponseSteps {

    @Then("verify status code {int}")
    public void verify_status_code( int statusCode) {
        Assert.assertEquals(RestAssuredUtils.getStatusCode(),statusCode);
    }

    @When("user store {string} into {string}")
    public void userStoreInto(String jsonKey, String configKey) {
        String value= RestAssuredUtils.getDataFromJsonPath(jsonKey);
        ConfigReader.setConfigValue(configKey,value);
    }

    @Then("verify {string} is same as {string}")
    public void verifyIsSameAs(String jsonId, String configId) {
        Assert.assertEquals(RestAssuredUtils.getDataFromJsonPath(jsonId),ConfigReader.getConfigValue(configId));
    }

}
