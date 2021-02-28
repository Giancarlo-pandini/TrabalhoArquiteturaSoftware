/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;

/**
 *
 * @author Giancarlo
 */
public class ControllerRestCliente {
    
    private ArrayList<String> clientes;

    public ControllerRestCliente() {
        clientes = new ArrayList();
    }
    
    public void addCliente(String jsonCliente) {
        this.clientes.add(jsonCliente);
    }
    
    public String getClientes() {
        String arrayClientes = "[";
        for (String cliente : clientes) {
            arrayClientes += cliente;
        }
        arrayClientes += "]";
        return arrayClientes;
    }
    
}
