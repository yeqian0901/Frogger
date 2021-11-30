package Temps;

import gameCommons.IFrog;
import graphicalElements.Element;
import graphicalElements.IFroggerGraphics;
import gameCommons.IEnvironment;

import java.awt.*;
import java.util.Random;

public class Game {
        public final Random randomGen = new Random();

        // Caracteristique de la partie
        public final int width;
        public final int height;
        public final int minSpeedInTimerLoops;
        public final double defaultDensity;
        public long time;

        // Lien aux objets utilis�s
        private IEnvironment environment;
        private IFrog frog;
        private IFroggerGraphics graphic;
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
        public Game(IFroggerGraphics graphic, int width, int height, int minSpeedInTimerLoop, double defaultDensity) {
            super();
            this.graphic = graphic;
            this.width = width;
            this.height = height;
            this.minSpeedInTimerLoops = minSpeedInTimerLoop;
            this.defaultDensity = defaultDensity;
            this.time = System.currentTimeMillis() ;
        }

        /**
         * Lie l'objet frog � la partie
         *
         * @param frog
         */
        public void setFrog(IFrog frog) {
            this.frog = frog;
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
        public IFroggerGraphics getGraphic() {
            return graphic;
        }

        /**
         * Teste si la partie est perdue et lance un �cran de fin appropri� si tel
         * est le cas
         *
         * @return true si le partie est perdue
         */
        public boolean testLose() {
            if(environment.isSafe(frog.getPosition())){
                return false;
            }
            long end = System.currentTimeMillis();
            System.out.println("You lose\n" + "Time :" + (end - this.time)/1000);
            System.exit(1);
            return true;
        }

        /**
         * Teste si la partie est gagnee et lance un �cran de fin appropri� si tel
         * est le cas
         *
         * @return true si la partie est gagn�e
         */
        public boolean testWin() {
            if(environment.isWinningPosition(frog.getPosition())){
                long end = System.currentTimeMillis();
                System.out.println((end - this.time)/1000);
                System.exit(1);
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
            this.graphic.add(new Element(frog.getPosition(), Color.GREEN));
            testLose();
            testWin();
        }

}
