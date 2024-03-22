import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Plateau{
    protected int nbLignes;
    protected int nbColonnes;
    protected int pourcentageDeBombes;
    protected int nbBombes;
    protected List<CaseIntelligente> lePlateau;

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
            this.lePlateau.add(i,new CaseIntelligente());
        }
    }   

    /*Créer une lsite de case intelligentes */
    private void rendLesCasesIntelligentes(){
        for (int i=0; i<this.nbLignes*this.nbColonnes;++i){
            this.lePlateau.add(i,new CaseIntelligente());
        }
        
        for (int i = 0; i < this.nbLignes; ++i){
            for (int j = 0; j< this.nbColonnes; ++i){
                CaseIntelligente kase = this.getCase(i, j);

                if (this.estVoisine(i-1, j-1)){
                    kase.ajouteVoisine(this.getCase(i-1, j-1));
                } if (this.estVoisine(i-1, j)){
                    kase.ajouteVoisine(this.getCase(i-1, j));
                } if (this.estVoisine(i-1, j+1)){
                    kase.ajouteVoisine(this.getCase(-1, j+1));
                } if (this.estVoisine(i, j-1)){
                    kase.ajouteVoisine(this.getCase(i, j-1));
                } if (this.estVoisine(i, j)){
                    kase.ajouteVoisine(this.getCase(i, j));
                } if (this.estVoisine(i, j+1)){
                    kase.ajouteVoisine(this.getCase(i, j+1));
                } if (this.estVoisine(i+1, j-1)){
                    kase.ajouteVoisine(this.getCase(i, j-1));
                } if (this.estVoisine(i+1, j)){
                    kase.ajouteVoisine(this.getCase(i, j-1));
                } if (this.estVoisine(i+1, j+1)){
                    kase.ajouteVoisine(this.getCase(i, j-1));
                }
            }
        } 
    }

    public boolean estVoisine(int i,int j){
        int nbColonnes = this.getNbColonnes();
        int nbLignes = this.getNbLignes();
        return (!((j-1)%nbColonnes==(nbColonnes-1) || ((j+1)%nbColonnes==0) || (i+1>nbLignes) || (i-1<0)));
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
    public CaseIntelligente getCase(int numLigne, int numColonne){
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
        this.creerLesCasesVides();
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
