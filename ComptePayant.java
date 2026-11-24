
public class ComptePayant extends Compte {

    public static final double TAUX_OPERATION = 5.0;
    private static int nbComptes = 0;

    public ComptePayant(Client cl, Agence lagence) {
        super(cl, lagence);

        setCode("ComptePayant:" + (++nbComptes));
    }

    
    public void deposer(double s) {
        if (s <= TAUX_OPERATION) {
            System.out.println("Montant insuffisant pour couvrir les frais.");
        } else {
            super.deposer(s - TAUX_OPERATION);
        }
    }

    
    public void retirer(double s) {
        if (s <= 0) {
            System.out.println("Montant invalide.");
        } else {
            super.retirer(s + TAUX_OPERATION);
        }
    }

    
    public String toString() {
        return super.toString() +
               "\nType : Compte Payant" +
               "\nFrais par operation : " + TAUX_OPERATION;
    }
}
