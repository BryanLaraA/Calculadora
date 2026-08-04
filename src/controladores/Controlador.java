package controladores;

import Interfaz.frmInterfaz;
import clasesLogicas.Calculadora;

public class Controlador {
    
    private frmInterfaz frminterfaz;
    private Calculadora calculadora;
    private double primervalor;
    private boolean segundovalor;
    private String operacion;

    public Controlador(frmInterfaz frminterfaz, Calculadora calculadora, String operacion) {
        this.frminterfaz = frminterfaz;
        this.calculadora = calculadora;
        this.primervalor = 0;
        this.segundovalor = false;
        this.operacion = "";
    }
    
    
    

   
    
    
    
}