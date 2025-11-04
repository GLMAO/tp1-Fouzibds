package org.emp.gl.core.launcher;
import org.emp.gl.clients.HorlogeGraphique;
import org.emp.gl.clients.Horloge ;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerService;
import org.emp.gl.clients.CompteARebours;

/* Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        /*TimerService service = new DummyTimeServiceImpl();

        new Horloge("Horloge 1", service);
        new Horloge("Horloge 2", service);
        new Horloge("Horloge 3", service);
        new CompteARebours("C1", service, 5);
        for (int i = 0; i < 10; i++) {
            int val = 10 + (int)(Math.random() * 10);
            new CompteARebours("C" + (i + 2), service, val);
        }*/
        TimerService service = new DummyTimeServiceImpl();

        // Lance une horloge graphique
        new HorlogeGraphique(service);

    }

    /*private static void testDuTimeService() {
        Horloge horloge = new Horloge("Num 1") ;
    }*/

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
