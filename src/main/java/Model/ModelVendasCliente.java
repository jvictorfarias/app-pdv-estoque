
package Model;

import java.util.ArrayList;
import Model.ModelCliente;

/**
 *
 * @author v1ct0r_f4r145
 */
public class ModelVendasCliente {
    private ModelVendas modelVendas;
    private ModelCliente modelCliente;
    private ArrayList<ModelVendasCliente> listaModelVendasClientes = new ArrayList<>();

    public ModelVendas getModelVendas() {
        return modelVendas;
    }

    public void setModelVendas(ModelVendas modelVendas) {
        this.modelVendas = modelVendas;
    }

    public ModelCliente getModelCliente() {
        return modelCliente;
    }

    public void setModelCliente(ModelCliente modelCliente) {
        this.modelCliente = modelCliente;
    }

    public ArrayList<ModelVendasCliente> getListaModelVendasClientes() {
        return listaModelVendasClientes;
    }

    public void setListaModelVendasClientes(ArrayList<ModelVendasCliente> listaModelVendasClientes) {
        this.listaModelVendasClientes = listaModelVendasClientes;
    }
    
}
