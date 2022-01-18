package es.ulpgc.dis.blackjack;

public class PipCard extends Card {
    private int value;
    public PipCard(int value){
        super();
        int lim_inf = 2;
        int lim_sup = 10;
        if(value < lim_inf) {
            this.value = 2;
        }
        else if (value > lim_sup){
            this.value = 10;
        } else {
            this.value=value;
        }
    }

    @Override
    public int getValue(){
        return this.value;
    }
}
