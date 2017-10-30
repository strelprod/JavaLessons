package Servlets;

import java.io.Serializable;

public class Calculator_3 implements Serializable{
    private float a;
    private float b;
    
    public Calculator_3(){ 
        a = 0;
        b = 0;
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
