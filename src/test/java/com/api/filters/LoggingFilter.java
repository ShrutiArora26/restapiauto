package com.api.filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingFilter implements Filter {

    private static final Logger Logger = LogManager.getLogger(LoggingFilter.class);

    @Override
    public Response filter(FilterableRequestSpecification requestSpec ,
                                     FilterableResponseSpecification responseSpec,
                                     FilterContext ctx) {
        logRequest(requestSpec);
        Response response = ctx.next(requestSpec,responseSpec);
        logResponse(response);
        return response;
    }

    public void logRequest(FilterableRequestSpecification requestSpecification){
       Logger.info("BASE URI: "+requestSpecification.getBaseUri());
       Logger.info("Request Header: "+requestSpecification.getHeaders());
       Logger.info("Request Payload: "+requestSpecification.getBody());
    }

    public void logResponse(Response response){
        Logger.info("Status Code:" + response.getStatusCode());
        Logger.info("Response Header:" + response.headers());
        Logger.info("Response Body:" + response.getBody().prettyPrint());

    }


}
