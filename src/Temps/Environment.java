package Temps;

import java.util.ArrayList;

import util.Case;
import gameCommons.IEnvironment;

public class Environment implements IEnvironment {
		
	//TODO
    private Game game;
    private ArrayList<Lane> voies;

    public Environment(Game game){
        this.game = game;
        this.voies = new ArrayList<>();
        voies.add(new Lane(game,0,0.0));
        for(int i = 1;i < game.height - 1; i++){
            voies.add(new Lane(game,i));
        }
        voies.add(new Lane(game, game.height-1,0.0));
    }

    @Override
    public boolean isSafe(Case c) {
        for(Lane l : voies) {
            if(!l.isSafe(c)){
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
