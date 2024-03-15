import java.util.ArrayList;
import java.util.List;

public class CaseIntelligente extends Case {
    private List<Case> lesVoisines;

    /*Initialise une case intelligente qui est une case avec des voisines */
    public CaseIntelligente(){
        super();
        this.lesVoisines = new ArrayList<>();
    }

    /*Ajoute une case a la liste des cases voisines */
    public void ajouteVoisine(Case uneCase){
        this.lesVoisines.add(uneCase);
    }

    /*Renvoie le nombre de cases voisines qui contienne une bombre */
    public int nombreBombesVoisines(){
        int cpt = 0;
        for (Case uneCase : this.lesVoisines){
            if (uneCase.contientUneBombe()){
                cpt +=1;
            }
        }
        return cpt;
    }

    /*Renvoie ce qui doit être affiché sur la case */
    @Override
    public String toString(){
        if (this.estMarque){
            return "?";
        }
        if (!(this.estDecouverte) && !(this.estMarque)){
            return " ";
        }
        if (this.contientUneBombe) {
            return "@";
        }
        else{
            return String.valueOf(this.nombreBombesVoisines());
        }

    }


}
