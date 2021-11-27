package Infinie;

import gameCommons.Game;
import gameCommons.IFrog;
import graphicalElements.Element;
import util.Case;
import util.Direction;
import graphicalElements.Element;
import graphicalElements.IFroggerGraphics;
import environment.Environment;

import java.awt.*;

public class IfFrog implements IFrog {
    private Game game;
    private Case position;
    private Direction direction;


    public IfFrog(Game game) {
        this.game = game;
        position = new Case(game.width/2, 0);
        direction=Direction.up;
    }

    public Case getPosition() {
        return this.position;
    }

    public Direction getDirection(){
        return this.direction;
    }

    public void move(Direction key) {
        this.direction = key;
        if (key == Direction.up && position.ord < game.height - 1) {
            position = new Case(position.absc, position.ord + 1);
            game.score++;
            if(game.score > game.scoreMax){
                game.scoreMax = game.score;
                game.addL();
            }
            final Game game = this.game;
        } else if (key == Direction.left && position.absc > 0) {
            position = new Case(position.absc - 1, position.ord);
        } else if (key == Direction.right && position.absc < game.width - 1) {
            position = new Case(position.absc + 1, position.ord);
        } else if (key == Direction.down && position.ord > 0) {
            position = new Case(position.absc, position.ord - 1);
            final Game game2 = this.game;
            game.score--;
        }
    }


}
