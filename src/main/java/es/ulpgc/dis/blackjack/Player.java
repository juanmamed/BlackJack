
package es.ulpgc.dis.blackjack;

import java.util.List;

public class Player {
    private final List<Card> bet;

    public Player(List<Card> bet) {
        this.bet = bet;
    }
    
    public List<Card> getBet(){
        return this.bet;
    }
    
    public boolean isWinner(Player crupier){

        int sumBetCrupier = BlackJack.calculateSumOfBet(crupier.getBet());
        int sumBetPlayer = BlackJack.calculateSumOfBet(this.getBet());
        int sum_max = 21;

        if ((sumBetPlayer > sum_max) || BlackJack.isBlackJack(crupier.getBet())){
            return false;
        }

        if ((sumBetCrupier > sum_max) || (sumBetPlayer > sumBetCrupier) || (BlackJack.isBlackJack(this.getBet()))){
            return true;
        }

        return false;
    }

}
