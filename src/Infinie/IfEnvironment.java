package Infinie;

import environment.Lane;
import gameCommons.Game;
import graphicalElements.Element;
import util.Case;

import java.awt.*;
import java.util.ArrayList;

public class IfEnvironment implements DEnvironment {
    private Game game;
    private ArrayList<IfLane> voies;

    public IfEnvironment(Game game){
        this.game = game;
        this.voies = new ArrayList<>();
        voies.add(new IfLane(game,0,0.0));
        voies.add(new IfLane(game,1,0.0));
        for(int i = 2;i < game.height; i++){
            this.addLane(i);
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
        for(IfLane l : voies){
            l.update();
        }
    }

    public void addLane(int i){
        this.voies.add(new IfLane(this.game, i));
    }
    public void addLane(){
        this.addLane(this.voies.size());
    }
}
