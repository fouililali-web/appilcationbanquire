

public class ApplicationBancaire {

    public static void main(String[] args) {

        // Creation de l'agence
        Agence ag = new Agence("Agadir");

        // Creation des clients
        Client[] clients = {
            new Client("Ayoub", "Ali", "Agadir", ag),
            new Client("Ahmed", "Amine", "Casa", ag),
            new Client("Youssef", "Omar", "Rabat", ag),
            new Client("Hamza", "Karim", "Marrakech", ag)
        };

        // Ajout des clients a l'agence
        for (int i = 0; i < clients.length; i++) {
            ag.addClient(clients[i]);
        }

        // Creation des comptes
        Compte c1 = new CompteEpargne(clients[0], ag);
        Compte c2 = new ComptePayant(clients[1], ag);
        Compte c3 = new ComptePayant(clients[2], ag);
        Compte c4 = new ComptePayant(clients[2], ag);
        Compte c5 = new CompteEpargne(clients[3], ag);
        Compte c6 = new ComptePayant(clients[3], ag);

        // Ajout des comptes aux clients et a l'agence
        Compte[] comptes = {c1, c2, c3, c4, c5, c6};

        for (int i = 0; i < comptes.length; i++) {
            comptes[i].getClass(); // Type du compte
            ag.addCompte(comptes[i]);
        }

        clients[0].addCompte(c1);
        clients[1].addCompte(c2);
        clients[2].addCompte(c3);
        clients[2].addCompte(c4);
        clients[3].addCompte(c5);
        clients[3].addCompte(c6);

        // Depot
        clients[0].deposer(0, 200);
        clients[1].deposer(0, 300);

        // Retrait
        clients[1].retirer(0, 100);

        // Calcul des interets
        for (int i = 0; i < ag.getNbComptes(); i++) {
            if (ag.getCompte(i) instanceof CompteEpargne) {
                CompteEpargne ce =
                    (CompteEpargne) ag.getCompte(i);

                ce.calculInteret();
            }
        }

        // Affichage des clients et leurs comptes
        System.out.println("========== CLIENTS ==========");

        for (int i = 0; i < ag.getNbClients(); i++) {

            Client client = ag.getClient(i);

            System.out.println("\n" + client);

            for (int j = 0; j < client.getNbComptes(); j++) {
                System.out.println("\n" + client.getCompte(j));
            }
        }

        // Affichage des statistiques
        System.out.println("\n========== STATISTIQUES ==========");

        System.out.println("Nombre de clients : " + ag.getNbClients());
        System.out.println("Nombre de comptes : " + ag.getNbComptes());

        // Comptes epargne
        System.out.println("\n========== COMPTES EPARGNE ==========");

        for (int i = 0; i < ag.getNbComptes(); i++) {
            Compte c = ag.getCompte(i);

            if (c instanceof CompteEpargne) {
                System.out.println(c);
            }
        }

        // Comptes payants
        System.out.println("\n========== COMPTES PAYANTS ==========");

        for (int i = 0; i < ag.getNbComptes(); i++) {
            Compte c = ag.getCompte(i);

            if (c instanceof ComptePayant) {
                System.out.println(c);
            }
        }
    }
}
