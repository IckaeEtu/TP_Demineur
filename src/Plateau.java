import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Plateau{
    protected int nbLignes;
    protected int nbColonnes;
    protected int pourcentageDeBombes;
    protected int nbBombes;
    protected List<Case> lePlateau;

    /*Créer un plateau vide avec un nb lignes, un nb colonnes et un pourcentage de bombe souhaité*/
    public Plateau(int nbLignes, int nbColonnes, int pourcentage){
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.pourcentageDeBombes = pourcentage;
        this.lePlateau = new ArrayList<>();
        this.nbBombes = (nbLignes * nbColonnes)* (1/pourcentage);
    }

    /*Créer une liste de case vide  */
    private void creerLesCasesVides(){
        for (int i=0; i < this.nbLignes*this.nbColonnes ;++i){
            this.lePlateau.add(i,new Case());
        }
    }   

    /*Créer une lsite de case intelligentes */
    private void rendLesCasesIntelligentes(){
        for(int i=0; i < this.nbLignes*this.nbColonnes ;++i){
            this.lePlateau.add(i,new CaseIntelligente());
        }
    }

    /*Renvoie le nombre de lignes */
    public int getNbLignes(){
        return this.nbLignes;
    }

    /*Renvoie le nombre de colonnes */
    public int getNbColonnes(){
        return this.nbColonnes;
    }

    /*Renvoie le nombre de bombes sur le plateau */
    public int getNbTotalBombes(){
        return this.nbBombes;
    }

    /*Renvoie la case aux coordonnées (numligne,numolonne) */
    public Case getCase(int numLigne, int numColonne){
        return this.lePlateau.get(numLigne*this.getNbColonnes()+numColonne);
    }

    /*Renvoie le nombre de cases marquee */
    public int getNbCaseMarquees(){
        int cpt = 0;
        for (Case uneCase: this.lePlateau){
            if (uneCase.estMarque()){
                cpt += 1;
            }
        }
        return cpt;
    }

    /*Pose une bombe sur la case aux coordonées (x,y) */
    public void poseBombe(int x, int y){
        Case laCase = this.getCase(x, y);
        laCase.poseBombe();
    }

    /*Remet toute les cases dans leur état initial */
    public void reset(){
        this.rendLesCasesIntelligentes();
    }




    protected void poseDesBombesAleatoirement(){
        Random generateur = new Random();
        for (int x = 0; x < this.getNbLignes(); x++){
            for (int y = 0; y < this.getNbColonnes(); y++){
                if (generateur.nextInt(100)+1 < this.pourcentageDeBombes){
                    this.poseBombe(x, y);
                    this.nbBombes = this.nbBombes + 1;
                }
            }
        }
    }

}
