package org.centrale.objet.WoE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

/**
 * Classe représentant l'interface graphique du monde du jeu.
 */
public class WorldGUI extends JFrame {

    private JPanel worldPanel;   // Panneau pour afficher le monde
    private JTextArea infoPanel; // Panneau pour afficher les informations des entités
    private World world;         // Instance du monde de jeu

    /**
     * Constructeur de la classe WorldGUI.
     *
     * @param w Instance du monde à afficher
     */
    public WorldGUI(World w) {
        // Initialisation du monde
        world = w;

        // Configuration de la fenêtre principale
        setTitle("World of ECN 1.10");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Création du panneau de la carte du monde
        worldPanel = new JPanel();
        worldPanel.setLayout(new GridLayout(world.getTaille(), world.getTaille()));

        // Création du panneau d'information
        infoPanel = new JTextArea();
        infoPanel.setEditable(false);
        infoPanel.setLineWrap(true); // Pour éviter le débordement du texte

        // Ajouter les éléments à la fenêtre
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, worldPanel, new JScrollPane(infoPanel));
        splitPane.setDividerLocation(600);
        getContentPane().add(splitPane);

        // Bouton pour afficher le monde
        JButton displayButton = new JButton("Afficher le Monde");
        displayButton.addActionListener((ActionEvent e) -> {
            afficherMonde(); // Afficher le monde quand le bouton est cliqué
        });

        getContentPane().add(displayButton, BorderLayout.SOUTH);
    }

    /**
     * Méthode pour afficher le monde et ses entités.
     */
    public void afficherMonde() {
        worldPanel.removeAll(); // Supprimer les composants précédents
        LinkedList<Personnage> personnages = world.getPersonnages();
        LinkedList<Monstre> monstres = world.getMonstres();
        LinkedList<Objet> objets = world.getObjets();

        // Créer des boutons pour représenter chaque case de la grille
        for (int i = 0; i < world.getTaille(); i++) {
            for (int j = 0; j < world.getTaille(); j++) {
                JButton button = new JButton();
                Point2D point = new Point2D(i, j);

                // Vérifier si un personnage, un monstre ou un objet est à cette position
                boolean entityAdded = false;
                for (Personnage p : personnages) {
                    if (p.getPos().equals(point)) {
                        button.setBackground(Color.BLUE); // Représente un personnage
                        button.addActionListener(e -> afficherInfo(p));
                        entityAdded = true;
                        break;
                    }
                }
                if (!entityAdded) {
                    for (Monstre m : monstres) {
                        if (m.getPos().equals(point)) {
                            button.setBackground(Color.RED); // Représente un monstre
                            button.addActionListener(e -> afficherInfo(m));
                            entityAdded = true;
                            break;
                        }
                    }
                }
                if (!entityAdded) {
                    for (Objet o : objets) {
                        if (o.getPos().equals(point)) {
                            button.setBackground(Color.GREEN); // Représente un objet
                            button.addActionListener(e -> afficherInfo(o));
                            break;
                        }
                    }
                }
                if (!entityAdded) {
                    if (world.getPersoJoueur().equals(point)){
                        button.setBackground(Color.YELLOW); // Représente le joueur
                        button.addActionListener(e -> afficherInfo(world.getPersoJoueur()));
                        break;
                    }
                }
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
        // Créer un flux de sortie temporaire pour capturer la sortie console
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos); // Créer un PrintStream à partir du ByteArrayOutputStream

        // Sauvegarder la sortie standard actuelle
        PrintStream oldOut = System.out;

        try {
            // Rediriger la sortie vers notre PrintStream temporaire
            System.setOut(ps);

            // Appeler la méthode affiche() de l'entité
            if (entity instanceof Personnage) {
                ((Personnage) entity).affiche();  // Afficher les informations du personnage
            } else if (entity instanceof Monstre) {
                ((Monstre) entity).affiche(); // Afficher les informations du monstre
            } else if (entity instanceof Objet) {
                ((Objet) entity).affiche(); // Afficher les informations de l'objet
            }

            // Récupérer le texte capturé dans la sortie console
            String info = baos.toString(); // Convertir le contenu capturé en chaîne
            
            // Afficher les informations dans le panneau d'information
            infoPanel.setText(info); // Mettre à jour le JTextArea avec les informations

        } finally {
            // Rétablir la sortie standard
            System.setOut(oldOut);
        }
    }
}
