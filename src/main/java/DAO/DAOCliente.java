package DAO;

import Model.ModelCliente;
import Connection.ConexaoPostgre;
import java.util.ArrayList;
/**
*
* @author v1ct0r_f4r145
*/
public class DAOCliente extends ConexaoPostgre {

    /**
    * grava Cliente
    * @param pModelCliente
    * return int
    */
    public int salvarClienteDAO(ModelCliente pModelCliente){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tabela_cliente ("
                    + "nome_cliente,"
                    + "bairro_cliente,"
                    + "cidade_cliente,"
                    + "uf_cliente,"
                    + "cep_cliente,"
                    + "endereco_cliente,"
                    + "telefone_cliente"
                + ") VALUES ("
                    + "'" + pModelCliente.getNome_cliente() + "',"
                    + "'" + pModelCliente.getBairro_cliente() + "',"
                    + "'" + pModelCliente.getCidade_cliente() + "',"
                    + "'" + pModelCliente.getUf_cliente() + "',"
                    + "'" + pModelCliente.getCep_cliente() + "',"
                    + "'" + pModelCliente.getEndereco_cliente() + "',"
                    + "'" + pModelCliente.getTelefone_cliente() + "'"
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
    * recupera Cliente
    * @param pId_cliente
    * return ModelCliente
    */
    public ModelCliente getClienteDAO(int pId_cliente){
        ModelCliente modelCliente = new ModelCliente();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id_cliente,"
                    + "nome_cliente,"
                    + "bairro_cliente,"
                    + "cidade_cliente,"
                    + "uf_cliente,"
                    + "cep_cliente,"
                    + "endereco_cliente,"
                    + "telefone_cliente"
                 + " FROM"
                     + " tabela_cliente"
                 + " WHERE"
                     + " id_cliente = '" + pId_cliente + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCliente.setId_cliente(this.getResultSet().getInt(1));
                modelCliente.setNome_cliente(this.getResultSet().getString(2));
                modelCliente.setBairro_cliente(this.getResultSet().getString(3));
                modelCliente.setCidade_cliente(this.getResultSet().getString(4));
                modelCliente.setUf_cliente(this.getResultSet().getString(5));
                modelCliente.setCep_cliente(this.getResultSet().getString(6));
                modelCliente.setEndereco_cliente(this.getResultSet().getString(7));
                modelCliente.setTelefone_cliente(this.getResultSet().getString(8));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelCliente;
    }
     public ModelCliente getClienteDAO(String pNomeCliente){
        ModelCliente modelCliente = new ModelCliente();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id_cliente,"
                    + "nome_cliente,"
                    + "bairro_cliente,"
                    + "cidade_cliente,"
                    + "uf_cliente,"
                    + "cep_cliente,"
                    + "endereco_cliente,"
                    + "telefone_cliente"
                 + " FROM"
                     + " tabela_cliente"
                 + " WHERE"
                     + " nome_cliente = '" + pNomeCliente + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCliente.setId_cliente(this.getResultSet().getInt(1));
                modelCliente.setNome_cliente(this.getResultSet().getString(2));
                modelCliente.setBairro_cliente(this.getResultSet().getString(3));
                modelCliente.setCidade_cliente(this.getResultSet().getString(4));
                modelCliente.setUf_cliente(this.getResultSet().getString(5));
                modelCliente.setCep_cliente(this.getResultSet().getString(6));
                modelCliente.setEndereco_cliente(this.getResultSet().getString(7));
                modelCliente.setTelefone_cliente(this.getResultSet().getString(8));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelCliente;
    }

    /**
    * recupera uma lista de Cliente
        * return ArrayList
    */
    public ArrayList<ModelCliente> getListaClienteDAO(){
        ArrayList<ModelCliente> listamodelCliente = new ArrayList<>();
        ModelCliente modelCliente = new ModelCliente();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id_cliente,"
                    + "nome_cliente,"
                    + "bairro_cliente,"
                    + "cidade_cliente,"
                    + "uf_cliente,"
                    + "cep_cliente,"
                    + "endereco_cliente,"
                    + "telefone_cliente"
                 + " FROM"
                     + " tabela_cliente"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCliente = new ModelCliente();
                modelCliente.setId_cliente(this.getResultSet().getInt(1));
                modelCliente.setNome_cliente(this.getResultSet().getString(2));
                modelCliente.setBairro_cliente(this.getResultSet().getString(3));
                modelCliente.setCidade_cliente(this.getResultSet().getString(4));
                modelCliente.setUf_cliente(this.getResultSet().getString(5));
                modelCliente.setCep_cliente(this.getResultSet().getString(6));
                modelCliente.setEndereco_cliente(this.getResultSet().getString(7));
                modelCliente.setTelefone_cliente(this.getResultSet().getString(8));
                listamodelCliente.add(modelCliente);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelCliente;
    }

    /**
    * atualiza Cliente
    * @param pModelCliente
    * return boolean
    */
    public boolean atualizarClienteDAO(ModelCliente pModelCliente){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tabela_cliente SET "
                    + "id_cliente = '" + pModelCliente.getId_cliente() + "',"
                    + "nome_cliente = '" + pModelCliente.getNome_cliente() + "',"
                    + "bairro_cliente = '" + pModelCliente.getBairro_cliente() + "',"
                    + "cidade_cliente = '" + pModelCliente.getCidade_cliente() + "',"
                    + "uf_cliente = '" + pModelCliente.getUf_cliente() + "',"
                    + "cep_cliente = '" + pModelCliente.getCep_cliente() + "',"
                    + "endereco_cliente = '" + pModelCliente.getEndereco_cliente() + "',"
                    + "telefone_cliente = '" + pModelCliente.getTelefone_cliente() + "'"
                + " WHERE "
                    + "id_cliente = '" + pModelCliente.getId_cliente() + "'"
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
    * exclui Cliente
    * @param pId_cliente
    * return boolean
    */
    public boolean excluirClienteDAO(int pId_cliente){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tabela_cliente "
                + " WHERE "
                    + "id_cliente = '" + pId_cliente + "'"
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