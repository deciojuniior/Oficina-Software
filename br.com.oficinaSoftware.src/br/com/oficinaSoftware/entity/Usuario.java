package br.com.oficinaSoftware.entity;


public class Usuario {
	private String _id;
	private String nome;
	private String cpf;
	private String endereco;
	private String cargo;
	private String telefone;
	private String email;
	private String senha;
	private String cidade;
	private String pergunta;
	private String resposta;
	private String dataNasc;

	//=====Get e Set usuario
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) { this._id = _id; }
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCidade(){ return cidade; }
	public void setCidade(String cidade) { this.cidade = cidade; }
	public String getPergunta() { return pergunta; }
	public void setPergunta(String pergunta) { this.pergunta = pergunta; }
	public String getResposta() { return resposta; }
	public void setResposta(String resposta) { this.resposta = resposta; }
	public String getDataNasc() { return dataNasc; }
	public void setDataNasc(String dataNasc) { this.dataNasc = dataNasc; }

	@Override
	public String toString() {
		return "Usuario{" +
				 "_id='" + _id + '\'' +
				", nome='" + nome + '\'' +
				", endereco='" + endereco + '\'' +
				", cargo='" + cargo + '\'' +
				", telefone='" + telefone + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}