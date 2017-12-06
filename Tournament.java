import fighter.Fighter;
import java.util.Random;
// import java.util.concurrent.TimeUnit;
import java.lang.Math;

public class Tournament {
	// the intention of this code is to simulate a fight between to fighters in a tournament
	
	public static void main(String[] args) {
		
		//instantiated the object tournament to allow the "fight" method to run when called.
		Tournament tournament = new Tournament();
		
		/*instantiated two new fighters with the help of the imported "Fighter" class
		/i named the fighters to further specify them
		/in the parameters were placements for two strings and an integer to fill their "Name, signature move, and stamina"
		*/
		Fighter YusukeUrameshi = new Fighter("Yusuke Urameshi", "Spirit Gun", 100);
		Fighter YokoKurama = new Fighter("Yoko Kurama", "Rose Whip", 80);

		tournament.fight(YusukeUrameshi, YokoKurama);
	}

	public void fight(Fighter f1, Fighter f2) {
		/*the fight will run with the two fighters hitting each other until their stamina is at 0
		/i used the data type "double" since the stamina will be read with the inclusion of decimals
		/the hitters and hittee were randomized so the winner/outcome could be different each time
		/also when they hit one another, it depletes stamina
		*/
		Fighter[] fighters = {f1, f2};
		double[] stamina ={f1.stamina, f2.stamina};
		Random rand = new Random();
		int hitter, hittee, fighterStamina;
		
		/* this while loop is to make sure that when a fighter is hitting, the other fighter is not
		/the purpose of this is to make sure we are able to keep track of who is winning, and how
		*/
		while(f1.stamina > 0 && f2.stamina > 0) {
			hitter = rand.nextInt(2);
			if(hitter == 1) {
				hittee = 0;
			} else {
				hittee = 1;
			}
			//this is to slow down the println so that we can actually see the stamina changes and the signature moves
			try {
				// wait(5000);
				Thread.sleep(2000);
			} catch(Exception e) {}

			System.out.println(fighters[hitter].name + " attacks!\n");
			fighters[hittee].stamina -= (fighters[hittee].stamina * 0.07) + 3;
			// System.out.println(fighters[hittee].name + "'s stamina: " + (int) fighters[hittee].stamina);
			// System.out.println(fighters[hitter].name + "'s stamina: " + (int) fighters[hitter].stamina + "\n");

			try {
				// wait(5000);
				Thread.sleep(2000);
			} catch(Exception e) {}
			
			//this operation is for the fighters to unleash a signature move when their stamina is at a certain point
			fighterStamina = (int) (stamina[hitter] % fighters[hitter].stamina);
			if(0 <= fighterStamina && fighterStamina <= 7) {
				fighters[hitter].doSignatureMove();
				fighters[hittee].stamina -= fighterStamina / 2;
			}

			fighterStamina = (int) (stamina[hittee] % fighters[hittee].stamina);
			if(0 <= fighterStamina && fighterStamina <= 7) {
				fighters[hittee].doSignatureMove();
				fighters[hitter].stamina -= fighterStamina / 2;
			}

		}
		//this condition here is to print out the outcome of the tournament fight
		if(f1.stamina > 0) {
			System.out.println("\n" + f2.name + " passed out! " + f1.name + " is the winner!");
		} else if(f2.stamina > 0) {
			System.out.println("\n" + f1.name + " passed out! " + f2.name + " is the winner!");
		} else if(f2.stamina < 0 && f1.stamina < 0) {
			System.out.println("\n" + f1.name + " and " + f2.name + " both passed out! This fight is a draw!");
		}

		System.out.println(f1.name + " stamina: " + (int) Math.ceil(f1.stamina) + " :: " + f2.name + " stamina : " + (int) Math.ceil(f2.stamina) + "\n");
	}

}
