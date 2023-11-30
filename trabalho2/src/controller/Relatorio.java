package controller;

import java.util.ArrayList;

import controller.astros.Astros;
import controller.planetas.PlanetasLinguagens;

public class Relatorio {
	
	protected int id;
	protected String nome;
	protected int matricula;
	protected String nome_arquivo;
	protected int[] bugsPlanetas = new int[7];
	protected int[] devsPlanetas = new int[7];
	protected int[] veloPlanetas = new int[7];
	protected int[] diasPlanetas = new int[7];
	protected int[] anosPlanetas = new int[7];
	protected int[] bugsQuadrantes = new int[4];
	protected int[] devsQuadrantes = new int[4];
	
	public Relatorio gerarRelatorio(Memoria memoria) {
		
		nome = memoria.getNomeAluno();
		matricula = memoria.getMatriculaAluno();
		nome_arquivo = memoria.diretorioArquivoEntrada.substring(6);		
		for (int i = 0; i < bugsPlanetas.length; i++) {
			bugsPlanetas[i] = memoria.getJava().getPlanetas().get(i).getQuantColisoesComBugs();
		}		
		for (int i = 0; i < devsPlanetas.length; i++) {
			devsPlanetas[i] = memoria.getJava().getPlanetas().get(i).getQuantColisoesComDevs();
		}
		veloPlanetas = calcularVelocidadeMedia(memoria.getJava().getPlanetas());
		diasPlanetas = calcularDiasPassados(memoria.getJava().getPlanetas());
		anosPlanetas = calcularAnosPassados(memoria.getJava().getPlanetas());
		bugsQuadrantes = BugsQuadrantes(memoria.getJava().getAstros());
		devsQuadrantes = DevsQuadrantes(memoria.getJava().getAstros());
		
		return this;
	}

	
	private int[] calcularVelocidadeMedia(ArrayList<PlanetasLinguagens> planetas) {
		int[] velocidades = new int[7];
		int i = 0;
		for (PlanetasLinguagens p : planetas) {
			try {
				velocidades[i] = (p.getDeslocamentoTotal()/p.getInstantesTotais());
			} catch (Exception e) {
			}
			
			i++;
		}
		return velocidades;
	}
	
	private int[] calcularDiasPassados(ArrayList<PlanetasLinguagens> planetas) {
		int[] dias = new int[7];
		int i = 0;
		for (PlanetasLinguagens p : planetas) {
			dias[i] = (int) (p.getHorasPassadas()/24);
			i++;
		}
		return dias;
	}
	
	private int[] calcularAnosPassados(ArrayList<PlanetasLinguagens> planetas) {
		int[] anos = new int[7];
		int i = 0;
		for (PlanetasLinguagens p : planetas) {
			anos[i] = (p.getDeslocamentoTotal()/(8*p.getDistancia()));
			i++;
		}
		return anos;
	}

	private int[] BugsQuadrantes(ArrayList<Astros> astros) {
		int bugsq1 = 0;
		int bugsq2 = 0;
		int bugsq3 = 0;
		int bugsq4 = 0;
		for (Astros a : astros) {
			if(a.getTipo() == "BUG") {
				if(a.getPosicaoX() < 7 && a.getPosicaoY() < 7)
					bugsq1++;
				if(a.getPosicaoX() < 7 && a.getPosicaoY() > 7)
					bugsq2++;
				if(a.getPosicaoX() > 7 && a.getPosicaoY() < 7)
					bugsq3++;
				if(a.getPosicaoX() > 7 && a.getPosicaoY() > 7)
					bugsq4++;				
			}
		}
		
		int[] bugs = { bugsq1, bugsq2, bugsq3, bugsq4};
		return bugs;
	}
	
	private int[] DevsQuadrantes(ArrayList<Astros> astros) {
		int devsq1 = 0;
		int devsq2 = 0;
		int devsq3 = 0;
		int devsq4 = 0;
		for (Astros a : astros) {
			if(a.getTipo() == "DEV") {
				if(a.getPosicaoX() < 7 && a.getPosicaoY() < 7)
					devsq1++;
				if(a.getPosicaoX() < 7 && a.getPosicaoY() > 7)
					devsq2++;
				if(a.getPosicaoX() > 7 && a.getPosicaoY() < 7)
					devsq3++;
				if(a.getPosicaoX() > 7 && a.getPosicaoY() > 7)
					devsq4++;
				
				
			}
		}
		
		int[] devs = { devsq1, devsq2, devsq3, devsq4};
		return devs;
	}
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public String getNome_arquivo() {
		return nome_arquivo;
	}

	public int[] getBugsPlanetas() {
		return bugsPlanetas;
	}

	public int[] getDevsPlanetas() {
		return devsPlanetas;
	}

	public int[] getVeloPlanetas() {
		return veloPlanetas;
	}

	public int[] getDiasPlanetas() {
		return diasPlanetas;
	}

	public int[] getAnosPlanetas() {
		return anosPlanetas;
	}

	public int[] getBugsQuadrantes() {
		return bugsQuadrantes;
	}

	public int[] getDevsQuadrantes() {
		return devsQuadrantes;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public void setNome_arquivo(String nome_arquivo) {
		this.nome_arquivo = nome_arquivo;
	}
	
	
}
