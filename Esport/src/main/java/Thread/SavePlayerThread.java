package Thread;

import entiteti.Igraci;

import java.util.List;
import java.util.Set;

public class SavePlayerThread extends DatabaseThread implements Runnable{


    private Set<Igraci> igraci;
    public SavePlayerThread(Set<Igraci> igraci){
        this.igraci=igraci;

    }

    @Override
    public void run() {

        super.SavePlayer(igraci);
    }


}
