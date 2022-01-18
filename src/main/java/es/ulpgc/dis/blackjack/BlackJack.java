/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.dis.blackjack;

import java.util.ArrayList;
import java.util.List;

public class BlackJack {
    public BlackJack() {

    }
    
    
    public static boolean isBlackJack(List<Card> bet){
        return calculateSumOfBet(bet) == 21 && bet.size() == 2;

    }
    
    public static int calculateSumOfBet(List<Card> bet) {
        int sum_max = 21;
        int sum = 0;
        int numberAce = 0;
        int dif = 0;

        for (Card card : bet) {
            sum += card.getValue();
            if (card instanceof Ace) {
                numberAce++;
                if (dif == 0) dif = card.getValue() - ((Ace) card).secondValue();
            }
        }

        while ((sum > sum_max) && (numberAce > 0)) {
            sum -= dif;
            numberAce--;
        }
        return sum;
    }

    public static List<Player> getWinners(Player player1, Player player2, Player player3, Player crupier, List<Card> deck){
        while (BlackJack.calculateSumOfBet(crupier.getBet()) < 17){
            crupier.getBet().add(deck.get(0));
            deck.remove(0);
        }
        List<Player> list = new ArrayList<>();
        if (!BlackJack.isBlackJack(crupier.getBet())) {
            if (player1.isWinner(crupier)){
                list.add(player1);
            }
            if (player2.isWinner(crupier)){
                list.add(player2);
            }
            if (player3.isWinner(crupier)){
                list.add(player3);
            }
        }
        return list;
    }
    
}
