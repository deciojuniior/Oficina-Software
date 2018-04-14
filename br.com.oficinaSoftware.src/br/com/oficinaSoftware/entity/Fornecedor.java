package br.com.oficinaSoftware.entity;

public class Fornecedor {
    private String _id;
    private String nomeFornecedor;
    private String cnpjFornecedor;
    private String enderecoFornecedor;
    private String emailFornecedor;
    private String _idUsuario;
    private String telefoneFornecedor;

    public String get_id() { return _id; }
    public void set_id(String _id) { this._id = _id; }
    public String getNomeFornecedor() { return nomeFornecedor; }
    public void setNomeFornecedor(String nomeFornecedor) { this.nomeFornecedor = nomeFornecedor; }
    public String getCnpjFornecedor() { return cnpjFornecedor; }
    public void setCnpjFornecedor(String cnpjFornecedor) { this.cnpjFornecedor = cnpjFornecedor; }
    public String getEnderecoFornecedor() { return enderecoFornecedor; }
    public void setEnderecoFornecedor(String enderecoFornecedor) { this.enderecoFornecedor = enderecoFornecedor; }
    public String getEmailFornecedor() { return emailFornecedor; }
    public void setEmailFornecedor(String emailFornecedor) { this.emailFornecedor = emailFornecedor; }
    public String getTelefoneFornecedor() { return telefoneFornecedor;}
    public void setTelefoneFornecedor(String telefoneFornecedor) { this.telefoneFornecedor = telefoneFornecedor; }
    public String get_idUsuario(String idUserF) { return _idUsuario; }
    public void set_idUsuario(String _idUsuario) { this._idUsuario = _idUsuario; }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "_id=" + _id +
                ", nomeFornecedor='" + nomeFornecedor + '\'' +
                ", cnpjFornecedor=" + cnpjFornecedor +
                ", enderecoFornecedor='" + enderecoFornecedor + '\'' +
                ", emailFornecedor='" + emailFornecedor + '\'' +
                ", _idUsuario=" + _idUsuario +
                ", telefoneFornecedor='" + telefoneFornecedor + '\'' +
                '}';
    }
}

