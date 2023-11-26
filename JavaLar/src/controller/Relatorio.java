package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.astros.Astros;
import controller.planetas.PlanetasLinguagens;

public class Relatorio {
	
	protected int id;
	protected String nome = "Marcos Gabriel";
	protected int matricula = 554844;
	protected String nome_arquivo;
	protected int[] bugsPlanetas = new int[7];
	protected int[] devsPlanetas = new int[7];
	protected int[] veloPlanetas = new int[7];
	protected int[] diasPlanetas = new int[7];
	protected int[] anosPlanetas = new int[7];
	protected int[] bugsQuadrantes = new int[4];
	protected int[] devsQuadrantes = new int[4];
	
	public Relatorio() {
		
		
	}
	
	public Relatorio gerarRelatorio(Memoria memoria) {
		
		nome_arquivo = memoria.diretorioArquivoEntrada;		
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
	
	public Relatorio receberDados(ResultSet dados) {
		try {
			while (dados.next()) {
				id = dados.getInt("id");
				nome = dados.getString("nome");
				matricula = dados.getInt("matricula");
				nome_arquivo = dados.getString("nome_arquivo");
				bugsPlanetas[0] = dados.getInt("bug_python");
				bugsPlanetas[1] = dados.getInt("bug_javascript");
				bugsPlanetas[2] = dados.getInt("bug_ruby");
				bugsPlanetas[3] = dados.getInt("bug_php");
				bugsPlanetas[4] = dados.getInt("bug_csharp");
				bugsPlanetas[5] = dados.getInt("bug_cmais");
				bugsPlanetas[6] = dados.getInt("bug_c");
				devsPlanetas[0] = dados.getInt("dev_python");
				devsPlanetas[1] = dados.getInt("dev_javascript");
				devsPlanetas[2] = dados.getInt("dev_ruby");
				devsPlanetas[3] = dados.getInt("dev_php");
				devsPlanetas[4] = dados.getInt("dev_csharp");
				devsPlanetas[5] = dados.getInt("dev_cmais");
				devsPlanetas[6] = dados.getInt("dev_c");
				devsPlanetas[0] = dados.getInt("dev_python");
				devsPlanetas[1] = dados.getInt("dev_javascript");
				devsPlanetas[2] = dados.getInt("dev_ruby");
				devsPlanetas[3] = dados.getInt("dev_php");
				devsPlanetas[4] = dados.getInt("dev_csharp");
				devsPlanetas[5] = dados.getInt("dev_cmais");
				devsPlanetas[6] = dados.getInt("dev_c");
				veloPlanetas[0] = dados.getInt("v_python");
				veloPlanetas[1] = dados.getInt("v_javascript");
				veloPlanetas[2] = dados.getInt("v_ruby");
				veloPlanetas[3] = dados.getInt("v_php");
				veloPlanetas[4] = dados.getInt("v_csharp");
				veloPlanetas[5] = dados.getInt("v_cmais");
				veloPlanetas[6] = dados.getInt("v_c");
				diasPlanetas[0] = dados.getInt("d_python");
				diasPlanetas[1] = dados.getInt("d_javascript");
				diasPlanetas[2] = dados.getInt("d_ruby");
				diasPlanetas[3] = dados.getInt("d_php");
				diasPlanetas[4] = dados.getInt("d_csharp");
				diasPlanetas[5] = dados.getInt("d_cmais");
				diasPlanetas[6] = dados.getInt("d_c");
				anosPlanetas[0] = dados.getInt("a_python");
				anosPlanetas[1] = dados.getInt("a_javascript");
				anosPlanetas[2] = dados.getInt("a_ruby");
				anosPlanetas[3] = dados.getInt("a_php");
				anosPlanetas[4] = dados.getInt("a_csharp");
				anosPlanetas[5] = dados.getInt("a_cmais");
				anosPlanetas[6] = dados.getInt("a_c");
				bugsQuadrantes[0] = dados.getInt("bug_q1");
				bugsQuadrantes[1] = dados.getInt("bug_q2");
				bugsQuadrantes[2] = dados.getInt("bug_q3");
				bugsQuadrantes[3] = dados.getInt("bug_q4");
				devsQuadrantes[0] = dados.getInt("dev_q1");
				devsQuadrantes[1] = dados.getInt("dev_q2");
				devsQuadrantes[2] = dados.getInt("dev_q3");
				devsQuadrantes[3] = dados.getInt("dev_q4");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
		
		System.out.println("tamanho astros: "+astros.size());
		
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
