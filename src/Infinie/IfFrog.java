package Infinie;

import gameCommons.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;

public class IfFrog implements IFrog {
    private Game game;
    private Case position;
    private Direction direction;


    public IfFrog(final Game game) {
        this.game = game;
        position = new Case(game.width/2, 1);
        direction=Direction.up;
    }

    @Override
    public Case getPosition() {
        return this.position;
    }

    @Override
    public Direction getDirection(){
        return this.direction;
    }

    @Override
    public void move(final Direction key) {
            this.direction = key;
            if (key == Direction.up) {
                this.position = new Case(this.position.absc, this.position.ord + 1);
                game.score++;
                if(game.score > game.scoreMax){
                    game.scoreMax = game.score;
                    game.addL();
                }
            }
            if (key == Direction.left && position.absc > 0) {
                position = new Case(position.absc - 1, position.ord);
            }
            if (key == Direction.right && position.absc < game.width - 1) {
                position = new Case(position.absc + 1, position.ord);
            }
            if (key == Direction.down && position.ord > 1) {
                position = new Case(position.absc, position.ord - 1);
                game.score--;
            }
            System.out.println(String.valueOf(this.position.absc) + " " + this.position.ord + " score : " + this.game.score);
        }



    }
