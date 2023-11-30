package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.astros.Astros;
import controller.astros.Bug;
import controller.astros.Dev;

public class Rodada {

	protected Memoria memoria;
	protected String[] dadosDaRodada;
	protected int quantBugs = 0;
	protected int quantDevs = 0;

	public Rodada(Memoria m, String[] dados) {
		memoria = m;
		dadosDaRodada = dados;

		try {
			quantBugs = Integer.valueOf(dadosDaRodada[8]);
			quantDevs = Integer.valueOf(dadosDaRodada[9]);

			adicionarAstros(memoria.getJava().getAstros());
			memoria.getJava().movimentarPlanetas(dadosDaRodada);
			memoria.getJava().verificarColisoes();
			
			if(memoria.getJava().verificarSeTodosExplodiram() == true) {
				JOptionPane.showConfirmDialog(null, "Todos os planetas explodiram. O sistema será reiniciado.",
						null, JOptionPane.WARNING_MESSAGE);
				memoria.reiniciarSistema();
			}
		} catch (Exception e) {

		}
	}

	public void adicionarAstros(ArrayList<Astros> astros) {

		for (int i = 0; i < quantBugs; i++) {
			if (astros.size() < 225) {
				Bug b = new Bug();
				for (int j = 0; j < astros.size(); j++) {
					if (b.getPosicaoX() == astros.get(j).getPosicaoX()
							&& b.getPosicaoY() == astros.get(j).getPosicaoY()) {
						b = new Bug();
						if (astros.size() < 225)
							j = 0;
						else
							j = astros.size();
					}
				}
				astros.add(b);
			}
		}

		for (int i = 0; i < quantDevs; i++) {
			if (astros.size() < 225) {
				Dev d = new Dev();
				for (int j = 0; j < astros.size(); j++) {
					if (d.getPosicaoX() == astros.get(j).getPosicaoX()
							&& d.getPosicaoY() == astros.get(j).getPosicaoY()) {
						d = new Dev();
						if (astros.size() < 225)
							j = 0;
						else
							j = astros.size();
					}
				}
				astros.add(d);
			}
		}
	}
}
