package slave;

import java.util.ArrayList;

public class GameManager {
	public static void main(String[] args){
		Player[] names = new Player[4];
		names[0] = new Player("Alice");
		names[1] = new Player("Bill");
		names[2] = new Player("Cain");
		names[3] = new Player("Doug");
		Deck d = new Deck();
		Field field = new Field();
		d.shuffle();
		while(d.getDeckSize()>0){
			for(Player p : names)
				p.addCardToHand(d.deal());
		}
		ArrayList<Player> winner = new ArrayList<Player>();
		while (winner.size()<3){
			ArrayList<Player> pass = new ArrayList<Player>();
			for(Player n:names)
				n.setPass(false);
			field.clearField();
			while (pass.size()<3){
				for(Player np:names){
					if(pass.size()==3)	{
						for(Player n:names){
							if(n.isPass()==false){
								n.setPass(true);
								System.out.println(n.getName()+" passed");
							}
						}
						System.out.println("All Players declared \"PASS\"");
						break;
					}
					else if (np.win()){
						System.out.println(np.getName()+" passed with empty hand");
						np.setPass(true);
						if(!pass.contains(np))
							pass.add(np);
					}
					else{
						if(np.isPass()){
							if(!pass.contains(np))
								pass.add(np);
							System.out.println(np.getName()+" passed");
						}
						else{
							np.play(field);
							if(np.win()){
								if(!pass.contains(np))
									pass.add(np);
								if (!winner.contains(np))
									winner.add(np);
								System.out.println(np.getName()+ " wins");
								if(winner.size()==3)
									break;
							}
							else{
								if(np.isPass()){
									if(!pass.contains(np))
										pass.add(np);
									System.out.println(np.getName()+" passed");;
									if(pass.size()==3){
										for(Player x:names){
											if(x.isPass()==false){
												x.setPass(true);
												System.out.println(x.getName()+ " passed");
												continue;
											}
										}
										System.out.println("All players declared \"PASS\"");
										break;
									}
								}
								else
									System.out.println(np.getName()+" plays "+field.getTopPile());
							}
						}
					}
				
				}
				if(pass.size()>=3)
					continue;
			}
			if(winner.size()==3){
				field.clearField();
				break;
			}
		}
		for(Player y:names){
			if(!winner.contains(y))
				System.out.println(y.getName()+ " is a SLAVE!");
		}
	}

}
