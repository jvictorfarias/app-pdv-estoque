/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOProdutosVendasProdutos;
import Model.ModelProdutosVendasProdutos;
import java.util.ArrayList;

/**
 *
 * @author v1ct0r_f4r145
 */
public class ControllerProdutosVendasProdutos {
    private DAO.DAOProdutosVendasProdutos daoProdutosVendasProdutos = new DAOProdutosVendasProdutos();
    public ArrayList<ModelProdutosVendasProdutos> getListaProdutosVendasProdutosController(int codigoVenda){
        return this.daoProdutosVendasProdutos.getListaProdutosVendasProdutosDAO(codigoVenda);
    }
}
