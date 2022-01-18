import es.ulpgc.dis.blackjack.*;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BlackJackTest {
    @Test
    public void A_player_with_BlackJack(){
        List<Card> deck = new ArrayList<Card>();
        deck.add(new PipCard(5));
        deck.add(new PipCard(4));
        deck.add(new CardWithValue10());
        deck.add(new PipCard(2));

        List<Card> bet_p1 = new ArrayList<Card>();
        bet_p1.add(new CardWithValue10());
        bet_p1.add(new Ace());
        Player p1 = new Player(bet_p1);
        assert (BlackJack.isBlackJack(bet_p1));

        List<Card> bet_p2 = new ArrayList<Card>();
        Player p2 = new Player(bet_p2);
        bet_p2.add(new CardWithValue10());
        bet_p2.add(new PipCard(5));
        bet_p2.add(new PipCard(6));
        assertEquals (BlackJack.calculateSumOfBet(bet_p2), 21);

        List<Card> bet_p3 = new ArrayList<Card>();
        bet_p3.add(new PipCard(3));
        bet_p3.add(new PipCard(6));
        bet_p3.add(new Ace());
        bet_p3.add(new PipCard(3));
        bet_p3.add(new Ace());
        bet_p3.add(new CardWithValue10());
        Player p3 = new Player(bet_p3);
        assertEquals (24, BlackJack.calculateSumOfBet(bet_p3));

        List<Card> bet_croupier = new ArrayList<Card>();
        bet_croupier.add(new PipCard(9));
        bet_croupier.add(new PipCard(7));
        Player croupier = new Player(bet_croupier);
        assertEquals (16, BlackJack.calculateSumOfBet(bet_croupier));

        List<Player> test_winners = BlackJack.getWinners(p1, p2, p3, croupier, deck);
        List<Player> real_winners = new ArrayList<>();
        assertEquals (21, BlackJack.calculateSumOfBet(bet_croupier));
        real_winners.add(p1);

        assert (real_winners.equals(test_winners));

    }

    @Test
    public void Two_players_win(){
        List<Card> deck = new ArrayList<Card>();
        deck.add(new Ace());
        deck.add(new PipCard(3));
        deck.add(new CardWithValue10());
        deck.add(new PipCard(2));

        List<Card> bet_p1 = new ArrayList<Card>();
        bet_p1.add(new PipCard(10));
        bet_p1.add(new CardWithValue10());
        Player p1 = new Player(bet_p1);
        assertEquals (20, BlackJack.calculateSumOfBet(bet_p1));

        List<Card> bet_p2 = new ArrayList<Card>();
        Player p2 = new Player(bet_p2);
        bet_p2.add(new PipCard(10));
        bet_p2.add(new PipCard(2));
        bet_p2.add(new PipCard(6));
        assertEquals (18, BlackJack.calculateSumOfBet(bet_p2));

        List<Card> bet_p3 = new ArrayList<Card>();
        bet_p3.add(new PipCard(8));
        bet_p3.add(new PipCard(8));
        bet_p3.add(new PipCard(5));
        Player p3 = new Player(bet_p3);
        assertEquals (21, BlackJack.calculateSumOfBet(bet_p3));

        List<Card> bet_croupier = new ArrayList<Card>();
        bet_croupier.add(new PipCard(5));
        bet_croupier.add(new PipCard(10));
        Player croupier = new Player(bet_croupier);
        assertEquals (15, BlackJack.calculateSumOfBet(bet_croupier));

        List<Player> test_winners = BlackJack.getWinners(p1, p2, p3, croupier, deck);
        List<Player> real_winners = new ArrayList<>();
        real_winners.add(p1);
        real_winners.add(p3);
        assertEquals (19, BlackJack.calculateSumOfBet(bet_croupier));
        assert (real_winners.equals(test_winners));
    }

    @Test
    public void Croupier_with_BlackJack(){
        List<Card> deck = new ArrayList<Card>();
        deck.add(new Ace());
        deck.add(new PipCard(3));
        deck.add(new CardWithValue10());
        deck.add(new PipCard(10));

        List<Card> bet_p1 = new ArrayList<Card>();
        bet_p1.add(new CardWithValue10());
        bet_p1.add(new Ace());
        Player p1 = new Player(bet_p1);
        assert (BlackJack.isBlackJack(bet_p1));
        assertEquals (21, BlackJack.calculateSumOfBet(bet_p1));

        List<Card> bet_p2 = new ArrayList<Card>();
        Player p2 = new Player(bet_p2);
        bet_p2.add(new PipCard(7));
        bet_p2.add(new PipCard(2));
        bet_p2.add(new PipCard(6));
        bet_p2.add(new PipCard(8));
        assertEquals (23, BlackJack.calculateSumOfBet(bet_p2));

        List<Card> bet_p3 = new ArrayList<Card>();
        bet_p3.add(new PipCard(8));
        bet_p3.add(new PipCard(8));
        bet_p3.add(new PipCard(5));
        Player p3 = new Player(bet_p3);
        assertEquals (21, BlackJack.calculateSumOfBet(bet_p1));

        List<Card> bet_croupier = new ArrayList<Card>();
        bet_croupier.add(new PipCard(10));
        Player croupier = new Player(bet_croupier);
        assertEquals (10, BlackJack.calculateSumOfBet(bet_croupier));

        List<Player> test_winners = BlackJack.getWinners(p1, p2, p3, croupier, deck);
        assertEquals (21, BlackJack.calculateSumOfBet(bet_croupier));
        List<Player> real_winners = new ArrayList<>();
        assert (real_winners.equals(test_winners));
    }

    @Test
    public void Draw_between_a_player_and_the_croupier(){
        List<Card> deck = new ArrayList<Card>();
        deck.add(new PipCard(3));
        deck.add(new PipCard(7));
        deck.add(new Ace());
        deck.add(new PipCard(10));

        List<Card> bet_p1 = new ArrayList<Card>();
        bet_p1.add(new CardWithValue10());
        bet_p1.add(new PipCard(7));
        Player p1 = new Player(bet_p1);
        assertEquals (17, BlackJack.calculateSumOfBet(bet_p1));

        List<Card> bet_p2 = new ArrayList<Card>();
        bet_p2.add(new PipCard(7));
        bet_p2.add(new PipCard(3));
        bet_p2.add(new PipCard(2));
        Player p2 = new Player(bet_p2);
        assertEquals (12, BlackJack.calculateSumOfBet(bet_p2));

        List<Card> bet_p3 = new ArrayList<Card>();
        bet_p3.add(new PipCard(8));
        bet_p3.add(new PipCard(4));
        bet_p3.add(new PipCard(2));
        Player p3 = new Player(bet_p3);
        assertEquals (14, BlackJack.calculateSumOfBet(bet_p3));

        List<Card> bet_croupier = new ArrayList<Card>();
        bet_croupier.add(new PipCard(10));
        bet_croupier.add(new PipCard(4));
        Player croupier = new Player(bet_croupier);
        assertEquals (14, BlackJack.calculateSumOfBet(bet_croupier));

        List<Player> test_winners = BlackJack.getWinners(p1, p2, p3, croupier, deck);
        assertEquals (17, BlackJack.calculateSumOfBet(bet_croupier));
        List<Player> real_winners = new ArrayList<>();
        assert (real_winners.equals(test_winners));
    }

    @Test
    public void Win_all_players(){
        List<Card> deck = new ArrayList<Card>();
        deck.add(new PipCard(3));
        deck.add(new PipCard(2));
        deck.add(new CardWithValue10());
        deck.add(new PipCard(10));

        List<Card> bet_p1 = new ArrayList<Card>();
        bet_p1.add(new CardWithValue10());
        bet_p1.add(new PipCard(10));
        Player p1 = new Player(bet_p1);
        assertEquals (20, BlackJack.calculateSumOfBet(bet_p1));

        List<Card> bet_p2 = new ArrayList<Card>();
        bet_p2.add(new PipCard(7));
        bet_p2.add(new PipCard(3));
        bet_p2.add(new PipCard(8));
        Player p2 = new Player(bet_p2);
        assertEquals (18, BlackJack.calculateSumOfBet(bet_p2));

        List<Card> bet_p3 = new ArrayList<Card>();
        bet_p3.add(new PipCard(8));
        bet_p3.add(new PipCard(2));
        bet_p3.add(new Ace());
        Player p3 = new Player(bet_p3);
        assertEquals (21, BlackJack.calculateSumOfBet(bet_p3));

        List<Card> bet_croupier = new ArrayList<Card>();
        bet_croupier.add(new PipCard(10));
        bet_croupier.add(new PipCard(4));
        Player croupier = new Player(bet_croupier);
        assertEquals (14, BlackJack.calculateSumOfBet(bet_croupier));

        List<Player> test_winners = BlackJack.getWinners(p1, p2, p3, croupier, deck);
        List<Player> real_winners = new ArrayList<>();
        real_winners.add(p1);
        real_winners.add(p2);
        real_winners.add(p3);
        assertEquals (17, BlackJack.calculateSumOfBet(bet_croupier));
        assert (real_winners.equals(test_winners));
    }

    @Test
    public void One_player_win(){
        List<Card> deck = new ArrayList<Card>();
        deck.add(new PipCard(3));
        deck.add(new PipCard(2));
        deck.add(new Ace());
        deck.add(new PipCard(3));

        List<Card> bet_p1 = new ArrayList<Card>();
        bet_p1.add(new PipCard(9));
        bet_p1.add(new PipCard(10));
        bet_p1.add(new Ace());
        Player p1 = new Player(bet_p1);
        assertEquals (20, BlackJack.calculateSumOfBet(bet_p1));

        List<Card> bet_p2 = new ArrayList<Card>();
        bet_p2.add(new Ace());
        bet_p2.add(new PipCard(5));
        bet_p2.add(new PipCard(8));
        bet_p2.add(new PipCard(2));
        Player p2 = new Player(bet_p2);
        assertEquals (16, BlackJack.calculateSumOfBet(bet_p2));

        List<Card> bet_p3 = new ArrayList<Card>();
        bet_p3.add(new Ace());
        bet_p3.add(new PipCard(7));
        bet_p3.add(new PipCard(2));
        bet_p3.add(new PipCard(3));
        bet_p3.add(new PipCard(4));
        Player p3 = new Player(bet_p3);
        assertEquals (17, BlackJack.calculateSumOfBet(bet_p3));

        List<Card> bet_croupier = new ArrayList<Card>();
        bet_croupier.add(new PipCard(10));
        Player croupier = new Player(bet_croupier);
        assertEquals (10, BlackJack.calculateSumOfBet(bet_croupier));

        List<Player> test_winners = BlackJack.getWinners(p1, p2, p3, croupier, deck);
        List<Player> real_winners = new ArrayList<>();
        real_winners.add(p1);
        assertEquals (19, BlackJack.calculateSumOfBet(bet_croupier));
        assert (real_winners.equals(test_winners));
    }

    @Test
    public void Pipcards_with_no_valid_value() {
        List<Card> deck = new ArrayList<Card>();
        deck.add(new PipCard(11));
        deck.add(new PipCard(2));
        deck.add(new PipCard(7));
        deck.add(new PipCard(3));

        List<Card> bet_p1 = new ArrayList<Card>();
        bet_p1.add(new PipCard(1));
        bet_p1.add(new PipCard(3));
        bet_p1.add(new PipCard(12));
        bet_p1.add(new Ace());
        Player p1 = new Player(bet_p1);
        assertEquals (16, BlackJack.calculateSumOfBet(bet_p1));

        List<Card> bet_p2 = new ArrayList<Card>();
        bet_p2.add(new Ace());
        bet_p2.add(new PipCard(8));
        bet_p2.add(new PipCard(0));
        Player p2 = new Player(bet_p2);
        assertEquals (21, BlackJack.calculateSumOfBet(bet_p2));

        List<Card> bet_p3 = new ArrayList<Card>();
        bet_p3.add(new PipCard(10));
        bet_p3.add(new PipCard(2));
        bet_p3.add(new PipCard(-4));
        bet_p3.add(new PipCard(4));
        Player p3 = new Player(bet_p3);
        assertEquals (18, BlackJack.calculateSumOfBet(bet_p3));

        List<Card> bet_croupier = new ArrayList<Card>();
        bet_croupier.add(new PipCard(11));
        Player croupier = new Player(bet_croupier);
        assertEquals (10, BlackJack.calculateSumOfBet(bet_croupier));

        List<Player> test_winners = BlackJack.getWinners(p1, p2, p3, croupier, deck);
        List<Player> real_winners = new ArrayList<>();
        real_winners.add(p2);
        assertEquals (20, BlackJack.calculateSumOfBet(bet_croupier));
        assert (real_winners.equals(test_winners));
    }
}
