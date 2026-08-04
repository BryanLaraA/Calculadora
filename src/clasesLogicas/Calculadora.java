package clasesLogicas;

public class Calculadora {
    private double num1;
    private double num2;
    private String operacion;
    private boolean ingresandonum2;

    public Calculadora(double num1, double num2, String operacion) {
        this.num1 = num1;
        this.num2 = num2;
        this.operacion = operacion;
        this.ingresandonum2 = false;
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public String getOperacion() {
        return operacion;
    }

    public boolean isIngresandonum2() {
        return ingresandonum2;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public void setIngresandonum2(boolean ingresandonum2) {
        this.ingresandonum2 = ingresandonum2;
    }
    
    public double sumar(double num1, double num2){
        return num1+num2;
    }
    public double restar(double num1, double num2){
        return num1-num2;
    }
    public double multiblicar(double num1, double num2){
        return num1*num2;
    }
    public double dividir(double num1, double num2){
        return num1/num2;
    }
    
    
}
