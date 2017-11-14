package com.strelprod.calculatorjax.rs;

public class Calculator {
    
    private float a;
    private float b;
    private String result;
    private String operation;

    public Calculator(){ 
        this.a = 0;
        this.b = 0;
        result = "";
        operation = "";
    }
    public Calculator(float a, float b, String operation){ 
        this.a = a;
        this.b = b;
        result = "";
        this.operation = operation;
    }
    
    public String getResult()
    {
        switch (this.operation){
            case "sum" :
                result = String.valueOf(a + b);
                break;
            case "sub" :
                result = String.valueOf(a - b);
                break;
            case "pro" :
                result = String.valueOf(a * b);
                break;
            case "dev" :
                if (b == (float)0)
                    result = "Division by zero!";
                else
                   result = String.valueOf(a / b); 
                break;
            case "pow" :
                result = String.valueOf(Math.pow(a, b));
                break;
            case "bin" :
                result += Integer.toBinaryString((int)a) + " | " + Integer.toBinaryString((int)b);
                break;
            case "oct" :
                result += Integer.toOctalString((int)a) + " | " + Integer.toOctalString((int)b);
                break;   
            case "hex" :
                result += Integer.toHexString((int)a) + " | " + Integer.toHexString((int)b);
                break;
            default :
                result = "Operation is not selected";
        }
        return result;
    }
    
    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }
}
