package bandeau;

public class ExampleScenario {

    /**
     * "Programme principal" : point d'entrée d'exécution
     *
     * @param args les "arguments de ligne de commande", transmis au lancement du programme
     */
    public static void main(String[] args) {
        String message;
        if (args.length > 0) // Il y a au minimum 1 paramètre
        {
            message = args[0]; // premier paramètre
        } else {
            message = "Démonstration du bandeau";
        }

        ExampleScenario instance = new ExampleScenario();
        instance.exemple(message);
    }

    public void exemple(String message) {
        // On cree un scenario
        Scenario s = new Scenario();
        // On lui ajoute des effets
        //s.addEffect(new FontEnumerator(10), 1);
        s.addEffect(new RandomEffect("Jeu du pendu", 700), 1);
        s.addEffect(new TeleType("Affichage caractère par caractère", 100), 1);
        s.addEffect(new Blink("Clignote 10 fois", 100), 10);
        s.addEffect(new Zoom("Zoomer", 50), 1);
        s.addEffect(new FontEnumerator(10), 1);
        s.addEffect(new Rainbow("C'est beau", 30), 1);
        s.addEffect(new Rotate("2 fois à droite", 180, 4000, true), 2);
        s.addEffect(new Rotate("2 fois à gauche", 180, 4000, false), 2);
        // On cree le bandeau
        UnderBandeau b = new UnderBandeau();
        b.setMessage(message);
        b.sleep(2000);
        // On joue le scenario sur le bandeau
        s.playOn(b);
        b.close();
    }

}
