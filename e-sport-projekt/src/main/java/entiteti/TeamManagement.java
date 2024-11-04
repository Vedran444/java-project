package entiteti;

import exception.TimException;

public sealed interface TeamManagement permits Timovi {

    void formTeam(Igraci igrac) throws TimException;
}
