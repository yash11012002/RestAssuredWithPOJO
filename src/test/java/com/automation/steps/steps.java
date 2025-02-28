package com.automation.steps;

import com.automation.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class steps {

    @Before
    public void setUp(){
        ConfigReader.initConfig();
        RestAssured.baseURI="https://67c01051b9d02a9f22482bb7.mockapi.io/turkar";
        RestAssured.useRelaxedHTTPSValidation();

    }


}
