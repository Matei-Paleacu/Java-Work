public abstract class AbstractCard implements Comparable<AbstractCard>{

    protected RANK rank;
    protected SUIT suit;
   
   
    /** Create a card with specified suit and rank
     *
     * @param rank is the rank of the card 
     * @param suit is the suit of the card 
     */
     public AbstractCard(RANK rank, SUIT suit){
       this.rank = rank;
       this.suit = suit;
     }
   
     public RANK getRank(){ return this.rank; }
     public SUIT getSuit(){ return this.suit; }
   
   
     @Override
     public String toString(){
       // outputs a string representation of a card object
       if( this.rank == RANK.JOKER ){
         return RANK.JOKER.toString();   // Joker
       }
       return this.rank + ":" + this.suit;
    }
   
   }