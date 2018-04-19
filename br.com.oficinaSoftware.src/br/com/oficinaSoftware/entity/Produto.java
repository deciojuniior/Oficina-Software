package br.com.oficinaSoftware.entity;

public class Produto {
    private String _id;
    private String nomeProduto;
    private int qtdProduto;
    private float precoProduto;
    private float vendaProduto;
    private int idUsuario;
    private int idFornecedor;

    public String get_id() { return _id; }
    public void set_id(String _id) { this._id = _id; }
    public String getNomeProduto() { return nomeProduto; }
    public void setNomeProduto(String nomeProduto) { this.nomeProduto = nomeProduto; }
    public int getQtdProduto() { return qtdProduto; }
    public void setQtdProduto(int qtdProduto) { this.qtdProduto = qtdProduto; }
    public float getPrecoProduto() { return precoProduto; }
    public void setPrecoProduto(float precoProduto) { this.precoProduto = precoProduto; }
    public float getVendaProduto() { return vendaProduto; }
    public void setVendaProduto(float vendaProduto) { this.vendaProduto = vendaProduto; }
    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
    public int getIdFornecedor() { return idFornecedor; }
    public void setIdFornecedor(int idFornecedor) { this.idFornecedor = idFornecedor; }


    @Override
    public String toString() {
        return "Produto{" +
                "_id='" + _id + '\'' +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", qtdProduto=" + qtdProduto +
                ", precoProduto=" + precoProduto +
                ", vendaProduto=" + vendaProduto +
                ", idUsuario=" + idUsuario +
                ", idFornecedor=" + idFornecedor +
                '}';
    }
}
