


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class MyComplex {
    private  double real;
    private  double imag;
    public MyComplex(double real, double imag){
        this.real = real;
        this.imag = imag;
    }
    public double getReal(){
        return real;
    }
    public void setReal(double real){
        this.real = real;
    }
    public double getImag(){
        return imag;
    }
    public void setImag(double imag){
        this.imag = imag;
    }
    public void setValue(double real, double imag){
        this.real = real;
        this.imag = imag;       
    }
    public  String toString(){
        return "("+real + "+" + imag +"i)";
    }
    public boolean isReal(){
        return real == 0;
    }
    public boolean isImaginary(){
        return imag == 0;
    }
     public boolean equals(double real, double imag) {
         return this.real == real && this.imag == imag;
     //   return Math.abs(this.real - real) < 1e-8 && Math.abs(this.imag - imag) < 1e-8;
    }
    public  boolean  equals(MyComplex another){
        return this.real == another.real && this.imag == another.real;
      //  return Math.abs(this.real - another.real)<1e-8 && Math.abs(this.imag - another.imag)<1e-8;
    }
    public double magnitude(){
        return Math.sqrt(real*real+ imag*imag);
    }
    public double argumentInRadians(){
        return Math.atan2(imag, real);
    }
    public int argumentInDegrees(){
        return (int) Math.toDegrees(Math.atan2(imag, real));
    }
    public MyComplex conjugate(){
        return new MyComplex(real, - imag);
    }
    public MyComplex add(MyComplex another){
        return new MyComplex(this.real+another.real, this.imag+ another.imag);
    }
    public MyComplex subtract(MyComplex another){
        return new MyComplex(this.real - another.real, this.imag - another.imag);
    }
     public MyComplex multiplyWith(MyComplex another){
        double r1 = this.real * another.real -this.imag * another.imag;
        double i1 = this.real * another.imag + this.imag*another.real;
        this.real = r1;
        this.imag = i1;
        return this;
    }
     public MyComplex divideBy(MyComplex another){
        double a = another.real* another.real+ another.imag*another.imag;
        double r2 = (this.real * another.real + this.imag * another.imag)/a;
        double i2 = (this.real * another.imag - this.imag*another.real)/a;
        this.real = r2;
        this.imag = i2;
        return this;
    }
}
