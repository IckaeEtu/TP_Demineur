import java.util.ArrayList;
import java.util.List;

public class CaseIntelligente extends Case {
    private List<Case> lesVoisines;

    /*Initialise une case intelligente qui est une case avec des voisines */
    public CaseIntelligente(){
        super();
        this.lesVoisines = new ArrayList<>();
    }

    public void ajouteVoisine(Case uneCase){
        
    }
}
