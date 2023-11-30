package controller.astros;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import controller.planetas.PlanetasLinguagens;

public class Dev extends Astros {

	public Dev() {
		this.icon = new ImageIcon("imagens/devicon.png");
		tipo = "DEV";
	}

	public void modificarVelocidade(ArrayList<PlanetasLinguagens> planetas) {

		for (PlanetasLinguagens p : planetas) {

			if (posicaoX == p.getPosicaoX() && posicaoY == p.getPosicaoY() && !p.isExplodiu()) {

				if (this.colidiu == false) {
					p.setQuantColisoesComDevs(p.getQuantColisoesComDevs() + 1);
					p.setVelocidade(p.getVelocidade() + 1);
					this.colidiu = true;

				}
			}

		}

	}

}
