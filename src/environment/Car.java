package environment;

import java.awt.Color;
import gameCommons.Game;
import graphicalElements.Element;
import util.Case;

public class Car {
	private Game game;
	private Case leftPosition;
	private boolean leftToRight;
	private int length;
	private final Color colorLtR = Color.BLACK;
	private final Color colorRtL = Color.BLUE;

	//TODO Constructeur(s)
	public Car(Game game, Case leftPosition, boolean leftToRight){
		this.game = game;
		this.leftToRight = leftToRight;
		this.length = game.randomGen.nextInt(3) + 1;
		if(leftToRight){
			this.leftPosition = new Case(0, leftPosition.ord);
		}else{
			this.leftPosition = new Case(game.width - this.length, leftPosition.ord);
		}
	}

	//TODO : ajout de methods
	public void moveCar(boolean a){
		if(a) {
			if (leftToRight) {
				this.leftPosition = new Case(this.leftPosition.absc + 1, leftPosition.ord);
			}else{
				this.leftPosition = new Case(this.leftPosition.absc - 1, leftPosition.ord);
			}
		}
		this.addToGraphics();
	}

	public boolean correct(){
		if(leftToRight && this.leftPosition.absc < game.width){
			return true;
		}else if(!leftToRight && this.leftPosition.absc + this.length > 0){
			return true;
		}
		return false;
	}

	public boolean isSafe(Case c){
		for(int i = 0;i < this.length;i++){
			if(this.leftPosition.absc + i == c.absc && this.leftPosition.ord == c.ord){
				return false;
			}
		}
		return true;
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
