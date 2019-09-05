package Model;
/**
*
* @author v1ct0r_f4r145
*/

import java.sql.Date;

public class ModelVendas {

    private int id_venda;
    private int fk_cliente;
    private Date data_venda;
    private double valor_liquido_venda;
    private double valor_bruto_venda;
    private double desconto_venda;

    /**
    * Construtor
    */
    public ModelVendas(){}

    /**
    * seta o valor de id_venda
    * @param pId_venda
    */
    public void setId_venda(int pId_venda){
        this.id_venda = pId_venda;
    }
    /**
    * return pk_id_venda
    */
    public int getId_venda(){
        return this.id_venda;
    }

    /**
    * seta o valor de fk_cliente
    * @param pFk_cliente
    */
    public void setFk_cliente(int pFk_cliente){
        this.fk_cliente = pFk_cliente;
    }
    /**
    * return fk_cliente
    */
    public int getFk_cliente(){
        return this.fk_cliente;
    }

    /**
    * seta o valor de data_venda
    * @param pData_venda
    */
    public void setData_venda(Date pData_venda){
        this.data_venda = pData_venda;
    }
    /**
    * return data_venda
    */
    public Date getData_venda(){
        return this.data_venda;
    }

    /**
    * seta o valor de valor_liquido_venda
    * @param pValor_liquido_venda
    */
    public void setValor_liquido_venda(double pValor_liquido_venda){
        this.valor_liquido_venda = pValor_liquido_venda;
    }
    /**
    * return valor_liquido_venda
    */
    public double getValor_liquido_venda(){
        return this.valor_liquido_venda;
    }

    /**
    * seta o valor de valor_bruto_venda
    * @param pValor_bruto_venda
    */
    public void setValor_bruto_venda(double pValor_bruto_venda){
        this.valor_bruto_venda = pValor_bruto_venda;
    }
    /**
    * return valor_bruto_venda
    */
    public double getValor_bruto_venda(){
        return this.valor_bruto_venda;
    }

    /**
    * seta o valor de desconto_venda
    * @param pDesconto_venda
    */
    public void setDesconto_venda(double pDesconto_venda){
        this.desconto_venda = pDesconto_venda;
    }
    /**
    * return desconto_venda
    */
    public double getDesconto_venda(){
        return this.desconto_venda;
    }

    @Override
    public String toString(){
        return "ModelVendas {" + "::id_venda = " + this.id_venda + "::fk_cliente = " + this.fk_cliente + "::data_venda = " + this.data_venda + "::valor_liquido_venda = " + this.valor_liquido_venda + "::valor_bruto_venda = " + this.valor_bruto_venda + "::desconto_venda = " + this.desconto_venda +  "}";
    }
}