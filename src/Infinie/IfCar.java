package Infinie;

import gameCommons.Game;
import graphicalElements.Element;
import util.Case;

import java.awt.*;

public class IfCar {
    private Game game;
    private Case leftPosition;
    private boolean leftToRight;
    private int length;
    private final Color colorLtR;
    private final Color colorRtL;

    public IfCar(final Game game, final Case leftPosition, final boolean leftToRight) {
        this.colorLtR = Color.BLACK;
        this.colorRtL = Color.BLUE;
        this.game = game;
        this.length = game.randomGen.nextInt(3) + 1;
        this.leftToRight = leftToRight;
        if(leftToRight){
            this.leftPosition = new Case(0, leftPosition.ord);
        }else{
            this.leftPosition = new Case(game.width - this.length, leftPosition.ord);
        }
    }

    public void move(final boolean b) {
        if(b) {
            if (this.leftToRight) {
                this.leftPosition = new Case(this.leftPosition.absc + 1, leftPosition.ord);
            }else{
                this.leftPosition = new Case(this.leftPosition.absc - 1, leftPosition.ord);
            }
        }
        this.addToGraphics();
    }

    private void addToGraphics() {
        for (int i = 0; i < this.length; ++i) {
            this.game.getGraphic().add(new Element(this.leftPosition.absc + i, this.leftPosition.ord - this.game.score, this.leftToRight ? this.colorLtR : this.colorRtL));
        }
    }

    public boolean correct() {
        if(leftToRight && this.leftPosition.absc < game.width){
            return true;
        }else if(!leftToRight && this.leftPosition.absc + this.length > 0){
            return true;
        }
        return false;
    }

    public boolean isSafe(final Case c) {
        for(int i = 0;i < this.length;i++){
            if(this.leftPosition.absc + i == c.absc && this.leftPosition.ord == c.ord){
                return false;
            }
        }
        return true;
    }
}
