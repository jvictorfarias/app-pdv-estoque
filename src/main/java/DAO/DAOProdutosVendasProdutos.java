/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.ConexaoPostgre;
import Model.ModelProduto;
import Model.ModelProdutosVendasProdutos;
import Model.ModelVendasProdutos;
import java.util.ArrayList;

/**
 *
 * @author v1ct0r_f4r145
 */
public class DAOProdutosVendasProdutos extends ConexaoPostgre {

    // todos os produtos de uma determinada venda
    public ArrayList<ModelProdutosVendasProdutos> getListaProdutosVendasProdutosDAO(int codigoVenda) {
        ArrayList<ModelProdutosVendasProdutos> listaModelProdutosVendasProdutos = new ArrayList<>();
        ModelProdutosVendasProdutos modelProdutosVendasProdutos = new ModelProdutosVendasProdutos();
        ModelProduto modelProduto = new ModelProduto();
        ModelVendasProdutos modelVendasProdutos = new ModelVendasProdutos();

        /**
         * Visão CREATE VIEW produtos_vendas_produtos AS SELECT tabela_produto.id_produto, tabela_produto.estoque_produto, tabela_produto.nome_produto, tabela_produto.valor_produto,
         * tabela_vendas_produtos.id_venda_produto, tabela_vendas_produtos.fk_produto, tabela_vendas_produtos.fk_vendas, tabela_vendas_produtos.venda_produto_qtd,
         * tabela_vendas_produtos.venda_produto_valor FROM tabela_vendas_produtos INNER JOIN tabela_produto ON tabela_produto.id_produto = tabela_vendas_produtos.fk_produto
         *
         */
        try {
            this.conectar();
            this.executarSQL(
                    // Utilização da visão
                    "SELECT * "
                    + "FROM produtos_vendas_produtos "
                    + "WHERE produtos_vendas_produtos.fk_vendas =  '" + codigoVenda + "';"
            );

            while (this.getResultSet().next()) {
                modelProdutosVendasProdutos = new ModelProdutosVendasProdutos();
                modelProduto = new ModelProduto();

                //Model produto
                modelVendasProdutos = new ModelVendasProdutos();
                modelProduto.setIdProduto(this.getResultSet().getInt(1));
                modelProduto.setEstoqueProduto(this.getResultSet().getInt(2));
                modelProduto.setNomeProduto(this.getResultSet().getString(3));
                modelProduto.setValorProduto(this.getResultSet().getDouble(4));

                //Model vendas produtos
                modelVendasProdutos.setId_venda_produto(this.getResultSet().getInt(5));
                modelVendasProdutos.setFk_produto(this.getResultSet().getInt(6));
                modelVendasProdutos.setFk_venda(this.getResultSet().getInt(7));
                modelVendasProdutos.setVenda_produto_qtd(this.getResultSet().getInt(8));
                modelVendasProdutos.setVenda_produto_valor(this.getResultSet().getDouble(9));

                modelProdutosVendasProdutos.setModelProduto(modelProduto);
                modelProdutosVendasProdutos.setModelVendasProdutos(modelVendasProdutos);

                listaModelProdutosVendasProdutos.add(modelProdutosVendasProdutos);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelProdutosVendasProdutos;
    }
}
