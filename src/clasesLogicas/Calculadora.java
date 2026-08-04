package clasesLogicas;

import excepciones.IlegalExcepcionDivisionCero;
import excepciones.IlegalExcepcionValorInvalido;

public class Calculadora {
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
