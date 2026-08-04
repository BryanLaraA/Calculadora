package excepciones;

public class IlegalExcepcionDivisionCero extends ArithmeticException{
    public IlegalExcepcionDivisionCero() {
        System.out.println("Division ilegal, no se puede dividir por cero");
    }
}
