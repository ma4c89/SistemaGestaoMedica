package model;

public class Paciente {
	private long id;
	private String nome;
	private int idade;
	private double peso;
	private double altura;
	private String cpf;
	
	public Paciente(String nome, int idade, double peso, double altura, String cpf) {
		this.id = id;
	    this.nome = nome;
	    this.idade = idade;
	    this.peso = peso;
	    this.altura = altura;
	    this.cpf = cpf;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		String paciente = nome + ", " + idade + ", " + peso + ", " + altura + ", " + cpf;
		return paciente;
	}
}
