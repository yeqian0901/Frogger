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

    public IfCar(final Game game, final Case frontPosition, final boolean leftToRight) {
        this.colorLtR = Color.BLACK;
        this.colorRtL = Color.BLUE;
        this.game = game;
        this.length = game.randomGen.nextInt(3) + 1;
        this.leftToRight = leftToRight;
        this.leftPosition = new Case(leftToRight ? (frontPosition.absc - this.length) : frontPosition.absc, frontPosition.ord);
    }

    public void move(final boolean b) {
        if (b) {
            this.leftPosition = new Case(this.leftPosition.absc + (this.leftToRight ? 1 : -1), this.leftPosition.ord);
        }
        this.addToGraphics();
    }

    private void addToGraphics() {
        for (int i = 0; i < this.length; ++i) {
            this.game.getGraphic().add(new Element(this.leftPosition.absc + i, this.leftPosition.ord - this.game.score, this.leftToRight ? this.colorLtR : this.colorRtL));
        }
    }

    public boolean appearsInBounds() {
        return this.leftPosition.absc + this.length > 0 || this.leftPosition.absc < this.game.width;
    }

    public boolean coversCase(final Case pos) {
        return pos.ord == this.leftPosition.ord && (pos.absc >= this.leftPosition.absc && pos.absc < this.leftPosition.absc + this.length);
    }
}
