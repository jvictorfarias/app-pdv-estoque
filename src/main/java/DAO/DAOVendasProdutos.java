package DAO;

import Model.ModelVendasProdutos;
import Connection.ConexaoPostgre;
import java.util.ArrayList;

/**
 *
 * @author v1ct0r_f4r145
 */
public class DAOVendasProdutos extends ConexaoPostgre {

    /**
     * grava VendasProdutos
     *
     * @param pModelVendasProdutos return int
     */
    public int salvarVendasProdutosDAO(ModelVendasProdutos pModelVendasProdutos) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO tabela_vendas_produtos ("
                    + "id_venda_produto,"
                    + "fk_vendas,"
                    + "fk_produto,"
                    + "venda_produto_valor,"
                    + "venda_produto_qtd"
                    + ") VALUES ("
                    + "'" + pModelVendasProdutos.getId_venda_produto() + "',"
                    + "'" + pModelVendasProdutos.getFk_venda() + "',"
                    + "'" + pModelVendasProdutos.getFk_produto() + "',"
                    + "'" + pModelVendasProdutos.getVenda_produto_valor() + "',"
                    + "'" + pModelVendasProdutos.getVenda_produto_qtd() + "'"
                    + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * recupera VendasProdutos
     *
     * @param pId_venda_produto return ModelVendasProdutos
     */
    public ModelVendasProdutos getVendasProdutosDAO(int pId_venda_produto) {
        ModelVendasProdutos modelVendasProdutos = new ModelVendasProdutos();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "id_venda_produto,"
                    + "fk_vendas,"
                    + "fk_produto,"
                    + "venda_produto_valor,"
                    + "venda_produto_qtd"
                    + " FROM"
                    + " tabela_vendas_produtos"
                    + " WHERE"
                    + " id_venda_produto = '" + pId_venda_produto + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelVendasProdutos.setId_venda_produto(this.getResultSet().getInt(1));
                modelVendasProdutos.setFk_venda(this.getResultSet().getInt(2));
                modelVendasProdutos.setFk_produto(this.getResultSet().getInt(3));
                modelVendasProdutos.setVenda_produto_valor(this.getResultSet().getDouble(4));
                modelVendasProdutos.setVenda_produto_qtd(this.getResultSet().getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelVendasProdutos;
    }

    /**
     * recupera uma lista de VendasProdutos return ArrayList
     */
    public ArrayList<ModelVendasProdutos> getListaVendasProdutosDAO() {
        ArrayList<ModelVendasProdutos> listamodelVendasProdutos = new ArrayList();
        ModelVendasProdutos modelVendasProdutos = new ModelVendasProdutos();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "id_venda_produto,"
                    + "fk_vendas,"
                    + "fk_produto,"
                    + "venda_produto_valor,"
                    + "venda_produto_qtd"
                    + " FROM"
                    + " tabela_vendas_produtos"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelVendasProdutos = new ModelVendasProdutos();
                modelVendasProdutos.setId_venda_produto(this.getResultSet().getInt(1));
                modelVendasProdutos.setFk_venda(this.getResultSet().getInt(2));
                modelVendasProdutos.setFk_produto(this.getResultSet().getInt(3));
                modelVendasProdutos.setVenda_produto_valor(this.getResultSet().getDouble(4));
                modelVendasProdutos.setVenda_produto_qtd(this.getResultSet().getInt(5));
                listamodelVendasProdutos.add(modelVendasProdutos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelVendasProdutos;
    }

    /**
     * atualiza VendasProdutos
     *
     * @param pModelVendasProdutos return boolean
     */
    public boolean atualizarVendasProdutosDAO(ModelVendasProdutos pModelVendasProdutos) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tabela_vendas_produtos SET "
                    + "id_venda_produto = '" + pModelVendasProdutos.getId_venda_produto() + "',"
                    + "fk_vendas = '" + pModelVendasProdutos.getFk_venda() + "',"
                    + "fk_produto = '" + pModelVendasProdutos.getFk_produto() + "',"
                    + "venda_produto_valor = '" + pModelVendasProdutos.getVenda_produto_valor() + "',"
                    + "venda_produto_qtd = '" + pModelVendasProdutos.getVenda_produto_qtd() + "'"
                    + " WHERE "
                    + "pk_id_venda_produto = '" + pModelVendasProdutos.getId_venda_produto() + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * exclui VendasProdutos
     *
     * @param pId_venda_produto return boolean
     */
    public boolean excluirVendasProdutosDAO(int pId_venda_produto) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tabela_vendas_produtos "
                    + " WHERE "
                    + "fk_vendas = '" + pId_venda_produto + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean salvarVendasProdutosDAO(ArrayList<ModelVendasProdutos> listaModelVendasProdutos) {
        try {
            this.conectar();
            int count = listaModelVendasProdutos.size();
            for (int i = 0; i < count; i++) {

                this.insertSQL(
                        "INSERT INTO tabela_vendas_produtos ("
                        + "fk_vendas,"
                        + "fk_produto,"
                        + "venda_produto_valor,"
                        + "venda_produto_qtd"
                        + ") VALUES ("
                        + "'" + listaModelVendasProdutos.get(i).getFk_venda() + "',"
                        + "'" + listaModelVendasProdutos.get(i).getFk_produto() + "',"
                        + "'" + listaModelVendasProdutos.get(i).getVenda_produto_valor() + "',"
                        + "'" + listaModelVendasProdutos.get(i).getVenda_produto_qtd() + "'"
                        + ");"
                );
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }

    }
}
