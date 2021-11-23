package environment;

import java.awt.Color;

import util.Case;
import gameCommons.Game;
import graphicalElements.Element;
import java.util.Random;

public class Car {
	private Game game;
	private Case leftPosition;
	private boolean leftToRight;
	private int length;
	private final Color colorLtR = Color.BLACK;
	private final Color colorRtL = Color.BLUE;

	//TODO Constructeur(s)
	public Car(Game game, Case leftPosition, boolean leftToRight){
		Random r = new Random();
		this.game = game;
		this.leftPosition = leftPosition;
		this.leftToRight = leftToRight;
		this.length = r.nextInt(3) + 1;
		addToGraphics();
	}

	//TODO : ajout de methods
	public void setLeftPosition(Case c){
		this.leftPosition = c;
	}

	public Case getLeftPosition(){
		return this.leftPosition;
	}

	public int getLength(){
		return this.length;
	}

	
	
	/* Fourni : addToGraphics() permettant d'ajouter un element graphique correspondant a la voiture*/
	private void addToGraphics() {
		for (int i = 0; i < length; i++) {
			Color color = colorRtL;
			if (this.leftToRight){
				color = colorLtR;
			}
			game.getGraphic()
					.add(new Element(leftPosition.absc + i, leftPosition.ord, color));
		}
	}

}
