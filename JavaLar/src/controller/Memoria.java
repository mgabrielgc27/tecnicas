package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.arquivos.LerDados;
import model.banco.RelatorioDAO;
import view.Janela;

public class Memoria {

	// Referências
	protected EstrelaJava java;
	protected Janela view;
	protected LerDados ler;

	protected ArrayList<Rodada> rodadas;
	protected ArrayList<String[]> dadosDasRodadas;
	protected ArrayList<Relatorio> relatorios;

	protected String diretorioArquivoEntrada = "dados/AE_10.csv";
	protected int contadorArquivoEntrada = 0;
	protected int contadorInstante = 0;
	protected int instantesTotais = 0;

	public Memoria() {

		java = new EstrelaJava();
		rodadas = new ArrayList<Rodada>();
		ler = new LerDados();
		dadosDasRodadas = ler.lerDados(diretorioArquivoEntrada);
	}

	public void processarInstante() {

		Rodada rodada = new Rodada(java, separarDados());
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
	}

	public void gravarRelatorio() {

		@SuppressWarnings("unused")
		RelatorioDAO relatorioDao = new RelatorioDAO();
		relatorioDao.inserirDados(new Relatorio().gerarRelatorio(this));
	}

	public void lerDadosOutrosParticipantes() {
		RelatorioDAO relatorioDao = new RelatorioDAO();
		relatorios = relatorioDao.selecionarTodosDados();
//		for (Relatorio r : relatorios) {
//			System.out.println(r.getId() + " - " + r.getNome() + " - " + r.getMatricula() + " - " + r.getNome_arquivo() + " - "
//					+ r.getBugsPlanetas()[0] + " - " + r.getBugsPlanetas()[1] + " - " + r.getBugsPlanetas()[2] + " - "
//					+ r.getBugsPlanetas()[3] + " - " + r.getBugsPlanetas()[4] + " - " + r.getBugsPlanetas()[5] + " - "
//					+ r.getBugsPlanetas()[6] + " - " + r.getDevsPlanetas()[0] + " - " + r.getDevsPlanetas()[1] + " - "
//					+ r.getDevsPlanetas()[2] + " - " + r.getDevsPlanetas()[3] + " - " + r.getDevsPlanetas()[4] + " - "
//					+ r.getDevsPlanetas()[5] + " - " + r.getDevsPlanetas()[6] + " - " + r.getVeloPlanetas()[0] + " - "
//					+ r.getVeloPlanetas()[1] + " - " + r.getVeloPlanetas()[2] + " - " + r.getVeloPlanetas()[3] + " - "
//					+ r.getVeloPlanetas()[4] + " - " + r.getVeloPlanetas()[5] + " - " + r.getVeloPlanetas()[6] + " - "
//					+ r.getDiasPlanetas()[0] + " - " + r.getDiasPlanetas()[1] + " - " + r.getDiasPlanetas()[2] + " - "
//					+ r.getDiasPlanetas()[3] + " - " + r.getDiasPlanetas()[4] + " - " + r.getDiasPlanetas()[5] + " - "
//					+ r.getDiasPlanetas()[6] + " - " + r.getAnosPlanetas()[0] + " - " + r.getAnosPlanetas()[1] + " - "
//					+ r.getAnosPlanetas()[2] + " - " + r.getAnosPlanetas()[3] + " - " + r.getAnosPlanetas()[4] + " - "
//					+ r.getAnosPlanetas()[5] + " - " + r.getAnosPlanetas()[6] + " - " + r.getBugsQuadrantes()[0] + " - "
//					+ r.getBugsQuadrantes()[1] + " - " + r.getBugsQuadrantes()[2] + " - " + r.getBugsQuadrantes()[3]
//					+ " - " + r.getDevsQuadrantes()[0] + " - " + r.getDevsQuadrantes()[1] + " - "
//					+ r.getDevsQuadrantes()[2] + " - " + r.getDevsQuadrantes()[3] + " - ");
//		}
		
		System.out.println("Quantidade de linhas: "+relatorios.size());
	}
	
	public void gravarArquivoSaida() {
		
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

}
