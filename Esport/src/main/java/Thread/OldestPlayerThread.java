package Thread;

import com.example.esport.LoginApplication;
import entiteti.Igraci;
import javafx.application.Platform;
import utils.Database;

import java.util.Optional;

public class OldestPlayerThread extends DatabaseThread implements Runnable {

    @Override
    public void run() {
        while (true) {


            Optional<Igraci> igrac = Optional.ofNullable(super.getOldestPlayer());

            if (igrac.isPresent()) {

                Igraci najstariji = igrac.get();
                Platform.runLater(() ->
                        LoginApplication.getMainstage().setTitle("najstariji igrac: " + najstariji.getName()
                                + " " + najstariji.getSurname() + " " + najstariji.getNationality() + " " + najstariji.getAge())
                );
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
