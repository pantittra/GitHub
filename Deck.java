package slave;

public class Deck {
	final static int deckCount = 52;
	Card[] cards = new Card[deckCount];
	public Deck(){
		int i=0;
		for (int j=1;j<=13;j++){
			for(int k=1;k<=4;k++){
				cards[i] = new Card(j,k);
				i++;
			}
		}
	}
	public void shuffle(){
		int shuff = Utility.random(1, 500);
		for (int i = 0; i< shuff ;i++){
			int x = Utility.random(1,this.getDeckSize()-1);
			int y = Utility.random(1,this.getDeckSize()-1);
			Card z = cards[x];
			cards[x] = cards[y];
			cards[y] = z;
		}
	}
	public Card deal(){
		return cards[deckCount-1];
	}
	public int getDeckSize(){
		return deckCount;
	}
}
