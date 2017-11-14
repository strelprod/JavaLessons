package Servlets;

import java.io.Serializable;

public class Calculator_3 implements Serializable{
    private float a;
    private float b;
    private String result;
    private String operation;
            
    
    public Calculator_3(){ 
        a = 0;
        b = 0;
        result = "";
        operation = "";
    }
    
    public String getResult()
    {
        switch (this.operation){
            case "1" :
                result = String.valueOf(a + b);
                break;
            case "2" :
                result = String.valueOf(a - b);
                break;
            case "3" :
                result = String.valueOf(a * b);
                break;
            case "4" :
                if (b == (float)0)
                    result = "Division by zero!";
                else
                   result = String.valueOf(a / b); 
                break;
            case "5" :
                result = String.valueOf(Math.pow(a, b));
                break;
            case "6" :
                result += Integer.toBinaryString((int)a) + " | " + Integer.toBinaryString((int)b);
                break;
            case "7" :
                result += Integer.toOctalString((int)a) + " | " + Integer.toOctalString((int)b);
                break;   
            case "8" :
                result += Integer.toHexString((int)a) + " | " + Integer.toHexString((int)b);
                break;
            default :
                result = "Operation is not selected";
        }
        return result;
    }
    
    public void setResult(String result){
        this.result = result;
    }
    
    public void setOperation (String operation){
        this.operation = operation;
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
