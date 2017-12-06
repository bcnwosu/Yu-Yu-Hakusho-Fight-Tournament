package fighter;

import java.util.Random;

public class Fighter {
	//NOTE: there is no main method because this is a package and will be ran in the main method of Tournament
	//the fighter will have a name, a signature move, and readable stamina for the fighter
	public String name;
	public String signatureMove;

	public double stamina;
	//these are statements that will be printed when the fighter uses their signature move
	private String[] statements = {
		"I'm not giving up. Not now, not ever!",
		"This is it...",
		"Now I've got you...",
		"Feel my will. Fear my strength!",
		"And you thought I had all but given up...",
		"You thought I was finished didn't you? Well, think again..."
	};
	//calling all my fields in the constructor 
	public Fighter(String name, String signatureMove, int stamina) {
		this.name = name;
		this.signatureMove = signatureMove;
		this.stamina = stamina;
	}
	//the signature moves are randomized and happen at will (depending on stamina)
	//the println function is there as well to show us, as the viewers, when the special move is used
	public void doSignatureMove() {

		if((int) this.stamina > 0) {
			Random rand = new Random();
			int num = rand.nextInt((int) this.statements.length - 1);

			System.out.println(this.name + " uses special move: \"" + this.statements[num] + " ... " + this.signatureMove + "!\"\n");

			num = rand.nextInt((int) this.stamina);
			this.stamina -= num + 1;
		}

	}

}
