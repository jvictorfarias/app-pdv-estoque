/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ModelVendas;
import Model.ModelVendasCliente;
import java.util.ArrayList;
import Model.ModelCliente;

/**
 *
 * @author v1ct0r_f4r145
 */
public class DAOVendasCliente extends Connection.ConexaoPostgre {

    public ArrayList<ModelVendasCliente> getListaVendasClienteDAO() {
        ArrayList<ModelVendasCliente> listaModelVendasClientes = new ArrayList();
        ModelVendas modelVendas = new ModelVendas();
        ModelCliente modelCliente = new ModelCliente();
        ModelVendasCliente modelVendasCliente = new ModelVendasCliente();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT * from vendas_cliente"
            );

            while (this.getResultSet().next()) {
                modelVendas = new ModelVendas();
                modelCliente = new ModelCliente();
                modelVendasCliente = new ModelVendasCliente();
                modelVendas.setId_venda(this.getResultSet().getInt(1));
                modelVendas.setFk_cliente(this.getResultSet().getInt(2));
                modelVendas.setData_venda(this.getResultSet().getDate(3));
                modelVendas.setValor_liquido_venda(this.getResultSet().getDouble(4));
                modelVendas.setValor_bruto_venda(this.getResultSet().getDouble(5));
                modelVendas.setDesconto_venda(this.getResultSet().getDouble(6));

                modelCliente.setId_cliente(this.getResultSet().getInt(7));
                modelCliente.setNome_cliente(this.getResultSet().getString(8));
                modelCliente.setBairro_cliente(this.getResultSet().getString(9));
                modelCliente.setCidade_cliente(this.getResultSet().getString(10));
                modelCliente.setUf_cliente(this.getResultSet().getString(11));
                modelCliente.setCep_cliente(this.getResultSet().getString(12));
                modelCliente.setEndereco_cliente(this.getResultSet().getString(13));
                modelCliente.setTelefone_cliente(this.getResultSet().getString(14));
                
                modelVendasCliente.setModelVendas(modelVendas);
                modelVendasCliente.setModelCliente(modelCliente);
                
                listaModelVendasClientes.add(modelVendasCliente);
                 
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelVendasClientes;
    }
}
