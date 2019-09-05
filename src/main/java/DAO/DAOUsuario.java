package DAO;

import Model.ModelUsuario;
import Connection.ConexaoPostgre;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author v1ct0r_f4r145
 */
public class DAOUsuario extends ConexaoPostgre {

    /**
     * grava Usuario
     *
     * @param pModelUsuario return int
     */
    public int salvarUsuarioDAO(ModelUsuario pModelUsuario) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO tabela_usuario ("
                    + "nome_usuario,"
                    + "login_usuario,"
                    + "senha_usuario"
                    + ") VALUES ("
                    + "'" + pModelUsuario.getNome_usuario() + "',"
                    + "'" + pModelUsuario.getLogin_usuario() + "',"
                    + "'" + pModelUsuario.getSenha_usuario() + "'"
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
     * recupera Usuario
     *
     * @param pId_usuario return ModelUsuario
     */
    public ModelUsuario getUsuarioDAO(int pId_usuario) {
        ModelUsuario modelUsuario = new ModelUsuario();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "id_usuario,"
                    + "nome_usuario,"
                    + "login_usuario,"
                    + "senha_usuario"
                    + " FROM"
                    + " tabela_usuario"
                    + " WHERE"
                    + " id_usuario = '" + pId_usuario + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelUsuario.setId_usuario(this.getResultSet().getInt(1));
                modelUsuario.setNome_usuario(this.getResultSet().getString(2));
                modelUsuario.setLogin_usuario(this.getResultSet().getString(3));
                modelUsuario.setSenha_usuario(this.getResultSet().getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelUsuario;
    }

    /**
     * recupera uma lista de Usuario return ArrayList
     */
    public ArrayList<ModelUsuario> getListaUsuarioDAO() {
        ArrayList<ModelUsuario> listamodelUsuario = new ArrayList();
        ModelUsuario modelUsuario = new ModelUsuario();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "id_usuario,"
                    + "nome_usuario,"
                    + "login_usuario,"
                    + "senha_usuario"
                    + " FROM"
                    + " tabela_usuario"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelUsuario = new ModelUsuario();
                modelUsuario.setId_usuario(this.getResultSet().getInt(1));
                modelUsuario.setNome_usuario(this.getResultSet().getString(2));
                modelUsuario.setLogin_usuario(this.getResultSet().getString(3));
                modelUsuario.setSenha_usuario(this.getResultSet().getString(4));
                listamodelUsuario.add(modelUsuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelUsuario;
    }

    /**
     * atualiza Usuario
     *
     * @param pModelUsuario return boolean
     */
    public boolean atualizarUsuarioDAO(ModelUsuario pModelUsuario) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tabela_usuario SET "
                    + "id_usuario = '" + pModelUsuario.getId_usuario() + "',"
                    + "nome_usuario = '" + pModelUsuario.getNome_usuario() + "',"
                    + "login_usuario = '" + pModelUsuario.getLogin_usuario() + "',"
                    + "senha_usuario = '" + pModelUsuario.getSenha_usuario() + "'"
                    + " WHERE "
                    + "id_usuario = '" + pModelUsuario.getId_usuario() + "'"
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
     * exclui Usuario
     *
     * @param pId_usuario return boolean
     */
    public boolean excluirUsuarioDAO(int pId_usuario) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tabela_usuario "
                    + " WHERE "
                    + "id_usuario = '" + pId_usuario + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

     public boolean getValidarUsuarioDAO(ModelUsuario modelUsuario) {
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "id_usuario,"
                    + "nome_usuario,"
                    + "login_usuario,"
                    + "senha_usuario"
                    + " FROM"
                    + " tabela_usuario"
                    + " WHERE"
                    + " login_usuario = '" + modelUsuario.getLogin_usuario() + "' AND senha_usuario = '" + modelUsuario.getSenha_usuario() + "'"
                    + ";"
            );
            if (getResultSet().next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
}
