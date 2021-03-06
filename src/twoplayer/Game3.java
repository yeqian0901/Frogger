package twoplayer;

import gameCommons.IEnvironment;
import gameCommons.IFrog;
import graphicalElements.Element;
import graphicalElements.IFroggerGraphics2;

import java.awt.*;
import java.util.Random;

public class Game3 {
    public final Random randomGen = new Random();

    // Caracteristique de la partie
    public final int width;
    public final int height;
    public final int minSpeedInTimerLoops;
    public final double defaultDensity;

    // Lien aux objets utilis�s
    private IEnvironment environment;
    private IFrog frog1;
    private IFrog frog2;
    private IFroggerGraphics2 graphic;
    /**
     *
     * @param graphic
     *            l'interface graphique
     * @param width
     *            largeur en cases
     * @param height
     *            hauteur en cases
     * @param minSpeedInTimerLoop
     *            Vitesse minimale, en nombre de tour de timer avant d�placement
     * @param defaultDensity
     *            densite de voiture utilisee par defaut pour les routes
     */
    public Game3(IFroggerGraphics2 graphic, int width, int height, int minSpeedInTimerLoop, double defaultDensity) {
        super();
        this.graphic = graphic;
        this.width = width;
        this.height = height;
        this.minSpeedInTimerLoops = minSpeedInTimerLoop;
        this.defaultDensity = defaultDensity;
    }

    /**
     * Lie l'objet frog � la partie
     *
     * @param frog1, frog2
     */
    public void setFrog(IFrog frog1, IFrog frog2) {
        this.frog1 = frog1;
        this.frog2 = frog2;
    }

    /**
     * Lie l'objet environment a la partie
     *
     * @param environment
     */
    public void setEnvironment(IEnvironment environment) {
        this.environment = environment;
    }

    /**
     *
     * @return l'interface graphique
     */
    public IFroggerGraphics2 getGraphic() {
        return graphic;
    }

    /**
     * Teste si la partie est perdue et lance un �cran de fin appropri� si tel
     * est le cas
     *
     * @return true si le partie est perdue
     */
    public boolean testLose() {
        if(environment.isSafe(frog1.getPosition()) && environment.isSafe(frog2.getPosition())){
            return false;
        }
        graphic.endGameScreen("You lose");
        return true;
    }

    /**
     * Teste si la partie est gagnee et lance un �cran de fin appropri� si tel
     * est le cas
     *
     * @return true si la partie est gagn�e
     */
    public boolean testWin() {
        if(environment.isWinningPosition(frog1.getPosition()) && environment.isWinningPosition(frog2.getPosition())){
            graphic.endGameScreen("You win");
            return true;
        }
        return false;
    }

    /**
     * Actualise l'environnement, affiche la grenouille et verifie la fin de
     * partie.
     */
    public void update() {
        graphic.clear();
        environment.update();
        this.graphic.add(new Element(frog1.getPosition(), Color.GREEN));
        this.graphic.add(new Element(frog2.getPosition(), Color.RED));
        testLose();
        testWin();
    }

}
