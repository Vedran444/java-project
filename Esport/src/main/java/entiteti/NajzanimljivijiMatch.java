package entiteti;


import java.util.Set;

public class NajzanimljivijiMatch <T extends Match>{

    private Set<T> mecevi;

    public NajzanimljivijiMatch(Set<T> mecevi) {
        this.mecevi = mecevi;
    }


    public Par<T, Integer> FindMatcWithMinimumDifference() {

        T najzanimljivijiMatch = null;
        int najmanjaRazlika = Integer.MAX_VALUE;

        for (T match : mecevi) {
            int razlika = Math.abs(match.getRezultat().t1_score() - match.getRezultat().t2_score());
            if (najzanimljivijiMatch == null || razlika < najmanjaRazlika) {
                najzanimljivijiMatch = match;
                najmanjaRazlika = razlika;
            }
        }

        return new Par<>(najzanimljivijiMatch, najmanjaRazlika);
    }

}
