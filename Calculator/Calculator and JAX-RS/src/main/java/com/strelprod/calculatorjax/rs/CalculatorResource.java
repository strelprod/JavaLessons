package com.strelprod.calculatorjax.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("calc")
public class CalculatorResource {
    @GET
    @Path("/{operator:[a-z]{3}}/{a:[+-]?\\d+}/{b:[+-]?\\d+}")
    public String getOperator (@PathParam(value="operator") String operator,
            @PathParam(value="a") Float a,
            @PathParam(value="b") Float b){
        return new Calculator(a, b, operator).getResult();
    }
}
