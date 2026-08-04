package controladores;

import Interfaz.frmInterfaz;
import clasesLogicas.Calculadora;
import excepciones.IlegalExcepcionCampoVacio;
import excepciones.IlegalExcepcionDivisionCero;
import excepciones.IlegalExcepcionValorInvalido;

public class Controlador {

    private final frmInterfaz vista;
    private final Calculadora calculadora;

    private String entradaActual;
    private double primerValor;
    private double segundoValor;
    private String operacionSeleccionada;
    private boolean hayPrimerValor;
    private boolean hayOperacion;
    private boolean resultadoMostrado;

    public Controlador(frmInterfaz vista, Calculadora calculadora) {
        this.vista = vista;
        this.calculadora = calculadora;
        reiniciar();
    }

    public void agregarNumero(int digito) {
        if (resultadoMostrado) {
            entradaActual = "";
            resultadoMostrado = false;
        }
        if (entradaActual.equals("0")) {
            entradaActual = "";
        }
        entradaActual += digito;
        vista.mostrarPantalla(entradaActual);
    }

    public void agregarPunto() {
        if (resultadoMostrado) {
            entradaActual = "";
            resultadoMostrado = false;
        }
        if (entradaActual.isEmpty()) {
            entradaActual = "0";
        }
        if (!entradaActual.contains(".")) {
            entradaActual += ".";
            vista.mostrarPantalla(entradaActual);
        }
    }

    public void cambiarSigno() {
        if (entradaActual.isEmpty() || entradaActual.equals("0")) {
            return;
        }
        if (entradaActual.startsWith("-")) {
            entradaActual = entradaActual.substring(1);
        } else {
            entradaActual = "-" + entradaActual;
        }
        vista.mostrarPantalla(entradaActual);
    }

    public void seleccionarOperacion(String operacion) {
        if (!hayPrimerValor && entradaActual.isEmpty()) {
            vista.mostrarError("Debe ingresar un numero antes de seleccionar una operacion.");
            return;
        }
        if (hayOperacion && entradaActual.isEmpty()) {
            vista.mostrarError("Ya selecciono una operacion. Ingrese el segundo valor antes de elegir otra.");
            return;
        }
        try {
            if (!hayPrimerValor) {
                primerValor = convertirADouble(entradaActual);
                hayPrimerValor = true;
            }
            operacionSeleccionada = operacion;
            hayOperacion = true;
            entradaActual = "";
            resultadoMostrado = false;
        } catch (IlegalExcepcionCampoVacio e) {
            vista.mostrarError(e.getMessage());
        } catch (NumberFormatException e) {
            vista.mostrarError("El valor ingresado no es un numero valido.");
        }
    }

    public void calcularResultado() {
        if (!hayPrimerValor || !hayOperacion) {
            vista.mostrarError("Debe seleccionar una operacion antes de calcular.");
            return;
        }
        if (entradaActual.isEmpty()) {
            vista.mostrarError("Debe ingresar el segundo valor antes de calcular.");
            return;
        }
        try {
            segundoValor = convertirADouble(entradaActual);
            double resultado = ejecutarOperacion(operacionSeleccionada, primerValor, segundoValor);

            vista.mostrarPantalla(formatearResultado(resultado));

            primerValor = resultado;
            hayPrimerValor = true;
            hayOperacion = false;
            operacionSeleccionada = "";
            entradaActual = "";
            resultadoMostrado = true;
        } catch (IlegalExcepcionCampoVacio e) {
            vista.mostrarError(e.getMessage());
        } catch (NumberFormatException e) {
            vista.mostrarError("El valor ingresado no es un numero valido.");
        } catch (IlegalExcepcionValorInvalido e) {
            vista.mostrarError(e.getMessage());
        } catch (IlegalExcepcionDivisionCero e) {
            vista.mostrarError(e.getMessage());
        }
    }

    public void borrarUltimoCaracter() {
        if (!entradaActual.isEmpty()) {
            entradaActual = entradaActual.substring(0, entradaActual.length() - 1);
        }
        vista.mostrarPantalla(entradaActual.isEmpty() ? "0" : entradaActual);
    }

    public void limpiarPantalla() {
        entradaActual = "";
        resultadoMostrado = false;
        vista.mostrarPantalla("0");
    }

    public final void reiniciar() {
        entradaActual = "";
        primerValor = 0;
        segundoValor = 0;
        operacionSeleccionada = "";
        hayPrimerValor = false;
        hayOperacion = false;
        resultadoMostrado = false;
        vista.mostrarPantalla("0");
    }

    private double ejecutarOperacion(String operacion, double num1, double num2)
            throws IlegalExcepcionValorInvalido, IlegalExcepcionDivisionCero {
        switch (operacion) {
            case "+": return calculadora.sumar(num1, num2);
            case "-": return calculadora.restar(num1, num2);
            case "*": return calculadora.multiplicar(num1, num2);
            case "/": return calculadora.dividir(num1, num2);
            default: throw new IllegalStateException("Operacion no reconocida: " + operacion);
        }
    }

    private double convertirADouble(String texto) throws IlegalExcepcionCampoVacio {
        if (texto == null || texto.trim().isEmpty() || texto.equals("-")) {
            throw new IlegalExcepcionCampoVacio();
        }
        return Double.parseDouble(texto);
    }

    private String formatearResultado(double valor) {
        if (!Double.isInfinite(valor) && !Double.isNaN(valor) && valor == Math.rint(valor)
                && Math.abs(valor) < 1_000_000_000L) {
            return String.valueOf((long) valor);
        }
        return String.valueOf(valor);
    }
}