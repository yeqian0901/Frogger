package environment;

import java.util.ArrayList;

import util.Case;
import gameCommons.IEnvironment;

public class Lane {
	private Game game;
	private int ord;
	private int speed;
	private ArrayList<Car> cars = new ArrayList<>();
	private boolean leftToRight;
	private double density;
	private int time;

	// TODO : Constructeur(s)
	public Lane(Game game, int ord, double density){
		this.game = game;
		this.ord = ord;
		this.speed = game.randomGen.nextInt(game.minSpeedInTimerLoops) + 1;
		this.cars = new ArrayList<>();
		this.leftToRight = game.randomGen.nextBoolean();
		this.density = density;
		for(int i = 0; i < game.width * 10; i++){
			this.move(true);
			this.mayAddCar();
		}
	}

	public Lane(Game game, int ord){
		this(game, ord, game.defaultDensity);
	}

	public void update() {
		this.time++;
		if(this.time <= this.speed){
			move(false);
			return;
		}
		this.move(true);
		this.mayAddCar();
		this.time = 0;
	}
		// Toutes les voitures se d�placent d'une case au bout d'un nombre "tic
		// d'horloge" �gal � leur vitesse
		// Notez que cette m�thode est appel�e � chaque tic d'horloge

		// Les voitures doivent etre ajoutes a l interface graphique meme quand
		// elle ne bougent pas

		// A chaque tic d'horloge, une voiture peut �tre ajout�e



	// TODO : ajout de methodes
	public void move(boolean b){
		for(Car a : cars){
			a.moveCar(b);
		}
		this.remove();
	}

	public void remove(){
		ArrayList<Car> s = new ArrayList<>();
		for(Car a : cars){
			if(!a.correct()){
				s.add(a);
			}
		}
		for(Car b : s){
			cars.remove(b);
		}
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

	public boolean isSafe(Case c) {
		for(Car a : cars){
			if(!a.isSafe(c)){
				return false;
			}
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
