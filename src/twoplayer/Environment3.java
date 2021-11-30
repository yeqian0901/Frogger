package twoplayer;

import Temps.Game;
import Temps.Lane;
import gameCommons.IEnvironment;
import util.Case;

import java.util.ArrayList;

public class Environment3 implements IEnvironment {

	//TODO
    private Game3 game;
    private ArrayList<Lane3> voies;

    public Environment3(Game3 game){
        this.game = game;
        this.voies = new ArrayList<>();
        voies.add(new Lane3(game,0,0.0));
        for(int i = 1;i < game.height - 1; i++){
            voies.add(new Lane3(game,i));
        }
        voies.add(new Lane3(game, game.height-1,0.0));
    }

    @Override
    public boolean isSafe(Case c) {
        for(Lane3 l : voies) {
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
        for(Lane3 l : voies){
            l.update();
        }
    }

}
