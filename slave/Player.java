package slave;

import java.util.ArrayList;

public class Player {
	String name;
	boolean pass=false;
	ArrayList<Card> cardsInHand = new ArrayList<Card>();
	public Player(String name){
		this.setName(name);
		this.setPass(false);
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public boolean isPass(){
		return pass;
	}
	public void setPass(boolean pass){
		this.pass=pass;
	}
	public ArrayList<Card> getCardsInHand(){
		return cardsInHand;
	}
	public void addCardToHand(Card card){
		cardsInHand.add(card);
	}
	public void play(Field field){
		ArrayList<CardPile> pcp = Utility.generatePossibleCardPile(this.getCardsInHand());
		boolean p = false;
		for (int i = pcp.size()-1;i>=0;i--){
			CardPile cp = pcp.get(i);
			if(field.getTopPile()==null || field.getTopPile() != null && cp.canBePlacedOnTopOf(field.getTopPile())){
				field.setTopPile(cp);
				for(Card c : cp.getCards())
					this.cardsInHand.remove(c);
				p=true;
				break;
			}
		}
		if(p==false)
			this.setPass(true);
	}
	public boolean win(){
		if (this.getCardsInHand().size()==0){
			this.setPass(true);
			return true;
		}
		return false;
	}
}
