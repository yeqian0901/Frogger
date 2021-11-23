package environment;

import java.util.ArrayList;

import gameCommons.IFrog;
import util.Case;
import gameCommons.Game;
import gameCommons.IEnvironment;

public class Environment implements IEnvironment {
		
	//TODO
    private Game game;
    private ArrayList<Lane> voies;

    public Environment(Game game){
        this.game = game;
        voies = new ArrayList<>();
    }

    public void setVoies(ArrayList<Lane> a){
        this.voies = a;
    }

    @Override
    public boolean isSafe(Case c) {
        for(Lane l : voies){
            ArrayList<Case> a = l.getCaseDeCar();
            if(a.contains(c)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isWinningPosition(Case c) {
        if(c.ord == game.height - 1){
            return true;
        }
        return false;
    }

    @Override
    public void update() {
        for(Lane l : voies){
            l.update();
        }
    }

}
