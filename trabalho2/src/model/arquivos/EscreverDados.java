package model.arquivos;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class EscreverDados {

	protected BufferedWriter bw;

	public void EscreverArquivo(String conteudo, String caminho) {

		try {

			bw = new BufferedWriter(new FileWriter(caminho, true));

			bw.newLine();

			bw.write(conteudo);

			bw.close();
		} catch (Exception e) {
		}

	}
}
