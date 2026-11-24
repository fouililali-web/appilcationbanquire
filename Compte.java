
public class Compte {

    private String code;
    protected double solde;
    protected Agence lagence;
    protected Client proprietaire;

    public Compte(Client cl, Agence lagence) {
        this.lagence = lagence;
        this.proprietaire = cl;
        this.solde = 0;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getSolde() {
        return solde;
    }

    public void deposer(double s) {
        if (s > 0) {
            solde += s;
            System.out.println("Depot effectue avec succes.");
        } else {
            System.out.println("Montant invalide.");
        }
    }

    public void retirer(double s) {
        if (s <= 0) {
            System.out.println("Montant invalide.");
        } else if (s <= solde) {
            solde -= s;
            System.out.println("Retrait effectue avec succes.");
        } else {
            System.out.println("Solde insuffisant.");
        }
    }

    
    public String toString() {
        return "Code : " + code +
               "\nSolde : " + solde +
               "\nAgence : " + lagence.getNumero() +
               "\nProprietaire : " + proprietaire.getCode();
    }
}
