package Model;
/**
*
* @author v1ct0r_f4r145
*/
public class ModelVendasProdutos {

    private int id_venda_produto;
    private int fk_venda;
    private int fk_produto;
    private double venda_produto_valor;
    private int venda_produto_qtd;

    /**
    * Construtor
    */
    public ModelVendasProdutos(){}

    /**
    * seta o valor de id_venda_produto
    * @param pId_venda_produto
    */
    public void setId_venda_produto(int pId_venda_produto){
        this.id_venda_produto = pId_venda_produto;
    }
    /**
    * return pk_id_venda_produto
    */
    public int getId_venda_produto(){
        return this.id_venda_produto;
    }

    /**
    * seta o valor de fk_venda
    * @param pFk_venda
    */
    public void setFk_venda(int pFk_venda){
        this.fk_venda = pFk_venda;
    }
    /**
    * return fk_venda
    */
    public int getFk_venda(){
        return this.fk_venda;
    }

    /**
    * seta o valor de fk_produto
    * @param pFk_produto
    */
    public void setFk_produto(int pFk_produto){
        this.fk_produto = pFk_produto;
    }
    /**
    * return fk_produto
    */
    public int getFk_produto(){
        return this.fk_produto;
    }

    /**
    * seta o valor de venda_produto_valor
    * @param pVenda_produto_valor
    */
    public void setVenda_produto_valor(double pVenda_produto_valor){
        this.venda_produto_valor = pVenda_produto_valor;
    }
    /**
    * return venda_produto_valor
    */
    public double getVenda_produto_valor(){
        return this.venda_produto_valor;
    }

    /**
    * seta o valor de venda_produto_qtd
    * @param pVenda_produto_qtd
    */
    public void setVenda_produto_qtd(int pVenda_produto_qtd){
        this.venda_produto_qtd = pVenda_produto_qtd;
    }
    /**
    * return venda_produto_qtd
    */
    public int getVenda_produto_qtd(){
        return this.venda_produto_qtd;
    }

    @Override
    public String toString(){
        return "ModelVendasProdutos {" + "::id_venda_produto = " + this.id_venda_produto + "::fk_venda = " + this.fk_venda + "::fk_produto = " + this.fk_produto + "::venda_produto_valor = " + this.venda_produto_valor + "::venda_produto_qtd = " + this.venda_produto_qtd +  "}";
    }
}