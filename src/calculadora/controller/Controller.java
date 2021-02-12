/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.controller;

import calculadora.model.Model;
import calculadora.view.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author Danny
 */
public class Controller implements MouseListener, ActionListener {

    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //obtiene el nombre de la variable boton que se presiono
        JButton digit = (JButton) e.getSource();

        //llama a digit de modelo 
        model.digit(digit.getText().charAt(0));
        System.out.print("mouse event clicked: ");
        System.out.println(digit.getText().charAt(0));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.print("Entra action Perfomed: ");
        System.out.println(e.getActionCommand());
        switch (e.getActionCommand()) {
            case "C":
                model.clear();
                break;
            case "+":
                model.operation("+");
                break;
            case "-":
                model.operation("-");
                break;
            case "*":
                model.operation("*");
                break;
            case "/":
                model.operation("/");
                break;
            case "<-":
                model.operation("<-");
                break;
            case "t":
                model.operation("t");
                break;
            case "raiz":
                model.operation("raiz");
                break;
            case "!":
                model.operation("!");
                break;
            case "|":
                model.operation("|");
                break;
            case "Sin":
                model.operation("Sin");
                break;
            case "Cos":
                model.operation("Cos");
                break;
            case "Tan":
                model.operation("Tan");
                break;
            case "Log":
                model.operation("Log");
                break;
            case "=":
                model.compute();
                break;
        }
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

}
