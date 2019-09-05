package Controller;

import Model.ModelVendasProdutos;
import DAO.DAOVendasProdutos;
import java.util.ArrayList;

/**
*
* @author v1ct0r_f4r145
*/
public class ControllerVendasProdutos {

    private DAOVendasProdutos daoVendasProdutos = new DAOVendasProdutos();

    /**
    * grava VendasProdutos
    * @param pModelVendasProdutos
    * return int
    */
    public int salvarVendasProdutosController(ModelVendasProdutos pModelVendasProdutos){
        return this.daoVendasProdutos.salvarVendasProdutosDAO(pModelVendasProdutos);
    }

    /**
    * recupera VendasProdutos
    * @param pId_venda_produto
    * return ModelVendasProdutos
    */
    public ModelVendasProdutos getVendasProdutosController(int pId_venda_produto){
        return this.daoVendasProdutos.getVendasProdutosDAO(pId_venda_produto);
    }

    /**
    * recupera uma lista deVendasProdutos
    * @param pId_venda_produto
    * return ArrayList
    */
    public ArrayList<ModelVendasProdutos> getListaVendasProdutosController(){
        return this.daoVendasProdutos.getListaVendasProdutosDAO();
    }

    /**
    * atualiza VendasProdutos
    * @param pModelVendasProdutos
    * return boolean
    */
    public boolean atualizarVendasProdutosController(ModelVendasProdutos pModelVendasProdutos){
        return this.daoVendasProdutos.atualizarVendasProdutosDAO(pModelVendasProdutos);
    }

    /**
    * exclui VendasProdutos
    * @param pId_venda_produto
    * return boolean
    */
    public boolean excluirVendasProdutosController(int pId_venda_produto){
        return this.daoVendasProdutos.excluirVendasProdutosDAO(pId_venda_produto);
    }

    public boolean salvarVendasProdutosController(ArrayList<ModelVendasProdutos> listaModelVendasProdutos) {
        return this.daoVendasProdutos.salvarVendasProdutosDAO(listaModelVendasProdutos);
    }
}