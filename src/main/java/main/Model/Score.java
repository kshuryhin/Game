package main.Model;

public class Score {
    private int TOP1;
    private int TOP2;
    private int TOP3;
    public int getTOP1() {
        return TOP1;
    }

    public int getTOP2() {
        return TOP2;
    }

    public int getTOP3() {
        return TOP3;
    }

    public void setTOP1(int TOP1) {
        this.TOP1 = TOP1;
    }

    public void setTOP2(int TOP2) {
        this.TOP2 = TOP2;
    }

    public void setTOP3(int TOP3) {
        this.TOP3 = TOP3;
    }

    public int checkScore(int score){
        if (score > TOP1){
            TOP3 = TOP2;
            TOP2 = TOP1;
            TOP1 = score;
            return 1;
        } else if(score > TOP2 && score < TOP1){
            TOP3 = TOP2;
            TOP2 = score;
            return 2;
        } else if(score > TOP3 && score < TOP2){
            TOP3 = score;
            return 3;
        }
        return 0;
    }
}
