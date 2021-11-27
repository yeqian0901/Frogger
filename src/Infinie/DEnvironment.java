package Infinie;

import util.Case;

public interface DEnvironment {
    public boolean isSafe(Case c);

    /**
     * Teste si la case est une case d'arrivee
     *
     * @param c
     * @return vrai si la case est une case de victoire
     */
    public boolean isWinningPosition(Case c);

    /**
     * Effectue une �tape d'actualisation de l'environnement
     */
    public void update();
    public void addLane();
}
