package Controller;

import Model.ModelCliente;
import DAO.DAOCliente;
import java.util.ArrayList;

/**
 *
 * @author v1ct0r_f4r145
 */
public class ControllerCliente {

    private DAOCliente daoCliente = new DAOCliente();

    /**
     * grava Cliente
     *
     * @param pModelCliente return int
     */
    public int salvarClienteController(ModelCliente pModelCliente) {
        return this.daoCliente.salvarClienteDAO(pModelCliente);
    }

    /**
     * recupera Cliente
     *
     * @param pId_cliente return ModelCliente
     */
    public ModelCliente getClienteController(int pId_cliente) {
        return this.daoCliente.getClienteDAO(pId_cliente);
    }

    public ModelCliente getClienteController(String pNomeCliente) {
        return this.daoCliente.getClienteDAO(pNomeCliente);
    }

    /**
     * recupera uma lista deCliente
     *
     * @param pId_cliente return ArrayList
     */
    public ArrayList<ModelCliente> getListaClienteController() {
        return this.daoCliente.getListaClienteDAO();
    }

    /**
     * atualiza Cliente
     *
     * @param pModelCliente return boolean
     */
    public boolean atualizarClienteController(ModelCliente pModelCliente) {
        return this.daoCliente.atualizarClienteDAO(pModelCliente);
    }

    /**
     * exclui Cliente
     *
     * @param pId_cliente return boolean
     */
    public boolean excluirClienteController(int pId_cliente) {
        return this.daoCliente.excluirClienteDAO(pId_cliente);
    }
}
