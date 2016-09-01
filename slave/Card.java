package slave;

public class Card {
	public int rank,suit;
	public Card(int rank,int suit){
		if (rank>0 && rank<14)
			this.rank=rank;
		else;
			this.rank=1;
		if (suit>0 && suit<5)
			this.suit=suit;
		else;
			this.suit=1;
		
	}
	public int getRank(){
		return this.rank;
	}
	public void setRank(int rank){
		if (rank>0 && rank<14)
			this.rank=rank;
	}
	public int getSuit(){
		return this.suit;
	}
	public void setSuit(int suit){
		if (suit>0 && suit<5)
			this.suit=suit;
	}
	public boolean isBiggerThan(Card card){
		if (rank>card.rank){
			return true;
		}
		else if(rank==card.rank && suit>card.suit)
			return true;
		else if (rank==2 || rank==1)
			return true;
		else
			return false;
	}
	public String toString(){
		String[] ranks = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String[] suits = {"clubs","diamonds","hearts","spades"};
		return suits[suit-1]+" "+ranks[rank-1];
	}

}
