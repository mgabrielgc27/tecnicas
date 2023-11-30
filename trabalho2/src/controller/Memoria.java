package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.arquivos.EscreverDados;
import model.arquivos.LerDados;
import model.banco.RelatorioDAO;
import view.Janela;

public class Memoria {
	
	protected String nomeAluno = "Marcos Gabriel";
	protected int matriculaAluno = 554855;
	protected String diretorioArquivoEntrada = "dados/AE_10.csv";
	protected String diretorioArquivoSaida = "dados/relatorio.txt";
	
	protected EstrelaJava java;
	protected Janela view;
	protected LerDados ler;
	protected EscreverDados escrever;
	protected ComputadorDeDados computador;

	protected ArrayList<Rodada> rodadas;
	protected ArrayList<String[]> dadosDasRodadas;
	protected int contadorArquivoEntrada = 0;
	protected int contadorInstante = 0;
	protected int instantesTotais = 0;

	public Memoria() {
		
		java = new EstrelaJava();
		rodadas = new ArrayList<Rodada>();
		ler = new LerDados();
		escrever = new EscreverDados();
		computador = new ComputadorDeDados();
		dadosDasRodadas = ler.lerDados(diretorioArquivoEntrada);
		view = new Janela(this);
	}
	
	public void processarInstante() {

		Rodada rodada = new Rodada(this, separarDados());
		adicionarRodada(rodada);
		view.getPlano().adicionarIconsPlanetas(java, java.planetas, java.astros);

	}
	
	public void trocarArquivoEntrada() {

		instantesTotais += contadorInstante;
		contadorArquivoEntrada++;
		String diretorio;

		switch (contadorArquivoEntrada) {
		case 1:
			diretorio = "dados/AE_50.csv";
			break;
		case 2:
			diretorio = "dados/AE_100.csv";
			break;
		case 3:
			diretorio = "dados/AE_500.csv";
			break;
		case 4:
			diretorio = "dados/AE_1000.csv";
			break;
		case 5:
			diretorio = "dados/AE_1500.csv";
			break;
		case 6:
			diretorio = "dados/AE_2000.csv";
			break;
		default:
			contadorArquivoEntrada = 0;
			diretorio = "dados/AE_10.csv";
			break;
		}

		diretorioArquivoEntrada = diretorio;
		dadosDasRodadas = ler.lerDados(diretorioArquivoEntrada);
		
		JOptionPane.showConfirmDialog(null, "Arquivo de entrada trocado com sucesso.",
				null, JOptionPane.WARNING_MESSAGE);
	}

	public void gravarRelatorio() {

		RelatorioDAO relatorioDao = new RelatorioDAO();
		relatorioDao.inserirDados(new Relatorio().gerarRelatorio(this));
		
		JOptionPane.showConfirmDialog(null, "Relatório gravado no banco de dados com sucesso.",
				null, JOptionPane.WARNING_MESSAGE);
	}

	public void lerDadosOutrosParticipantes() {
		RelatorioDAO relatorioDao = new RelatorioDAO();
		computador.setDados(relatorioDao.selecionarTodosDados());
		
		JOptionPane.showConfirmDialog(null, "Dados lidos com sucesso.",
				null, JOptionPane.WARNING_MESSAGE);
	}
	
	public void gravarArquivoSaida() {
		
		escrever.EscreverArquivo(computador.gerarArquivoSaida(), diretorioArquivoSaida);
		
		JOptionPane.showConfirmDialog(null, "Arquivo de saída gerado com sucesso.",
				null, JOptionPane.WARNING_MESSAGE);
	}
	
	public void reiniciarSistema() {
		
		view.dispose();
		new Memoria();
		
	}	

	private void adicionarRodada(Rodada r) {
		rodadas.add(r);
	}

	private String[] separarDados() {

		if ((contadorInstante + 1) >= dadosDasRodadas.size()) {
			JOptionPane.showConfirmDialog(null, "Todas as linhas do arquivo foram lidas. Troque o arquivo de entrada.",
					null, JOptionPane.WARNING_MESSAGE);
			return null;
		} else {
			contadorInstante++;
			return dadosDasRodadas.get(contadorInstante);
		}

	}

	public EstrelaJava getJava() {
		return java;
	}

	public void setView(Janela view) {
		this.view = view;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public int getMatriculaAluno() {
		return matriculaAluno;
	}

}
