
public class Client {

    private String code;
    private String nom;
    private String prenom;
    private String adresse;
    private Agence monagence;
    private Compte[] mescomptes;

    public static final int NB_MAX_COMPTES = 4;

    private int nombrecompte = 0;
    private static int nbClients = 0;

    public Client(String nom, String prenom,
                  String adresse, Agence agence) {

        this.code = "Client:" + (++nbClients);
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.monagence = agence;

        this.mescomptes = new Compte[NB_MAX_COMPTES];
    }

    public String getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public int getNbComptes() {
        return nombrecompte;
    }

    public Compte getCompte(int numcompte) {
        if (numcompte >= 0 && numcompte < nombrecompte) {
            return mescomptes[numcompte];
        }

        return null;
    }

    public void addCompte(Compte c) {
        if (c == null) {
            System.out.println("Compte invalide.");
            return;
        }

        if (nombrecompte < NB_MAX_COMPTES) {
            mescomptes[nombrecompte++] = c;
        } else {
            System.out.println("La liste des comptes est pleine.");
        }
    }

    public boolean deposer(int numcompte, double s) {
        Compte c = getCompte(numcompte);

        if (c != null) {
            c.deposer(s);
            return true;
        }

        return false;
    }

    public boolean retirer(int numcompte, double s) {
        Compte c = getCompte(numcompte);

        if (c != null) {
            c.retirer(s);
            return true;
        }

        return false;
    }

    
    public String toString() {
        return "Client : " + code +
               "\nNom : " + nom +
               "\nPrenom : " + prenom +
               "\nAdresse : " + adresse +
               "\nAgence : " + monagence.getNumero();
    }
}
