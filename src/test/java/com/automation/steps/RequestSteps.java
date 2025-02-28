package com.automation.steps;

import com.automation.pojo.CreateRequestPojo;
import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class RequestSteps {

    @Given("user set endpoint {string}")
    public void user_set_endpoint(String endPoint) {
        RestAssuredUtils.setEndPoint(endPoint);
    }
    @When("user set header {string} to {string}")
    public void user_set_header_to(String key, String value) {
        RestAssuredUtils.setHeader(key,value);
    }
    @When("set body {string}")
    public void set_body(String filename) {
        RestAssuredUtils.setBody(filename);
    }
    @When("user call post HTTP request")
    public void user_call_post_http_request() {
        RestAssuredUtils.post();
    }


    @When("user set endpoint with id {string}")
    public void userSetEndpointWithId(String endPoint) {
        RestAssuredUtils.setEndPoint(endPoint+ ConfigReader.getConfigValue("config.id"));
    }

    @And("set request body from file {string} with {string} value {string}")
    public void setRequestBodyFromFileWithValue(String filePath, String fieldName, String value) throws Exception {
        String content = RestAssuredUtils.getDataFromJsonFile(filePath);
        System.out.println("=========>"+content);
        ObjectMapper objectMapper = new ObjectMapper();
        CreateRequestPojo requestPojo = objectMapper.readValue(content, CreateRequestPojo.class);
        requestPojo.setName(value);
        RestAssuredUtils.setBody(requestPojo);
        ConfigReader.setObject("request_pojo", requestPojo);
    }

    @When("user call put HTTP request")
    public void userCallPutHTTPRequest() {
        RestAssuredUtils.put();
    }

    @When("user call delete HTTP request")
    public void userCallDeleteHTTPRequest() {
        RestAssuredUtils.delete();
    }

    @When("user call get HTTP request")
    public void userCallGetHTTPRequest() {
        RestAssuredUtils.get();
    }
}
