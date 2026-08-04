package clasesLogicas;

import excepciones.IlegalExcepcionDivisionCero;
import excepciones.IlegalExcepcionValorInvalido;

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
    public double sumar(double num1, double num2) throws IlegalExcepcionValorInvalido{
        validarValores(num1,num2);
        return num1+num2;
    }
    public double restar(double num1, double num2)throws IlegalExcepcionValorInvalido{
        validarValores(num1,num2);
        return num1-num2;
    }
    public double multiblicar(double num1, double num2)throws IlegalExcepcionValorInvalido{
        validarValores(num1,num2);
        return num1*num2;
    }
    public double dividir(double num1, double num2)throws IlegalExcepcionValorInvalido, IlegalExcepcionDivisionCero{
        validarValores(num1,num2);
        if(num2==0){
            throw new IlegalExcepcionDivisionCero();
        }
        return num1/num2;
    }
    public void validarValores(double num1, double num2)throws IlegalExcepcionValorInvalido{
        if(Double.isNaN(num1)||Double.isNaN(num2)){
            throw new IlegalExcepcionValorInvalido("Valor Invalido");
        }
        if(Double.isInfinite(num1)||Double.isInfinite(num2)){
            throw new IlegalExcepcionValorInvalido("Valor Infinito");
        }
    }
    
}
