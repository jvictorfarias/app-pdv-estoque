/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOProduto;
import Model.ModelProduto;
import java.util.ArrayList;

/**
 *
 * @author v1ct0r_f4r145
 */
public class ControllerProduto {
    private DAOProduto daoProduto = new DAOProduto();
    
    public int createProdutoController(ModelProduto pModelProduto){
        return this.daoProduto.createProdutoDAO(pModelProduto);
    }
    
    public boolean deleteProdutoController(int pCodigo){
        return this.daoProduto.deleteProdutoDAO(pCodigo);
    }
    
    public boolean updateProdutoController(ModelProduto pModelProduto){
        return this.daoProduto.updateProdutoDAO(pModelProduto);
    }
    
    public ModelProduto readProdutoController(int pCodigo){
        return this.daoProduto.readProdutoDAO(pCodigo);
    }
    
    public ModelProduto readProdutoController(String pNomeProduto){
        return this.daoProduto.readProdutoDAO(pNomeProduto);
    }
    public ArrayList<ModelProduto> readEstoqueProdutoController(){
        return this.daoProduto.readEstoqueDAO();
    }


    public boolean alterarEstoqueProduto(ArrayList<ModelProduto> listaModelProdutos) {
        return this.daoProduto.alteraEstoqueProdutoDAO(listaModelProdutos);
    }
}
