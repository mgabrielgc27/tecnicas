package controller;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import controller.astros.Astros;
import controller.planetas.C;
import controller.planetas.Cplus;
import controller.planetas.Csharp;
import controller.planetas.JavaScript;
import controller.planetas.PHP;
import controller.planetas.PlanetasLinguagens;
import controller.planetas.Python;
import controller.planetas.Ruby;

public class EstrelaJava {
	
	protected ImageIcon icon = new ImageIcon("imagens/javaicon.png");
	protected String nome = "JAVA";
	protected int posicaoX = 7;
	protected int posicaoY = 7;
	protected ArrayList<PlanetasLinguagens> planetas = new ArrayList<PlanetasLinguagens>();
	protected ArrayList<Astros> astros = new ArrayList<Astros>();

	public EstrelaJava() {
		planetas.add(new Python("Python", 1));
		planetas.add(new JavaScript("Java Script", 2));
		planetas.add(new Ruby("Ruby On Rails", 3));
		planetas.add(new PHP("PHP", 4));
		planetas.add(new Csharp("C#", 5));
		planetas.add(new Cplus("C++", 6));
		planetas.add(new C("C", 7));
	}

	public void verificarColisoes() {
		excluirCorposNulos();
		for (Astros a : astros) {
			a.modificarVelocidade(planetas);
		}
	}

	private void excluirCorposNulos() {
		
		for (int i = 0; i < astros.size(); i++) {
			if (astros.get(i).isColidiu())
				astros.remove(i);
		}
	}

	public void movimentarPlanetas(String[] instantes) {
		 
		for (int i = 0; i < planetas.size(); i++) {
			if(!planetas.get(i).isExplodiu()) {
				planetas.get(i).rotacionar(Integer.valueOf(instantes[(i+1)]));
				planetas.get(i).translacionar(Integer.valueOf(instantes[(i+1)]));
			}
		}
			
	}
	
	public boolean verificarSeTodosExplodiram() {
		boolean todosMortos = false;
		for (PlanetasLinguagens p : planetas) {
			if(p.isExplodiu())
				todosMortos = true;
			else
				todosMortos = false;
		}
		
		return todosMortos;		
	}
	
	public ImageIcon getIcon() {
		return icon;
	}

	public int getPosicaoX() {
		return posicaoX;
	}

	public ArrayList<PlanetasLinguagens> getPlanetas() {
		return planetas;
	}

	public int getPosicaoY() {
		return posicaoY;
	}

	public ArrayList<Astros> getAstros() {
		return astros;
	}
	
}