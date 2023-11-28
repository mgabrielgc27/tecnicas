package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscreverDados {
	
	protected BufferedWriter bw;
	
	public void Escrever(String dados, String diretorio) {
		
		try {
			bw = new BufferedWriter(new FileWriter(diretorio, true));
			
			bw.newLine();
			
			bw.write(dados);

			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
