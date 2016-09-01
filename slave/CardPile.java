package slave;

public class CardPile {
	Card[] cards;
	public CardPile(Card[] cards){
		this.cards = cards;
	}
	public Card[] getCards(){
		return cards;
	}
	public boolean canBePlacedOnTopOf(CardPile otherPile){
		int x = otherPile.getCards().length;
		int y = this.getCards().length;
		if (x==0)
			return true;
		else if (x==1){
			if(y==1)
				return this.getCards()[0].isBiggerThan(otherPile.getCards()[0]);
			else if (y==3)
				return true;
			else
				return false;
		}
		else if (x==2){
			if (y==2){
				Card c1 = this.getBiggestCardInThisPile();
				Card c2 = otherPile.getBiggestCardInThisPile();
				return c1.isBiggerThan(c2);
			}
			else if (y==4)
				return true;
			else
				return false;
		}
		else if (x==4){
			if (y==4){
				Card c1 = this.getBiggestCardInThisPile();
				Card c2 = otherPile.getBiggestCardInThisPile();
				return c1.isBiggerThan(c2);
			}
			return false;
		}
		return false;
	}
	public Card getBiggestCardInThisPile(){
		Card bc = this.getCards()[0];
		for (Card c : this.getCards()){
			if(c.isBiggerThan(bc))
				bc=c;
		}
		return bc;
	}
	public String toString(){
		Card[] c = this.getCards();
		int p = c.length-1;
		String s = "[";
		for (int j = 0;j<c.length;j++){
			s=s+c[j].toString();
			if (j==p)
				s+="]";
			if(j<p)
				s+=", ";
			
		}
		return s;
	}

}
