

public class CompteEpargne extends Compte {

    public static final double TAUX = 6.0;
    private static int nbComptes = 0;

    public CompteEpargne(Client cl, Agence lagence) {
        super(cl, lagence);

        setCode("CompteEpargne:" + (++nbComptes));
    }

    public double getTaux() {
        return TAUX;
    }

    public double calculInteret() {
        double interet = solde * TAUX / 100;
        solde += interet;
        return interet;
    }

    public String toString() {
        return super.toString() +
               "\nType : Compte Epargne" +
               "\nTaux d'interet : " + TAUX + "%";
    }
}
