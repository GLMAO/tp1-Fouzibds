package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;
import java.beans.PropertyChangeEvent;

public class Horloge implements TimerChangeListener {

    String name;
    TimerService timerService;

    public Horloge(String name, TimerService timerService) {
        this.name = name;
        this.timerService = timerService;
        timerService.addTimeChangeListener(this);
        System.out.println("Horloge " + name + " initialisée !");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(TimerChangeListener.SECONDE_PROP)) {
            afficherHeure();
        }
    }

    public void afficherHeure() {
        System.out.println(name + " affiche " +
                timerService.getHeures() + ":" +
                timerService.getMinutes() + ":" +
                timerService.getSecondes());
    }
}
