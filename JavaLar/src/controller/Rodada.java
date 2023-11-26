package controller;

import javax.swing.JOptionPane;

import controller.astros.Bug;
import controller.astros.Dev;

public class Rodada {

	protected EstrelaJava java;
	protected String[] dadosDaRodada;
	protected int quantBugs = 0;
	protected int quantDevs = 0;

	public Rodada(EstrelaJava j, String[] dados) {
		java = j;
		dadosDaRodada = dados;

		try {
			quantBugs = Integer.valueOf(dadosDaRodada[8]);
			quantDevs = Integer.valueOf(dadosDaRodada[9]);

			adicionarAstros();
			java.movimentarPlanetas(dadosDaRodada);
		} catch (Exception e) {

		}

		java.verificarColisoes();
		if (java.verificarSeTodosExplodiram()) {
			JOptionPane.showConfirmDialog(null, "Todos os planetas explodiram, O sistema será reiniciado.",
					null, JOptionPane.WARNING_MESSAGE);
		}
	}

	public void adicionarAstros() {

		for (int i = 0; i < quantBugs; i++) {
			if (java.astros.size() < 225) {
				Bug b = new Bug();
				for (int j = 0; j < java.astros.size(); j++) {
					if (b.getPosicaoX() == java.astros.get(j).getPosicaoX()
							&& b.getPosicaoY() == java.astros.get(j).getPosicaoY()) {
						b = new Bug();
						if (java.astros.size() < 225)
							j = 0;
						else
							j = java.astros.size();
					}
				}
				java.astros.add(b);
			}
		}

		for (int i = 0; i < quantDevs; i++) {
			if (java.astros.size() < 225) {
				Dev d = new Dev();
				for (int j = 0; j < java.astros.size(); j++) {
					if (d.getPosicaoX() == java.astros.get(j).getPosicaoX()
							&& d.getPosicaoY() == java.astros.get(j).getPosicaoY()) {
						d = new Dev();
						if (java.astros.size() < 225)
							j = 0;
						else
							j = java.astros.size();
					}
				}
				java.astros.add(d);
			}
		}
	}
}
