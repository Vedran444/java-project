package Thread;

import entiteti.Igraci;
import utils.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Set;

public class DatabaseThread{

    private volatile boolean running = false;

    public synchronized void SavePlayer(Set<Igraci> igraci){

        while(running){

            try{
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        running=true;

        Database.savePlayer(igraci);
        running=false;

        notifyAll();
    }

    public synchronized Igraci getOldestPlayer() {

        while(running){

            try{
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        running=true;

        Igraci oldest= Database.getOldestPlayer();
        running=false;

        notifyAll();

        return oldest;
    }

}
