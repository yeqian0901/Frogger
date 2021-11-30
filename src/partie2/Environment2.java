package partie2;

import gameCommons.IEnvironment;
import util.Case;

import java.util.ArrayList;

public class Environment2 implements IEnvironment {
    private Game2 game;
    private ArrayList<Lane2> voies;

    public Environment2(Game2 game){
        this.game = game;
        this.voies = new ArrayList<>();
        voies.add(new Lane2(game,0,0.0));
        for(int i = 1;i < game.height - 1; i++){
            voies.add(new Lane2(game,i));
        }
        voies.add(new Lane2(game, game.height-1,0.0));
    }

    @Override
    public boolean isSafe(Case c) {
        for(Lane2 l : voies) {
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
        for(Lane2 l : voies){
            l.update();
        }
    }
}
