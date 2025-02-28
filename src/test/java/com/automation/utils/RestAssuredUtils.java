package com.automation.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RestAssuredUtils {

    static RequestSpecification requestSpecification= RestAssured.given();
    public static Response response;
    static String endPoint;

    public static void setEndPoint(String endPoint){
        RestAssuredUtils.endPoint=endPoint;
    }
    public static void setHeader(String key, String value){
        requestSpecification.header(key,value);
    }
    public static void setBody(Object pojo){
        try {
            requestSpecification.body(pojo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void setBody(String filepath){
        try {
            requestSpecification.body(getDataFromJsonFile(filepath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getDataFromJsonFile(String filename) throws FileNotFoundException {
        String jsonpath="src/test/resources/data/";
        Scanner sc=new Scanner(new FileInputStream(jsonpath+filename));
        String body= sc.useDelimiter("\\Z").next();
        return body;
    }
    public static void get(){
        requestSpecification.log().all();
        response=requestSpecification.get(endPoint);
        response.then().log().all();
    }
    public static void post(){
        requestSpecification.log().all();
        response=requestSpecification.post(endPoint);
        response.then().log().all();
    }
    public static void put(){
        requestSpecification.log().all();
        response=requestSpecification.put(endPoint);
        response.then().log().all();
    }
    public static void delete(){
        requestSpecification.log().all();
        response=requestSpecification.delete(endPoint);
        response.then().log().all();
    }
    public static int getStatusCode(){
        return response.getStatusCode();
    }

    public static String getDataFromJsonPath(String jsonPath){
        return response.jsonPath().getString(jsonPath);
    }
}
