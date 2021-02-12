/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.model;

import java.util.Observable;

/**
 *
 * @author Danny
 */
public class Model extends Observable {

    String current;
    Double memory;
    String operation;

    public Model() {
        this.current = "0";
        this.memory = 0.0;
        this.operation = "";
    }

    public String getCurrent() {
        return current;
    }

    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o); //To change body of generated methods, choose Tools | Templates.
        setChanged();
        notifyObservers(null);
    }

    public void digit(char d) {
        //establece el valor de current
        if (d == 'π') {
            current = ((current.equals("0")) ? "" : current) + Math.PI;
            System.out.println("entra constante PI");
        }
        if (d == 'e') {
            current = ((current.equals("0")) ? "" : current) + Math.E;
            System.out.println("entra constante E");
        } else {
            if (d != 'π') {
                current = ((current.equals("0")) ? "" : current) + d;
                System.out.println("Entra numero 0-9");
            }

        }

        //si es igual a 0, pone "", sino anade el valor actual
        //notifica a los objetos subscritos
        this.setChanged();
        this.notifyObservers(null);
    }

    public int factorial(int n) {
        return (n == 1 || n == 0) ? 1 : n * factorial(n - 1);
    }

    public void operation(String op) {
        //pasa a memoria el valor de actual
        //actualiza el valor de actual y define la operacion
        memory = Double.parseDouble(current);
        //current = "0";
        current = " ";
        operation = op;

        //metodos parte del patron observador
        setChanged();
        notifyObservers(null);

        System.out.print("Entra operacion: ");
        System.out.println(memory);
    }

    public void clear() {
        //current = "0";
        memory = 0.0;
        current = " ";
        //metodos de patron observador
        setChanged();
        notifyObservers(null);
    }

    public void compute() {
        switch (operation) {
            case "+":
                memory = memory + Double.parseDouble(current);
                break;

            case "-":
                memory = memory - Double.parseDouble(current);
                break;

            case "*":
                memory = memory * Double.parseDouble(current);
                break;

            case "/":
                memory = memory / Double.parseDouble(current);
                break;

            case "<-":
//                String aux = Double.toString(memory);
//                aux = aux.replace(aux.charAt(aux.lastIndexOf(aux)),' ');
//                System.out.println("valor de aux: " + aux);
//                memory = Double.parseDouble(aux);
                break;
                
            case "t":
                double d = Math.round(memory);
                memory = d;
                break;

            case "|":
                memory = Math.abs(memory);
                break;

            case "raiz":
                memory = Math.sqrt(memory);
                break;

            case "!":
                double f = factorial(memory.intValue());
                memory = f;
                break;

            case "Sin":
                memory = Math.sin(Math.toRadians(memory));
                break;

            case "Cos":
                memory = Math.cos(Math.toRadians(memory));
                break;

            case "Tan":
                memory = Math.tan(Math.toRadians(memory));
                break;

            case "Log":
                memory = Math.log(memory);
                break;
        }

        current = "" + memory;
        operation = " ";

        setChanged();
        notifyObservers(null);

    }
}
