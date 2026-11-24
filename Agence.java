
public class Agence {

    private String numero;
    private String adresse;

    private Client[] lesclients;
    private Compte[] lescomptes;

    public static final int NB_MAX_COMPTES = 80;
    public static final int NB_MAX_CLIENTS = 20;

    private static int nbAgences = 0;

    private int nbClients = 0;
    private int nbComptes = 0;

    public Agence(String adresse) {

        this.numero = "Agence:" + (++nbAgences);
        this.adresse = adresse;

        this.lesclients = new Client[NB_MAX_CLIENTS];
        this.lescomptes = new Compte[NB_MAX_COMPTES];
    }

    public String getNumero() {
        return numero;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getNbClients() {
        return nbClients;
    }

    public int getNbComptes() {
        return nbComptes;
    }

    public Client getClient(int numClient) {
        if (numClient >= 0 && numClient < nbClients) {
            return lesclients[numClient];
        }

        return null;
    }

    public Compte getCompte(int numCompte) {
        if (numCompte >= 0 && numCompte < nbComptes) {
            return lescomptes[numCompte];
        }

        return null;
    }

    public void addClient(Client c) {
        if (c == null) {
            System.out.println("Client invalide.");
            return;
        }

        if (nbClients < NB_MAX_CLIENTS) {
            lesclients[nbClients++] = c;
        } else {
            System.out.println("La liste des clients est pleine.");
        }
    }

    public void addCompte(Compte c) {
        if (c == null) {
            System.out.println("Compte invalide.");
            return;
        }

        if (nbComptes < NB_MAX_COMPTES) {
            lescomptes[nbComptes++] = c;
        } else {
            System.out.println("La liste des comptes est pleine.");
        }
    }

    
    public String toString() {
        return "Numero : " + numero +
               "\nAdresse : " + adresse;
    }
}
