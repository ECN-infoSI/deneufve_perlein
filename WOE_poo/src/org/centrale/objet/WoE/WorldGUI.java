package org.centrale.objet.WoE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer; 

/**
 * Classe représentant l'interface graphique du monde du jeu.
 */
public class WorldGUI extends JFrame {

    private JPanel worldPanel;   // Panneau pour afficher le monde
    private JTextArea infoPanel; // Panneau pour afficher les informations des entités
    private final World world;         // Instance du monde de jeu
    private JTextField inputField; // Champ de texte pour l'entrée du joueur
    
    private int commandesTransmises = 0; 
    private int dx = 0;
    private int dy = 0;

    /**
     * Constructeur de la classe WorldGUI.
     *
     * @param w Instance du monde à afficher
     */
    public WorldGUI(World w) {
        // Initialisation du monde
        world = w;

        // Configuration de la fenêtre principale
        setTitle("World of ECN 1.25");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize(screenSize.width - 400, screenSize.height - 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Création du panneau de la carte du monde
        worldPanel = new JPanel();
        
        worldPanel.setLayout(new GridLayout(world.getTaille(), world.getTaille(), 1, 1));
        worldPanel.setFocusable(true); // Rendre le panneau focalisable
        
        // Ajout du KeyListener pour gérer les événements de clavier
        worldPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e); // Appel de la méthode personnalisée
            }
        });

        // Création du panneau d'information
        infoPanel = new JTextArea();
        infoPanel.setEditable(false);
        infoPanel.setLineWrap(true); // Pour éviter le débordement du texte

        // Champ de texte pour l'entrée de l'utilisateur
        inputField = new JTextField();
        inputField.setLayout(new BorderLayout());
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = inputField.getText();
                try {
                    world.processCommand(userInput);
                } catch (Exception ex) {
                    infoPanel.append("Erreur lors de la prise en compte de la commande : " + ex.getMessage() + "\n");
                    Logger.getLogger(WorldGUI.class.getName()).log(Level.SEVERE, null, ex);
                }

                infoPanel.append(">> " + userInput + "\n" + "votre commande a été prise en compte" + "\n");
                inputField.setText("");
                worldPanel.requestFocusInWindow();  // Redemande le focus au worldPanel

                // Faire défiler automatiquement vers le bas
                JScrollBar verticalScrollBar = ((JScrollPane) infoPanel.getParent().getParent()).getVerticalScrollBar();
                verticalScrollBar.setValue(verticalScrollBar.getMaximum()); // Scroll to bottom
            }
        });

        
        // Ajouter les éléments à la fenêtre
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, worldPanel, new JScrollPane(infoPanel));
        splitPane.setDividerLocation(1000);
        getContentPane().add(splitPane, BorderLayout.CENTER);

        // Bouton pour afficher le monde
        JButton displayButton = new JButton("Afficher le Monde");
        displayButton.addActionListener((ActionEvent e) -> {
            afficherMonde(); // Afficher le monde quand le bouton est cliqué
            worldPanel.requestFocusInWindow(); // Demander le focus au panneau après l'affichage
        });
        getContentPane().add(displayButton, BorderLayout.NORTH);
        getContentPane().add(inputField, BorderLayout.SOUTH); // Ajouter le champ de texte en bas

        // Ajouter le bouton de sauvegarde
        JButton saveButton = new JButton("Sauvegarder la partie");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomSauvegarde = JOptionPane.showInputDialog("Entrez le nom de la sauvegarde (avec .txt) :");
                if (nomSauvegarde != null && !nomSauvegarde.trim().isEmpty()) {
                    world.save(nomSauvegarde); // Appeler la méthode save
                    infoPanel.append("Sauvegarde effectuée dans " + nomSauvegarde + "\n");
                } else {
                    infoPanel.append("Nom de sauvegarde invalide.\n");
                }
            }
        });
        // Ajouter le bouton de sauvegarde au panneau
        inputField.add(saveButton, BorderLayout.EAST); // Ajouter le bouton à l'est du panneau

        // Ajouter le panneau d'entrée au bas de la fenêtre
        getContentPane().add(inputField, BorderLayout.SOUTH);
        setVisible(true);
        worldPanel.requestFocusInWindow(); // Demander le focus au panneau à l'initialisation
        
        // Créer un flux de sortie temporaire pour capturer la sortie console
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos); // Créer un PrintStream à partir du ByteArrayOutputStream
        System.setOut(ps); // Rediriger la sortie

        // Capturer les sorties pour l'affichage
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(500); // Mettre à jour toutes les 500 ms
                    infoPanel.setText(baos.toString()); // Mettre à jour le JTextArea avec les informations
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * Méthode qui gère les événements de touches pour le déplacement.
     *
     * @param e Événement de touche
     */
    private void handleKeyPress(KeyEvent e) {
        Joueur joueur = world.getJoueur();  // Récupère le joueur du monde
        if (joueur.isEnDeplacement()) {  // Si le joueur est en mode déplacement
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    dx = -1;
                    commandesTransmises++;
                    break;
                case KeyEvent.VK_DOWN:
                    dx = 1;
                    commandesTransmises++;
                    break;
                case KeyEvent.VK_LEFT:
                    dy = -1;
                    commandesTransmises++;
                    break;
                case KeyEvent.VK_RIGHT:
                    dy = 1;
                    commandesTransmises++;
                    break;
            }
            if (commandesTransmises >= 2) { 
                boolean deplace = joueur.getPersoChoisi().deplace(world, dx, dy);
                if (deplace) {
                    System.out.println("Vous vous êtes déplacé en position: " );
                    joueur.getPersoChoisi().getPos().affiche();
                    commandesTransmises = 0;
                    dx = 0;
                    dy = 0;
                    joueur.setEnDeplacement(false);
                } else {
                    System.out.println("Déplacement impossible, entrez une direction valide.");
                }
                
            }
        }
    }

    /**
     * Méthode pour afficher le monde et ses entités.
     */
    public void afficherMonde() {
        worldPanel.removeAll(); // Supprimer les composants précédents
        LinkedList<Personnage> personnages = world.getPersonnages();
        LinkedList<Monstre> monstres = world.getMonstres();
        LinkedList<Objet> objets = world.getObjets();

        // Charger les images avec redimensionnement
        ImageIcon joueurIcon = new ImageIcon(new ImageIcon("./resources/joueur.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        ImageIcon personnageIcon = new ImageIcon(new ImageIcon("./resources/personnage.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        ImageIcon potionIcon = new ImageIcon(new ImageIcon("./resources/potion.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        ImageIcon herbeIcon = new ImageIcon(new ImageIcon("./resources/herbe.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        ImageIcon epeeIcon = new ImageIcon(new ImageIcon("./resources/epee.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        ImageIcon loupIcon = new ImageIcon(new ImageIcon("./resources/loup.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        ImageIcon lapinIcon = new ImageIcon(new ImageIcon("./resources/lapin.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        ImageIcon nourritureIcon = new ImageIcon(new ImageIcon("./resources/nourriture.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        ImageIcon nuageIcon = new ImageIcon(new ImageIcon("./resources/nuage.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));

    // Créer des boutons pour représenter chaque case de la grille
        for (int i = 0; i < world.getTaille(); i++) {
            for (int j = 0; j < world.getTaille(); j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(50, 50)); // Taille préférée pour le bouton
                button.setMinimumSize(new Dimension(50, 50)); // Taille minimale
                button.setMaximumSize(new Dimension(50, 50)); // Taille maximale

                Point2D point = new Point2D(i, j);
                
                if (!world.lose() && !world.win()){
                    // Vérifier si un personnage, un monstre ou un objet est à cette position
                    boolean entityAdded = false;

                    // Si le joueur est sur cette case
                    if (world.getJoueur().getPersoChoisi().getPos().equals(point)) {
                        button.setIcon(joueurIcon); // Image pour le joueur
                        button.addActionListener(e -> afficherInfo(world.getJoueur().getPersoChoisi()));
                        entityAdded = true;
                    }

                    // Si ce n'est pas le joueur, vérifier les autres entités
                    if (!entityAdded) {
                        for (Personnage p : personnages) {
                            if (p.getPos().equals(point)) {
                                button.setIcon(personnageIcon); // Image pour un personnage
                                button.addActionListener(e -> afficherInfo(p));
                                entityAdded = true;
                                break;
                            }
                        }
                    }

                    if (!entityAdded) {
                        for (Monstre m : monstres) {
                            if (m.getPos().equals(point) && (m instanceof Lapin)) {
                                button.setIcon(lapinIcon); // Image pour un monstre
                                button.addActionListener(e -> afficherInfo(m));
                                entityAdded = true;
                                break;
                            }
                            if (m.getPos().equals(point) && (m instanceof Loup)) {
                                button.setIcon(loupIcon); // Image pour un monstre
                                button.addActionListener(e -> afficherInfo(m));
                                entityAdded = true;
                                break;
                            }
                        }
                    }

                    if (!entityAdded) {
                        for (Objet o : objets) {
                            if (o.getPos().equals(point)) {
                                if (o instanceof Epee){
                                    button.setIcon(epeeIcon); // Image pour un objet
                                }
                                else if (o instanceof PotionSoin){
                                    button.setIcon(potionIcon); // Image pour un objet
                                }
                                else if (o instanceof Nourriture){
                                    button.setIcon(nourritureIcon); // Image pour un objet
                                }
                                else if (o instanceof NuageToxique){
                                    button.setIcon(nuageIcon); // Image pour un objet
                                }
                                button.addActionListener(e -> afficherInfo(o));
                                entityAdded = true;
                                break;
                            }
                        }
                    }

                    if (!entityAdded) {
                        button.setIcon(herbeIcon); // Image pour une case vide
                    }
                }
                if (world.win()){
                    button.setBackground(Color.YELLOW);
                }
                if (world.lose()){
                    button.setBackground(Color.RED);
                }
                // Ajouter le bouton au panneau du monde
                worldPanel.add(button);
            }
        }

        worldPanel.revalidate(); // Rafraîchir le panneau
        worldPanel.repaint();    // Repeindre le panneau
    }

    /**
     * Méthode pour afficher les informations d'une entité.
     *
     * @param entity L'entité dont on veut afficher les informations
     */
    private void afficherInfo(Object entity) {
        // Appeler la méthode affiche() de l'entité
        if (entity instanceof Personnage ) {
            Personnage personnage = (Personnage) entity;
            personnage.affiche();  // Afficher les informations du personnage
        } else if (entity instanceof Monstre) {
            Monstre monstre = (Monstre) entity;
            monstre.affiche(); // Afficher les informations du monstre
        } else if (entity instanceof Objet) {
            Objet objet = (Objet) entity;
            objet.affiche(); // Afficher les informations de l'objet
        }

        // Récupérer le texte capturé dans la sortie console
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String info = baos.toString(); // Convertir le contenu capturé en chaîne

        // Afficher les informations dans le panneau d'information
        infoPanel.append(info + "\n"); // Ajouter l'information au JTextArea

        // Faire défiler automatiquement vers le bas
        JScrollBar verticalScrollBar = ((JScrollPane) infoPanel.getParent().getParent()).getVerticalScrollBar();
        verticalScrollBar.setValue(verticalScrollBar.getMaximum()); // Scroll to bottom
    }
}
