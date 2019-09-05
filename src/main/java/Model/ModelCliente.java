package Model;
/**
*
* @author v1ct0r_f4r145
*/
public class ModelCliente {

    private int id_cliente;
    private String nome_cliente;
    private String bairro_cliente;
    private String cidade_cliente;
    private String uf_cliente;
    private String cep_cliente;
    private String endereco_cliente;
    private String telefone_cliente;

    /**
    * Construtor
    */
    public ModelCliente(){}

    /**
    * seta o valor de id_cliente
    * @param pId_cliente
    */
    public void setId_cliente(int pId_cliente){
        this.id_cliente = pId_cliente;
    }
    /**
    * return pk_id_cliente
    */
    public int getId_cliente(){
        return this.id_cliente;
    }

    /**
    * seta o valor de nome_cliente
    * @param pNome_cliente
    */
    public void setNome_cliente(String pNome_cliente){
        this.nome_cliente = pNome_cliente;
    }
    /**
    * return nome_cliente
    */
    public String getNome_cliente(){
        return this.nome_cliente;
    }

    /**
    * seta o valor de bairro_cliente
    * @param pBairro_cliente
    */
    public void setBairro_cliente(String pBairro_cliente){
        this.bairro_cliente = pBairro_cliente;
    }
    /**
    * return bairro_cliente
    */
    public String getBairro_cliente(){
        return this.bairro_cliente;
    }

    /**
    * seta o valor de cidade_cliente
    * @param pCidade_cliente
    */
    public void setCidade_cliente(String pCidade_cliente){
        this.cidade_cliente = pCidade_cliente;
    }
    /**
    * return cidade_cliente
    */
    public String getCidade_cliente(){
        return this.cidade_cliente;
    }

    /**
    * seta o valor de uf_cliente
    * @param pUf_cliente
    */
    public void setUf_cliente(String pUf_cliente){
        this.uf_cliente = pUf_cliente;
    }
    /**
    * return uf_cliente
    */
    public String getUf_cliente(){
        return this.uf_cliente;
    }

    /**
    * seta o valor de cep_cliente
    * @param pCep_cliente
    */
    public void setCep_cliente(String pCep_cliente){
        this.cep_cliente = pCep_cliente;
    }
    /**
    * return cep_cliente
    */
    public String getCep_cliente(){
        return this.cep_cliente;
    }

    /**
    * seta o valor de endereco_cliente
    * @param pEndereco_cliente
    */
    public void setEndereco_cliente(String pEndereco_cliente){
        this.endereco_cliente = pEndereco_cliente;
    }
    /**
    * return endereco_cliente
    */
    public String getEndereco_cliente(){
        return this.endereco_cliente;
    }

    /**
    * seta o valor de telefone_cliente
    * @param pTelefone_cliente
    */
    public void setTelefone_cliente(String pTelefone_cliente){
        this.telefone_cliente = pTelefone_cliente;
    }
    /**
    * return telefone_cliente
    */
    public String getTelefone_cliente(){
        return this.telefone_cliente;
    }

    @Override
    public String toString(){
        return "ModelCliente {" + "::id_cliente = " + this.id_cliente + "::nome_cliente = " + this.nome_cliente + "::bairro_cliente = " + this.bairro_cliente + "::cidade_cliente = " + this.cidade_cliente + "::uf_cliente = " + this.uf_cliente + "::cep_cliente = " + this.cep_cliente + "::endereco_cliente = " + this.endereco_cliente + "::telefone_cliente = " + this.telefone_cliente +  "}";
    }
}