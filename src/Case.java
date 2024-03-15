public class Case{
    protected boolean contientUneBombe;
    protected boolean estDecouverte;
    protected boolean estMarque;

    /*Initialise une case avec tout à false*/
    public Case(){
        this.contientUneBombe = false;
        this.estDecouverte = false;
        this.estMarque = false;
    }

    /*Remet la case à ses valeurs initiales, tout à false*/
    public void reset(){
        this.contientUneBombe = false;
        this.estDecouverte = false;
        this.estMarque = false;
    }

    /*Met contientUneBombe à true*/
    public void poseBombe(){
        this.contientUneBombe = true;
    }

    /*Renvoie true si la case contient une bombe sinon non */
    public boolean contientUneBombe(){
        return this.contientUneBombe;
    }

    /*Renvoi true si la case est decouverte */
    public boolean estDecouverte(){
        return this.estDecouverte;
    }

    /*Renvoie true si la case est marque sinon false */
    public boolean estMarque(){
        return this.estMarque;
    }

    /*Renvoie false si la case est deja revele, sinon renvoie true et la revele */
    public boolean reveler(){
        if (this.estDecouverte){
            return false;
        }
        else {
            this.estDecouverte = true;
            return true;
        }
    }

    /*met estMarque a true */
    public void marquer(){
        this.estMarque = true;
    }
}