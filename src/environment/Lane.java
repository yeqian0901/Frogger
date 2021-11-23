package environment;

import java.util.ArrayList;

import util.Case;
import gameCommons.Game;
import gameCommons.IEnvironment;

public class Lane {
	private Game game;
	private int ord;
	private int speed;
	private ArrayList<Car> cars = new ArrayList<>();
	private boolean leftToRight;
	private double density;

	// TODO : Constructeur(s)
	public Lane(Game game, int ord, int speed, boolean leftToRight, double density){
		this.game = game;
		this.ord = ord;
		this.speed = speed;
		this.cars = new ArrayList<>();
		this.leftToRight = leftToRight;
		this.density = density;
	}

	public void update() {

		// TODO
		for(int i=0;i < cars.size();i++) {
			if (leftToRight) {
				Case c = cars.get(i).getLeftPosition();
				c = new Case(c.absc+speed, c.ord);
				if(c.absc < game.width) {
					cars.get(i).setLeftPosition(c);
				}else{
					mayAddCar();
				}
			}else{
				Case c = cars.get(i).getLeftPosition();
				c = new Case(c.absc-speed, c.ord);
				cars.get(i).setLeftPosition(c);
				if(c.absc + cars.get(i).getLength() > 0) {
					cars.get(i).setLeftPosition(c);
				}else{
					mayAddCar();
				}
			}
		}
		// Toutes les voitures se d�placent d'une case au bout d'un nombre "tic
		// d'horloge" �gal � leur vitesse
		// Notez que cette m�thode est appel�e � chaque tic d'horloge

		// Les voitures doivent etre ajoutes a l interface graphique meme quand
		// elle ne bougent pas

		// A chaque tic d'horloge, une voiture peut �tre ajout�e

	}

	// TODO : ajout de methodes
	public ArrayList<Case> getCaseDeCar(){
		ArrayList<Case> a = new ArrayList<>();
		for(Car i : cars){
			a.add(i.getLeftPosition());
			if(i.getLength() > 1){
				for(int j = 1; j < i.getLength(); j++){
					Case c = new Case(i.getLeftPosition().absc + j, ord);
					a.add(c);
				}
			}
		}
		return a;
	}
	/*
	 * Fourni : mayAddCar(), getFirstCase() et getBeforeFirstCase() 
	 */

	/**
	 * Ajoute une voiture au d�but de la voie avec probabilit� �gale � la
	 * densit�, si la premi�re case de la voie est vide
	 */
	private void mayAddCar() {
		if (isSafe(getFirstCase()) && isSafe(getBeforeFirstCase())) {
			if (game.randomGen.nextDouble() < density) {
				cars.add(new Car(game, getBeforeFirstCase(), leftToRight));
			}
		}
	}

	private boolean isSafe(Case firstCase) {
		if(this.getCaseDeCar().contains(firstCase)){
			return false;
		}
		return true;
	}

	private Case getFirstCase() {
		if (leftToRight) {
			return new Case(0, ord);
		} else
			return new Case(game.width - 1, ord);
	}

	private Case getBeforeFirstCase() {
		if (leftToRight) {
			return new Case(-1, ord);
		} else
			return new Case(game.width, ord);
	}

}
