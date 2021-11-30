package partie2;

import util.Case;

import java.util.ArrayList;

public class Lane2 {
    private Game2 game;
    private int ord;
    private int speed;
    private ArrayList<Car2> cars = new ArrayList<>();
    private boolean leftToRight;
    private double density;
    private int time;

    // TODO : Constructeur(s)
    public Lane2(Game2 game, int ord, double density){
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

    public Lane2(Game2 game, int ord){
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
        for(Car2 a : cars){
            a.moveCar(b);
        }
        this.remove();
    }

    public void remove(){
        ArrayList<Car2> s = new ArrayList<>();
        for(Car2 a : cars){
            if(!a.correct()){
                s.add(a);
            }
        }
        for(Car2 b : s){
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
                cars.add(new Car2(game, getBeforeFirstCase(), leftToRight));
            }
        }
    }

    public boolean isSafe(Case c) {
        for(Car2 a : cars){
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
