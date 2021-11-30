package Infinie;

import gameCommons.Game;
import util.Case;

import java.util.ArrayList;

public class IfEnvironment implements DEnvironment {
    private Game game;
    private ArrayList<IfLane> voies;

    public IfEnvironment(Game game){
        this.game = game;
        this.voies = new ArrayList<IfLane>();
        voies.add(new IfLane(game,0,0.0));
        voies.add(new IfLane(game,1,0.0));
        for(int i = 2;i < game.height; i++){
            voies.add(new IfLane(game,i));
        }
    }

    @Override
    public boolean isSafe(Case c) {
        for(IfLane l : voies) {
            if(!l.isSafe(c)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isWinningPosition(Case c) {
        return false;
    }

    @Override
    public void update() {
        for(final IfLane l : voies){
            l.update();
        }
    }

    @Override
    public void addLane(){
        this.voies.add(new IfLane(this.game, voies.size()));
    }

}
