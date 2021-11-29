package frog;

import environment.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;

public class Frog implements IFrog {
	
	private Game game;
	private Case position;
	private Direction direction;


    public Frog(Game game) {
        this.game = game;
        position = new Case(game.width/2, 0);
        direction=Direction.up;
    }

    @Override
    public Case getPosition() {
        return position;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public void move(Direction key) {
        if (key == Direction.up && position.ord < game.height - 1) {
            position = new Case(position.absc, position.ord + 1);
        } else if (key == Direction.left && position.absc > 0) {
            position = new Case(position.absc - 1, position.ord);
        } else if (key == Direction.right && position.absc < game.width - 1) {
            position = new Case(position.absc + 1, position.ord);
        } else if (key == Direction.down && position.ord > 0) {
            position = new Case(position.absc, position.ord - 1);
        }
    }
}
