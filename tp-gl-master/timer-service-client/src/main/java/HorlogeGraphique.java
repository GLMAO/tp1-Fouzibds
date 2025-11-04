package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

public class HorlogeGraphique extends JFrame implements TimerChangeListener {

    private final JLabel labelHeure;
    private final TimerService timerService;

    public HorlogeGraphique(TimerService timerService) {
        this.timerService = timerService;
        timerService.addTimeChangeListener(this);

        // --- Configuration de la fenêtre ---
        setTitle("Horloge Graphique");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // --- Création du label pour afficher l'heure ---
        labelHeure = new JLabel("", SwingConstants.CENTER);
        labelHeure.setFont(new Font("Digital-7", Font.BOLD, 40));
        labelHeure.setForeground(Color.BLUE);

        // --- Ajout du label à la fenêtre ---
        add(labelHeure);

        setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(TimerChangeListener.SECONDE_PROP)) {
            SwingUtilities.invokeLater(() -> {
                labelHeure.setText(
                        String.format("%02d:%02d:%02d",
                                timerService.getHeures(),
                                timerService.getMinutes(),
                                timerService.getSecondes())
                );
            });
        }
    }
}
