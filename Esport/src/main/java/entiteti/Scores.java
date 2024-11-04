package entiteti;

import java.util.Objects;

public record Scores(int t1_score, int t2_score) {


    public String getPobjednickiTim(Timovi tim1, Timovi tim2) {

        if (t1_score > t2_score) {
            return tim1.getTeamName();
        }
        if (t1_score < t2_score) {
            return tim2.getTeamName();
        }
        throw new IllegalArgumentException("Rezultat ne moze biti nerijesen!");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scores scores = (Scores) o;
        return t1_score == scores.t1_score && t2_score == scores.t2_score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(t1_score, t2_score);
    }

    @Override
    public String toString() {
        return "Scores{" +
                "t1_score=" + t1_score +
                ", t2_score=" + t2_score +
                '}';
    }

}
