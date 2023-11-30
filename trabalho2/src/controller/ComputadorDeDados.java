package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComputadorDeDados {
		
	protected ArrayList<Relatorio> dados;
	
	public String gerarArquivoSaida() {
		String saida = "";
		String alunoMaisFrequente = pegarAlunoViciadoNoJavaLar();
		int matriculaDoAluno = pegarMatriculaDoAlunoFrequente(alunoMaisFrequente);
		String planetaMaisMorre = pegarPlanetaQueMaisMorre();
		String planetaMaisVida = pegarPlanetaComMaisVida();
		String quadranteMaisBugs = pegarQuadranteMaisBugs();
		String quadranteMaisDevs = pegarQuadranteMaisDevs();
		int instantes = pegarQuantidadeInstantesTotais();
		String velocidadeMedia = pegarVelocidadeMedia();
		int bugsTotais = pegarQuantidadeTotalBugs();
		int devsTotais = pegarQuantidadeTotalDevs();
		int horasTotais = pegarQuantidadeTotalHoras();
		int anosTotais = pegarQuantidadeTotalAnos();
		
		saida += alunoMaisFrequente + ", " + matriculaDoAluno + ", " + planetaMaisMorre + ", " + planetaMaisVida +
				", " + quadranteMaisBugs + ", " + quadranteMaisDevs + ", " + instantes+ ", " + velocidadeMedia + 
				", " + bugsTotais + ", " + devsTotais + ", " + horasTotais + ", " + anosTotais + ".";
		
		return saida;
	}
	
	private String pegarAlunoViciadoNoJavaLar() {
		
		Map<String, Integer> frequenciaMap = new HashMap<>();
		
		for (int i = 0; i < dados.size(); i++) {
			frequenciaMap.put(dados.get(i).getNome(), frequenciaMap.getOrDefault(dados.get(i).getNome(), 0) + 1);
		}
		
		String alunoMaisFrequente = null;
		int contadorMaisFrequente = 0;
		
		for (Map.Entry<String, Integer> entry : frequenciaMap.entrySet()) {
            if (entry.getValue() > contadorMaisFrequente) {
                alunoMaisFrequente = entry.getKey();
                contadorMaisFrequente = entry.getValue();
            }
        }
		
		return alunoMaisFrequente;
	}
	
	private int pegarMatriculaDoAlunoFrequente(String aluno) {
		for (int i = 0; i < dados.size(); i++) {
			if(dados.get(i).getNome() == aluno)
				return dados.get(i).getMatricula();
		}
		return 0;
	}
	
	private String pegarPlanetaQueMaisMorre() {
		int somatorioPython = 0;
		int somatorioJavaScript = 0;
		int somatorioRuby = 0;
		int somatorioPhp = 0;
		int somatorioCsharp = 0;
		int somatorioCplus = 0;
		int somatorioC = 0;
		
		for (int i = 0; i < dados.size(); i++) {
			somatorioPython += dados.get(i).getVeloPlanetas()[0];
			somatorioJavaScript += dados.get(i).getVeloPlanetas()[1];
			somatorioRuby += dados.get(i).getVeloPlanetas()[2];
			somatorioPhp += dados.get(i).getVeloPlanetas()[3];
			somatorioCsharp += dados.get(i).getVeloPlanetas()[4];
			somatorioCplus += dados.get(i).getVeloPlanetas()[5];
			somatorioC += dados.get(i).getVeloPlanetas()[6];			
		}
		
		int[] vetorSomatorios = {somatorioPython,somatorioJavaScript,somatorioRuby,somatorioPhp,somatorioCsharp,somatorioCplus,somatorioC};
		int menor = 999999999;
		for (int i = 0; i < vetorSomatorios.length; i++) {
			if(vetorSomatorios[i] < menor)
				menor = vetorSomatorios[i];
		}
		
		int aux = 0;
		for (int i = 0; i < vetorSomatorios.length; i++) {
			if(menor == vetorSomatorios[i])
				aux = i;
		}
		
		String planeta = null;
		switch (aux) {
		case 0:
			planeta = "Python";
			break;
		case 1:
			planeta = "JavaScript";
			break;
		case 2:
			planeta = "Ruby";
			break;
		case 3:
			planeta = "PHP";
			break;
		case 4:
			planeta = "C#";
			break;
		case 5:
			planeta = "C++";
			break;
		case 6:
			planeta = "C";
				break;
		default:
			break;
		}
		
		return planeta;
	}
	
	private String pegarPlanetaComMaisVida() {
		int somatorioPython = 0;
		int somatorioJavaScript = 0;
		int somatorioRuby = 0;
		int somatorioPhp = 0;
		int somatorioCsharp = 0;
		int somatorioCplus = 0;
		int somatorioC = 0;
		
		for (int i = 0; i < dados.size(); i++) {
			somatorioPython += dados.get(i).getVeloPlanetas()[0];
			somatorioJavaScript += dados.get(i).getVeloPlanetas()[1];
			somatorioRuby += dados.get(i).getVeloPlanetas()[2];
			somatorioPhp += dados.get(i).getVeloPlanetas()[3];
			somatorioCsharp += dados.get(i).getVeloPlanetas()[4];
			somatorioCplus += dados.get(i).getVeloPlanetas()[5];
			somatorioC += dados.get(i).getVeloPlanetas()[6];			
		}
		
		int[] vetorSomatorios = {somatorioPython,somatorioJavaScript,somatorioRuby,somatorioPhp,somatorioCsharp,somatorioCplus,somatorioC};
		int maior = 0;
		for (int i = 0; i < vetorSomatorios.length; i++) {
			if(vetorSomatorios[i] > maior)
				maior = vetorSomatorios[i];
		}
		
		int aux = 0;
		for (int i = 0; i < vetorSomatorios.length; i++) {
			if(maior == vetorSomatorios[i])
				aux = i;
		}
		
		String planeta = null;
		switch (aux) {
		case 0:
			planeta = "Python";
			break;
		case 1:
			planeta = "JavaScript";
			break;
		case 2:
			planeta = "Ruby";
			break;
		case 3:
			planeta = "PHP";
			break;
		case 4:
			planeta = "C#";
			break;
		case 5:
			planeta = "C++";
			break;
		case 6:
			planeta = "C";
				break;
		default:
			break;
		}
		
		return planeta;
	}
	
	private String pegarQuadranteMaisBugs() {
		int somatorioq1 = 0;
		int somatorioq2 = 0;
		int somatorioq3 = 0;
		int somatorioq4 = 0;
		
		for (int i = 0; i < dados.size(); i++) {
			somatorioq1 += dados.get(i).getBugsQuadrantes()[0];
			somatorioq2 += dados.get(i).getBugsQuadrantes()[1];
			somatorioq3 += dados.get(i).getBugsQuadrantes()[2];
			somatorioq4 += dados.get(i).getBugsQuadrantes()[3];
						
		}
		
		int[] vetorSomatorios = {somatorioq1,somatorioq2,somatorioq3,somatorioq4};
		int maior = 0;
		for (int i = 0; i < vetorSomatorios.length; i++) {
			if(vetorSomatorios[i] > maior)
				maior = vetorSomatorios[i];
		}
		
		int aux = 0;
		for (int i = 0; i < vetorSomatorios.length; i++) {
			if(maior == vetorSomatorios[i])
				aux = i;
		}
		
		String quadrante = null;
		switch (aux) {
		case 0:
			quadrante = "1";
			break;
		case 1:
			quadrante = "2";
			break;
		case 2:
			quadrante = "3";
			break;
		case 3:
			quadrante = "4";
			break;
		default:
			break;
		}
		
		return quadrante;
	}
	
	private String pegarQuadranteMaisDevs() {
		int somatorioq1 = 0;
		int somatorioq2 = 0;
		int somatorioq3 = 0;
		int somatorioq4 = 0;
		
		for (int i = 0; i < dados.size(); i++) {
			somatorioq1 += dados.get(i).getDevsQuadrantes()[0];
			somatorioq2 += dados.get(i).getDevsQuadrantes()[1];
			somatorioq3 += dados.get(i).getDevsQuadrantes()[2];
			somatorioq4 += dados.get(i).getDevsQuadrantes()[3];
						
		}
		
		int[] vetorSomatorios = {somatorioq1,somatorioq2,somatorioq3,somatorioq4};
		int maior = 0;
		for (int i = 0; i < vetorSomatorios.length; i++) {
			if(vetorSomatorios[i] > maior)
				maior = vetorSomatorios[i];
		}
		
		int aux = 0;
		for (int i = 0; i < vetorSomatorios.length; i++) {
			if(maior == vetorSomatorios[i])
				aux = i;
		}
		
		String quadrante = null;
		switch (aux) {
		case 0:
			quadrante = "1";
			break;
		case 1:
			quadrante = "2";
			break;
		case 2:
			quadrante = "3";
			break;
		case 3:
			quadrante = "4";
			break;
		default:
			break;
		}
		
		return quadrante;
	}
	
	private int pegarQuantidadeInstantesTotais() {
		int somatorio = 0;
		
		Pattern pattern = Pattern.compile("\\d+");
		
		for (int i = 0; i < dados.size(); i++) {
			Matcher matcher = pattern.matcher(dados.get(i).getNome_arquivo());
			
			while (matcher.find()) {
				somatorio += Integer.parseInt(matcher.group());
			}
		}
		
		return somatorio;
	}
	
	private String pegarVelocidadeMedia() {
		
		int somatorio = 0;
		float media = 0f;
		String mediaPython;
		String mediaJava;
		String mediaRuby;
		String mediaPhp;
		String mediaCsharp;
		String mediaCplus;
		String mediaC;
		
		for (int i = 0; i < dados.size(); i++) {
			somatorio += dados.get(i).getVeloPlanetas()[0];			
		}
		media = (somatorio/ ((float)dados.size()));
		mediaPython = String.format("%.2f", media);
		
		somatorio = 0;
		for (int i = 0; i < dados.size(); i++) {
			somatorio += dados.get(i).getVeloPlanetas()[1];			
		}
		media = (somatorio/ ((float)dados.size()));
		mediaJava = String.format("%.2f", media);
		
		somatorio = 0;
		for (int i = 0; i < dados.size(); i++) {
			somatorio += dados.get(i).getVeloPlanetas()[2];			
		}
		media = (somatorio/ ((float)dados.size()));
		mediaRuby = String.format("%.2f", media);
		
		somatorio = 0;
		for (int i = 0; i < dados.size(); i++) {
			somatorio += dados.get(i).getVeloPlanetas()[3];			
		}
		media = (somatorio/ ((float)dados.size()));
		mediaPhp = String.format("%.2f", media);
		
		somatorio = 0;
		for (int i = 0; i < dados.size(); i++) {
			somatorio += dados.get(i).getVeloPlanetas()[4];			
		}
		media = (somatorio/ ((float)dados.size()));
		mediaCsharp = String.format("%.2f", media);
		
		somatorio = 0;
		for (int i = 0; i < dados.size(); i++) {
			somatorio += dados.get(i).getVeloPlanetas()[5];			
		}
		media = (somatorio/ ((float)dados.size()));
		mediaCplus = String.format("%.2f", media);
		
		somatorio = 0;
		for (int i = 0; i < dados.size(); i++) {
			somatorio += dados.get(i).getVeloPlanetas()[6];			
		}
		media = (somatorio/ ((float)dados.size()));
		mediaC = String.format("%.2f", media);
		
		return "Python: "+mediaPython+", JavaScript: "+mediaJava+", Ruby: "+mediaRuby+", PHP: "+
		mediaPhp+", C#: "+mediaCsharp+", C++: "+mediaCplus+", C: "+mediaC;
	}
	
	private int pegarQuantidadeTotalBugs() {
		int somatorio = 0;
		
		for (int i = 0; i < dados.size(); i++) {
			for (int j = 0; j < 4; j++) {
				somatorio += dados.get(i).getBugsQuadrantes()[j];
			}
		}
		
		return somatorio;
	}
	
	private int pegarQuantidadeTotalDevs() {
		int somatorio = 0;
		
		for (int i = 0; i < dados.size(); i++) {
			for (int j = 0; j < 4; j++) {
				somatorio += dados.get(i).getDevsQuadrantes()[j];
			}
		}
		
		return somatorio;
	}
	
	private int pegarQuantidadeTotalHoras() {
		int somatorio = 0;
		
		for (int i = 0; i < dados.size(); i++) {
			for (int j = 0; j < 4; j++) {
				somatorio += dados.get(i).getDiasPlanetas()[j];
			}
		}
		
		return (somatorio);
	}
	
	private int pegarQuantidadeTotalAnos() {
		int somatorio = 0;
		
		for (int i = 0; i < dados.size(); i++) {
			for (int j = 0; j < 4; j++) {
				somatorio += dados.get(i).getAnosPlanetas()[j];
			}
		}
		
		return somatorio;
	}
	
	public ArrayList<Relatorio> getDados() {
		return dados;
	}

	public void setDados(ArrayList<Relatorio> dados) {
		this.dados = dados;
	}
}
