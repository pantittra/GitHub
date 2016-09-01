package slave;

public class Field {
	CardPile topPile;
	public Field(){
		setTopPile(null);
	}
	public Field(CardPile topPile){
		setTopPile(topPile);
	}
	public CardPile getTopPile(){
		return topPile;
	}
	public void setTopPile(CardPile topPile){
		this.topPile=topPile;
	}
	public void clearField(){
		setTopPile(null);
	}

}
