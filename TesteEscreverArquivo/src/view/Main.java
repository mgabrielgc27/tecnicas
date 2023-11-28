package view;

import controller.Memoria;
import model.EscreverDados;

public class Main {

	public static void main(String[] args) {
		
		Memoria m = new Memoria();
		EscreverDados e = new EscreverDados();
		
		e.Escrever(m.retornaDados("Escrevendo dados :3"), m.getDiretorioArquivo());
	}

}
