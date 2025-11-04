package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;
import java.beans.PropertyChangeEvent;

public class CompteARebours implements TimerChangeListener {

    int valeur;
    TimerService timerService;
    String name;

    public CompteARebours(String name, TimerService timerService, int valeurInitiale) {
        this.name = name;
        this.timerService = timerService;
        this.valeur = valeurInitiale;
        timerService.addTimeChangeListener(this);
        System.out.println("Compte à rebours " + name + " initialisé à " + valeur);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(TimerChangeListener.SECONDE_PROP)) {
            valeur--;
            if (valeur >= 0) {
                System.out.println(name + " : " + valeur);
            }
            if (valeur == 0) {
                timerService.removeTimeChangeListener(this);
                System.out.println(name + " terminé !");
            }
        }
    }
}
