package model;

public class Medico {
	private int crm;
	private String nome;
	private String cpf;
	private int especialidade;
	
	
	
	public Medico(int crm, String nome, String cpf, int especialidade) {
		this.crm = crm;
		this.nome = nome;
		this.cpf = cpf;
		this.especialidade = especialidade;
	}
	public int getCrm() {
		return crm;
	}
	public void setCrm(int crm) {
		this.crm = crm;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(int especialidade) {
		this.especialidade = especialidade;
	}
	
	
}
