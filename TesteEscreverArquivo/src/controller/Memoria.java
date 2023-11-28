package controller;

public class Memoria {
	
	protected String dados;
	protected String diretorioArquivo = "dados/arquivo.txt";
	
	public String retornaDados(String dados) {
		this.dados = dados;
		return this.dados;
	}

	public String getDiretorioArquivo() {
		return diretorioArquivo;
	}
	
}
