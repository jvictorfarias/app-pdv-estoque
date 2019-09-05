/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.ConexaoPostgre;
import Model.ModelProduto;
import java.util.ArrayList;

@SuppressWarnings("CallToPrintStackTrace")
/**
 *
 * @author v1ct0r_f4r145
 */
public class DAOProduto extends ConexaoPostgre {

// Cria os produtos
    public int createProdutoDAO(ModelProduto pModelProduto) {
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO tabela_produto ("
                    + " nome_produto,"
                    + " valor_produto,"
                    + "estoque_produto)"
                    + " VALUES ("
                    + "'" + pModelProduto.getNomeProduto() + "',"
                    + "'" + pModelProduto.getValorProduto() + "',"
                    + "'" + pModelProduto.getEstoqueProduto() + "'" + ");");

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }

    }

// Deletar produtos
    public boolean deleteProdutoDAO(int pIdProduto) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tabela_produto WHERE id_produto = '" + pIdProduto + "'");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean updateProdutoDAO(ModelProduto pModelProduto) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tabela_produto SET "
                    + "nome_produto = '" + pModelProduto.getNomeProduto() + "',"
                    + "valor_produto = '" + pModelProduto.getValorProduto() + "',"
                    + "estoque_produto = '" + pModelProduto.getEstoqueProduto() + "' "
                    + " WHERE id_produto = '" + pModelProduto.getIdProduto() + "';"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public ModelProduto readProdutoDAO(int pIdProduto) {
        ModelProduto modelProduto = new ModelProduto();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "id_produto, "
                    + "nome_produto,"
                    + "valor_produto,"
                    + "estoque_produto "
                    + "FROM tabela_produto "
                    + "WHERE id_produto = '" + pIdProduto + "';");
            while (this.getResultSet().next()) {
                modelProduto.setIdProduto(this.getResultSet().getInt(1));
                modelProduto.setNomeProduto(this.getResultSet().getString(2));
                modelProduto.setValorProduto(this.getResultSet().getDouble(3));
                modelProduto.setEstoqueProduto(this.getResultSet().getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelProduto;
    }

    public ModelProduto readProdutoDAO(String pNomeProduto) {
        ModelProduto modelProduto = new ModelProduto();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "id_produto, "
                    + "nome_produto,"
                    + "valor_produto,"
                    + "estoque_produto "
                    + "FROM tabela_produto "
                    + "WHERE nome_produto = '" + pNomeProduto + "';");
            while (this.getResultSet().next()) {
                modelProduto.setIdProduto(this.getResultSet().getInt(1));
                modelProduto.setNomeProduto(this.getResultSet().getString(2));
                modelProduto.setValorProduto(this.getResultSet().getDouble(3));
                modelProduto.setEstoqueProduto(this.getResultSet().getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelProduto;
    }

    public ArrayList<ModelProduto> readEstoqueDAO() {
        ArrayList<ModelProduto> listaProdutos = new ArrayList<>();
        ModelProduto modelProduto = new ModelProduto();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "id_produto, "
                    + "nome_produto,"
                    + "valor_produto,"
                    + "estoque_produto "
                    + "FROM tabela_produto ");
            while (this.getResultSet().next()) {
                modelProduto = new ModelProduto();
                modelProduto.setIdProduto(this.getResultSet().getInt(1));
                modelProduto.setNomeProduto(this.getResultSet().getString(2));
                modelProduto.setValorProduto(this.getResultSet().getDouble(3));
                modelProduto.setEstoqueProduto(this.getResultSet().getInt(4));
                listaProdutos.add(modelProduto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaProdutos;

    }

    // Altera o estoque de produtos no banco
    public boolean alteraEstoqueProdutoDAO(ArrayList<ModelProduto> listaModelProdutos) {
        try {
            this.conectar();
            for (int i = 0; i < listaModelProdutos.size(); i++) {
                this.executarUpdateDeleteSQL(
                        "UPDATE tabela_produto SET "
                        + "estoque_produto = '" + listaModelProdutos.get(i).getEstoqueProduto() + "' "
                        + " WHERE id_produto = '" + listaModelProdutos.get(i).getIdProduto() + "';"
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
