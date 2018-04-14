package br.com.oficinaSoftware.entity;

public class Cidade {
	private String _id;
	private String nome;
	private String idEstado;
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}
	@Override
	public String toString() {
		return "Cidade [_id=" + _id + ", nome=" + nome + ", idEstado=" + idEstado + "]";
	}
	
	
	
	
	
}

