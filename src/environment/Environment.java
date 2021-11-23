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
        this.voies = new ArrayList<>();
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
        for(int i = 1; i < voies.size()-1;i++){
            Lane l = voies.get(i);
            l.update();
            voies.set(i, l);
        }
    }

}
