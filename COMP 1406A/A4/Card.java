public class Card extends AbstractCard{

    public Card(RANK rank, SUIT suit){
        super(rank,suit);
    }

    public Card(String card){
            super(RANK.JOKER, SUIT.NONE);
            String suits= "dchs";
            if(card.charAt(0) == '2'){
                this.rank = RANK.TWO;
                if(card.toLowerCase().charAt(1) == 'd'){
                    this.suit = SUIT.DIAMONDS;
                }
                if(card.toLowerCase().charAt(1) == 'c'){
                    this.suit = SUIT.CLUBS;
                }
                if(card.toLowerCase().charAt(1) == 'h'){
                    this.suit = SUIT.HEARTS;
                }
                if(card.toLowerCase().charAt(1) == 's'){
                    this.suit = SUIT.SPADES;
                }
            }
            if(card.charAt(0) == '3'){
                this.rank = RANK.THREE;
                if(card.toLowerCase().charAt(1) == 'd'){
                    this.suit = SUIT.DIAMONDS;
                }
                if(card.toLowerCase().charAt(1) == 'c'){
                    this.suit = SUIT.CLUBS;
                }
                if(card.toLowerCase().charAt(1) == 'h'){
                    this.suit = SUIT.HEARTS;
                }
                if(card.toLowerCase().charAt(1) == 's'){
                    this.suit = SUIT.SPADES;
                }
            }
            if(card.charAt(0) == '4'){
                this.rank = RANK.FOUR;
                if(card.toLowerCase().charAt(1) == 'd'){
                    this.suit = SUIT.DIAMONDS;
                }
                if(card.toLowerCase().charAt(1) == 'c'){
                    this.suit = SUIT.CLUBS;
                }
                if(card.toLowerCase().charAt(1) == 'h'){
                    this.suit = SUIT.HEARTS;
                }
                if(card.toLowerCase().charAt(1) == 's'){
                    this.suit = SUIT.SPADES;
                }
            }
            if(card.charAt(0) == '5'){
                this.rank = RANK.FIVE;
                if(card.toLowerCase().charAt(1) == 'd'){
                    this.suit = SUIT.DIAMONDS;
                }
                if(card.toLowerCase().charAt(1) == 'c'){
                    this.suit = SUIT.CLUBS;
                }
                if(card.toLowerCase().charAt(1) == 'h'){
                    this.suit = SUIT.HEARTS;
                }
                if(card.toLowerCase().charAt(1) == 's'){
                    this.suit = SUIT.SPADES;
                }
            }
            if(card.charAt(0) == '6'){
                this.rank = RANK.SIX;
                if(card.toLowerCase().charAt(1) == 'd'){
                    this.suit = SUIT.DIAMONDS;
                }
                if(card.toLowerCase().charAt(1) == 'c'){
                    this.suit = SUIT.CLUBS;
                }
                if(card.toLowerCase().charAt(1) == 'h'){
                    this.suit = SUIT.HEARTS;
                }
                if(card.toLowerCase().charAt(1) == 's'){
                    this.suit = SUIT.SPADES;
                }
            }
            if(card.charAt(0) == '7'){
                this.rank = RANK.SEVEN;
                if(card.toLowerCase().charAt(1) == 'd'){
                    this.suit = SUIT.DIAMONDS;
                }
                if(card.toLowerCase().charAt(1) == 'c'){
                    this.suit = SUIT.CLUBS;
                }
                if(card.toLowerCase().charAt(1) == 'h'){
                    this.suit = SUIT.HEARTS;
                }
                if(card.toLowerCase().charAt(1) == 's'){
                    this.suit = SUIT.SPADES;
                }
            }
            if(card.charAt(0) == '8'){
                this.rank = RANK.EIGHT;
                if(card.toLowerCase().charAt(1) == 'd'){
                    this.suit = SUIT.DIAMONDS;
                }
                if(card.toLowerCase().charAt(1) == 'c'){
                    this.suit = SUIT.CLUBS;
                }
                if(card.toLowerCase().charAt(1) == 'h'){
                    this.suit = SUIT.HEARTS;
                }
                if(card.toLowerCase().charAt(1) == 's'){
                    this.suit = SUIT.SPADES;
                }
            }
            if(card.charAt(0) == '9'){
                this.rank = RANK.NINE;
                if(card.toLowerCase().charAt(1) == 'd'){
                    this.suit = SUIT.DIAMONDS;
                }
                if(card.toLowerCase().charAt(1) == 'c'){
                    this.suit = SUIT.CLUBS;
                }
                if(card.toLowerCase().charAt(1) == 'h'){
                    this.suit = SUIT.HEARTS;
                }
                if(card.toLowerCase().charAt(1) == 's'){
                    this.suit = SUIT.SPADES;
                }
            }
            if(card.charAt(0) == '1' && card.charAt(1) == '0'){
                this.rank = RANK.TEN;
                if(card.toLowerCase().charAt(2) == 'd'){
                    this.suit = SUIT.DIAMONDS;
                }
                if(card.toLowerCase().charAt(2) == 'c'){
                    this.suit = SUIT.CLUBS;
                }
                if(card.toLowerCase().charAt(2) == 'h'){
                    this.suit = SUIT.HEARTS;
                }
                if(card.toLowerCase().charAt(2) == 's'){
                    this.suit = SUIT.SPADES;
                }
            }
            if(card.toLowerCase().charAt(0) == 'j'){
                this.rank = RANK.JACK;
                if(card.toLowerCase().charAt(1) == 'd'){
                    this.suit = SUIT.DIAMONDS;
                }
                if(card.toLowerCase().charAt(1) == 'c'){
                    this.suit = SUIT.CLUBS;
                }
                if(card.toLowerCase().charAt(1) == 'h'){
                    this.suit = SUIT.HEARTS;
                }
                if(card.toLowerCase().charAt(1) == 's'){
                    this.suit = SUIT.SPADES;
                }
            }
            if(card.toLowerCase().charAt(0) == 'q'){
                this.rank = RANK.QUEEN;
                if(card.toLowerCase().charAt(1) == 'd'){
                    this.suit = SUIT.DIAMONDS;
                }
                if(card.toLowerCase().charAt(1) == 'c'){
                    this.suit = SUIT.CLUBS;
                }
                if(card.toLowerCase().charAt(1) == 'h'){
                    this.suit = SUIT.HEARTS;
                }
                if(card.toLowerCase().charAt(1) == 's'){
                    this.suit = SUIT.SPADES;
                }
            }
            if(card.toLowerCase().charAt(0) == 'k'){
                this.rank = RANK.KING;
                if(card.toLowerCase().charAt(1) == 'd'){
                    this.suit = SUIT.DIAMONDS;
                }
                if(card.toLowerCase().charAt(1) == 'c'){
                    this.suit = SUIT.CLUBS;
                }
                if(card.toLowerCase().charAt(1) == 'h'){
                    this.suit = SUIT.HEARTS;
                }
                if(card.toLowerCase().charAt(1) == 's'){
                    this.suit = SUIT.SPADES;
                }
            }
            if(card.toLowerCase().charAt(0) == 'a'){
                this.rank = RANK.ACE;
                if(card.toLowerCase().charAt(1) == 'd'){
                    this.suit = SUIT.DIAMONDS;
                }
                if(card.toLowerCase().charAt(1) == 'c'){
                    this.suit = SUIT.CLUBS;
                }
                if(card.toLowerCase().charAt(1) == 'h'){
                    this.suit = SUIT.HEARTS;
                }
                if(card.toLowerCase().charAt(1) == 's'){
                    this.suit = SUIT.SPADES;
                }
            } 
            if(this.rank == RANK.TEN){
                if(card.length() > 3 || suits.indexOf(card.toLowerCase().charAt(2)) == -1){
                    this.rank = RANK.JOKER;
                    this.suit = SUIT.NONE;
                } 
            } 
            else{
            if(card.length() > 2 || suits.indexOf(card.toLowerCase().charAt(1)) == -1){
            this.rank = RANK.JOKER;
            this.suit = SUIT.NONE;
            } 
        }
    }

    @Override
    public int compareTo(AbstractCard one){
        int value_card_one = 0;
        int value_card_two = 0;
        if(one.suit == SUIT.DIAMONDS){
            value_card_one = 1;
        }
        if(one.suit == SUIT.CLUBS){
            value_card_one = 2;
        }
        if(one.suit == SUIT.HEARTS){
            value_card_one = 3;
        }
        if(one.suit == SUIT.SPADES){
            value_card_one = 4;
        }

        if(this.suit == SUIT.DIAMONDS){
            value_card_two = 1;
        }
        if(this.suit == SUIT.CLUBS){
            value_card_two = 2;
        }
        if(this.suit == SUIT.HEARTS){
            value_card_two = 3;
        }
        if(this.suit == SUIT.SPADES){
            value_card_two = 4;
        }
        if(value_card_one > value_card_two){
            return -1;                              // if the first card is bigger then the second card
        }
        if(value_card_two > value_card_one){
            return 1;                              // if the second card is bigger then the first card
        } else{                                    // both cards have the same suit 
            value_card_one = 0;
            value_card_two = 0;
            if(one.rank == RANK.NONE){
                value_card_one = 0;
            }
            if(one.rank == RANK.JOKER){
                value_card_one = 1;
            }
            if(one.rank == RANK.TWO){
                value_card_one = 2;
            }
            if(one.rank == RANK.THREE){
                value_card_one = 3;
            }
            if(one.rank == RANK.FOUR){
                value_card_one = 4;
            }
            if(one.rank == RANK.FIVE){
                value_card_one = 5;
            }
            if(one.rank == RANK.SIX){
                value_card_one = 6;
            }
            if(one.rank == RANK.SEVEN){
                value_card_one = 7;
            }
            if(one.rank == RANK.EIGHT){
                value_card_one = 8;
            }
            if(one.rank == RANK.NINE){
                value_card_one = 9;
            }
            if(one.rank == RANK.TEN){
                value_card_one = 10;
            }
            if(one.rank == RANK.JACK){
                value_card_one = 11;
            }
            if(one.rank == RANK.QUEEN){
                value_card_one = 12;
            }
            if(one.rank == RANK.KING){
                value_card_one = 13;
            }
            if(one.rank == RANK.ACE){
                value_card_one = 14;
            }

            if(this.rank == RANK.NONE){
                value_card_two = 0;
            }
            if(this.rank == RANK.JOKER){
                value_card_two = 1;
            }
            if(this.rank == RANK.TWO){
                value_card_two = 2;
            }
            if(this.rank == RANK.THREE){
                value_card_two = 3;
            }
            if(this.rank == RANK.FOUR){
                value_card_two = 4;
            }
            if(this.rank == RANK.FIVE){
                value_card_two = 5;
            }
            if(this.rank == RANK.SIX){
                value_card_two = 6;
            }
            if(this.rank == RANK.SEVEN){
                value_card_two = 7;
            }
            if(this.rank == RANK.EIGHT){
                value_card_two = 8;
            }
            if(this.rank == RANK.NINE){
                value_card_two = 9;
            }
            if(this.rank == RANK.TEN){
                value_card_two = 10;
            }
            if(this.rank == RANK.JACK){
                value_card_two = 11;
            }
            if(this.rank == RANK.QUEEN){
                value_card_two = 12;
            }
            if(this.rank == RANK.KING){
                value_card_two = 13;
            }
            if(this.rank == RANK.ACE){
                value_card_two = 14;
            }
            if(value_card_one > value_card_two){
                return -1;                              // if the first card is bigger then the second card
            }
            if(value_card_two > value_card_one){
                return 1; 
            } else{
                return 0;
            }
        }
    }
    
    @Override
    public String toString(){
        if(this.rank == RANK.TWO){
            if(this.suit == SUIT.DIAMONDS){
                return "2D";
            }
            if(this.suit == SUIT.CLUBS){
                return "2C";
            }
            if(this.suit == SUIT.HEARTS){
                return "2H";
            }
            if(this.suit == SUIT.SPADES){
                return "2S";
            }
        }
        if(this.rank == RANK.THREE){
            if(this.suit == SUIT.DIAMONDS){
                return "3D";
            }
            if(this.suit == SUIT.CLUBS){
                return "3C";
            }
            if(this.suit == SUIT.HEARTS){
                return "3H";
            }
            if(this.suit == SUIT.SPADES){
                return "3S";
            }
        }
        if(this.rank == RANK.FOUR){
            if(this.suit == SUIT.DIAMONDS){
                return "4D";
            }
            if(this.suit == SUIT.CLUBS){
                return "4C";
            }
            if(this.suit == SUIT.HEARTS){
                return "4H";
            }
            if(this.suit == SUIT.SPADES){
                return "4S";
            }
        }
        if(this.rank == RANK.FIVE){
            if(this.suit == SUIT.DIAMONDS){
                return "5D";
            }
            if(this.suit == SUIT.CLUBS){
                return "5C";
            }
            if(this.suit == SUIT.HEARTS){
                return "5H";
            }
            if(this.suit == SUIT.SPADES){
                return "5S";
            }
        }
        if(this.rank == RANK.SIX){
            if(this.suit == SUIT.DIAMONDS){
                return "6D";
            }
            if(this.suit == SUIT.CLUBS){
                return "6C";
            }
            if(this.suit == SUIT.HEARTS){
                return "6H";
            }
            if(this.suit == SUIT.SPADES){
                return "6S";
            }
        }
        if(this.rank == RANK.SEVEN){
            if(this.suit == SUIT.DIAMONDS){
                return "7D";
            }
            if(this.suit == SUIT.CLUBS){
                return "7C";
            }
            if(this.suit == SUIT.HEARTS){
                return "7H";
            }
            if(this.suit == SUIT.SPADES){
                return "7S";
            }
        }
        if(this.rank == RANK.EIGHT){
            if(this.suit == SUIT.DIAMONDS){
                return "8D";
            }
            if(this.suit == SUIT.CLUBS){
                return "8C";
            }
            if(this.suit == SUIT.HEARTS){
                return "8H";
            }
            if(this.suit == SUIT.SPADES){
                return "8S";
            }
        }
        if(this.rank == RANK.NINE){
            if(this.suit == SUIT.DIAMONDS){
                return "9D";
            }
            if(this.suit == SUIT.CLUBS){
                return "9C";
            }
            if(this.suit == SUIT.HEARTS){
                return "9H";
            }
            if(this.suit == SUIT.SPADES){
                return "9S";
            }
        }
        if(this.rank == RANK.TEN){
            if(this.suit == SUIT.DIAMONDS){
                return "10D";
            }
            if(this.suit == SUIT.CLUBS){
                return "10C";
            }
            if(this.suit == SUIT.HEARTS){
                return "10H";
            }
            if(this.suit == SUIT.SPADES){
                return "10S";
            }
        }
        if(this.rank == RANK.JACK){
            if(this.suit == SUIT.DIAMONDS){
                return "JD";
            }
            if(this.suit == SUIT.CLUBS){
                return "JC";
            }
            if(this.suit == SUIT.HEARTS){
                return "JH";
            }
            if(this.suit == SUIT.SPADES){
                return "JS";
            }
        }
        if(this.rank == RANK.QUEEN){
            if(this.suit == SUIT.DIAMONDS){
                return "QD";
            }
            if(this.suit == SUIT.CLUBS){
                return "QC";
            }
            if(this.suit == SUIT.HEARTS){
                return "QH";
            }
            if(this.suit == SUIT.SPADES){
                return "QS";
            }
        }
        if(this.rank == RANK.KING){
            if(this.suit == SUIT.DIAMONDS){
                return "KD";
            }
            if(this.suit == SUIT.CLUBS){
                return "KC";
            }
            if(this.suit == SUIT.HEARTS){
                return "KH";
            }
            if(this.suit == SUIT.SPADES){
                return "KS";
            }
        }
        if(this.rank == RANK.ACE){
            if(this.suit == SUIT.DIAMONDS){
                return "AD";
            }
            if(this.suit == SUIT.CLUBS){
                return "AC";
            }
            if(this.suit == SUIT.HEARTS){
                return "AH";
            }
            if(this.suit == SUIT.SPADES){
                return "AS";
            }
        }
        return "Joker";

    }
}
