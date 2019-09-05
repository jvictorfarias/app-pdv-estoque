/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOVendasCliente;
import Model.ModelVendasCliente;
import java.util.ArrayList;

/**
 *
 * @author v1ct0r_f4r145
 */
public class ControllerVendasCliente {
    
    private DAOVendasCliente daoVendasCliente = new DAOVendasCliente();

    public ArrayList<ModelVendasCliente> getListaVendasClienteController() {
        return this.daoVendasCliente.getListaVendasClienteDAO(); 
    }
    
}
