
package Model;

/**
 *
 * @author v1ct0r_f4r145
 */
public class ModelProduto {

    public ModelProduto(int idProduto, String nomeProduto, double valorProduto, int estoqueProduto) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.estoqueProduto = estoqueProduto;
    }
    
    public ModelProduto(){
    
    }
    
    private int idProduto;
    private String nomeProduto;
    private double valorProduto;
    private int estoqueProduto;

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public int getEstoqueProduto() {
        return estoqueProduto;
    }

    public void setEstoqueProduto(int estoqueProduto) {
        this.estoqueProduto = estoqueProduto;
    }

}
