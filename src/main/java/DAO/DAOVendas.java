package DAO;

import Model.ModelVendas;
import Connection.ConexaoPostgre;
import java.util.ArrayList;
/**
*
* @author v1ct0r_f4r145
*/
public class DAOVendas extends ConexaoPostgre {

    /**
    * grava Vendas
    * @param pModelVendas
    * return int
    */
    public int salvarVendasDAO(ModelVendas pModelVendas){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tabela_vendas ("
                    + "fk_cliente,"
                    + "data_vendas,"
                    + "valor_liquido_venda,"
                    + "valor_bruto_venda,"
                    + "desconto_venda"
                + ") VALUES ("
                    + "'" + pModelVendas.getFk_cliente() + "',"
                    + "'" + pModelVendas.getData_venda() + "',"
                    + "'" + pModelVendas.getValor_liquido_venda() + "',"
                    + "'" + pModelVendas.getValor_bruto_venda() + "',"
                    + "'" + pModelVendas.getDesconto_venda() + "'"
                + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * recupera Vendas
    * @param pId_venda
    * return ModelVendas
    */
    public ModelVendas getVendasDAO(int pId_venda){
        ModelVendas modelVendas = new ModelVendas();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id_venda,"
                    + "fk_cliente,"
                    + "data_vendas,"
                    + "valor_liquido_venda,"
                    + "valor_bruto_venda,"
                    + "desconto_venda"
                 + " FROM"
                     + " tabela_vendas"
                 + " WHERE"
                     + "id_venda = '" + pId_venda + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendas.setId_venda(this.getResultSet().getInt(1));
                modelVendas.setFk_cliente(this.getResultSet().getInt(2));
                modelVendas.setData_venda(this.getResultSet().getDate(3));
                modelVendas.setValor_liquido_venda(this.getResultSet().getDouble(4));
                modelVendas.setValor_bruto_venda(this.getResultSet().getDouble(5));
                modelVendas.setDesconto_venda(this.getResultSet().getDouble(6));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelVendas;
    }

    /**
    * recupera uma lista de Vendas
        * return ArrayList
    */
    public ArrayList<ModelVendas> getListaVendasDAO(){
        ArrayList<ModelVendas> listamodelVendas = new ArrayList();
        ModelVendas modelVendas = new ModelVendas();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id_venda,"
                    + "fk_cliente,"
                    + "data_vendas,"
                    + "valor_liquido_venda,"
                    + "valor_bruto_venda,"
                    + "desconto_venda"
                 + " FROM"
                     + " tabela_vendas"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendas = new ModelVendas();
                modelVendas.setId_venda(this.getResultSet().getInt(1));
                modelVendas.setFk_cliente(this.getResultSet().getInt(2));
                modelVendas.setData_venda(this.getResultSet().getDate(3));
                modelVendas.setValor_liquido_venda(this.getResultSet().getDouble(4));
                modelVendas.setValor_bruto_venda(this.getResultSet().getDouble(5));
                modelVendas.setDesconto_venda(this.getResultSet().getDouble(6));
                listamodelVendas.add(modelVendas);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelVendas;
    }

    /**
    * atualiza Vendas
    * @param pModelVendas
    * return boolean
    */
    public boolean atualizarVendasDAO(ModelVendas pModelVendas){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tabela_vendas SET "
                    + "fk_cliente = '" + pModelVendas.getFk_cliente() + "',"
                    + "data_vendas = '" + pModelVendas.getData_venda() + "',"
                    + "valor_liquido_venda = '" + pModelVendas.getValor_liquido_venda() + "',"
                    + "valor_bruto_venda = '" + pModelVendas.getValor_bruto_venda() + "',"
                    + "desconto_venda = '" + pModelVendas.getDesconto_venda() + "'"
                + " WHERE "
                    + "id_venda = '" + pModelVendas.getId_venda() + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * exclui Vendas
    * @param pId_venda
    * return boolean
    */
    public boolean excluirVendasDAO(int pId_venda){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tabela_vendas "
                + " WHERE "
                    + "id_venda = '" + pId_venda + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
}