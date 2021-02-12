/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import calculadora.controller.Controller;
import calculadora.model.Model;
import calculadora.view.View;

/**
 *
 * @author ESCINF
 */
public class Proyecto2 {

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller  = new Controller(model,view);
        view.setVisible(true);
        
    }
    
}
