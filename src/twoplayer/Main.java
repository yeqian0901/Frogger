package twoplayer;

import Temps.Environment;
import frog.Frog;
import gameCommons.IEnvironment;
import gameCommons.IFrog;
import graphicalElements.FroggerGraphic2;
import graphicalElements.IFroggerGraphics2;
import util.Case;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

        //Caract�ristiques du jeu
        int width = 26;
        int height = 28;
        int tempo = 100;
        int minSpeedInTimerLoops = 100; //3
        double defaultDensity = 0.1; //0.2

        //Cr�ation de l'interface graphique
        IFroggerGraphics2 graphic = new FroggerGraphic2(width, height);
        //Cr�ation de la partie
        Game3 game = new Game3(graphic, width, height, minSpeedInTimerLoops, defaultDensity);
        //Cr�ation et liason de la grenouille
        IFrog frog1 = new Frog2(game, new Case((game.width/2)+1, 0));
        IFrog frog2 = new Frog2(game, new Case((game.width/2)-1, 0));
        game.setFrog(frog1, frog2);
        graphic.setFrog(frog1, frog2);
        //Cr�ation et liaison de l'environnement
        IEnvironment env = new Environment3(game);
        game.setEnvironment(env);
        //Boucle principale : l'environnement s'acturalise tous les tempo milisecondes
        Timer timer = new Timer(tempo, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.update();
                graphic.repaint();
            }
        });
        timer.setInitialDelay(0);
        timer.start();
    }
}
