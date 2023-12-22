package projacl;

public class Hero {
	public static int herosante = 3;	
	public static int piece = 0;
	public static int old= 0;
	public int heroforce = 1;
	
	void set_santehero() {
		herosante=4;
	}
	int get_santehero() {
		return(herosante);
	}
	int get_heroforce() {
		return(heroforce);
	}
	public static int heroposition_x=1;
	public static int heroposition_y=1;
	
	public static int get_heroposx() {
		return(heroposition_x);
	}
	public static int get_heroposy() {
		return(heroposition_y);
	}
	
	public static boolean verifiermur(int pos_x,int pos_y, int[][] lab) {
		//test dans le lab
		if (pos_x>lab.length-1 ||pos_x<0 || pos_y>lab[0].length-1 ||pos_y<0) {
			//System.out.println("sorti du cadre");
			return(false);
		}
		if (lab[pos_x][pos_y]==1) {
			//System.out.println("mur");
			return(false);
		}
		else {
			return(true);
		}
	}
	public static void deplacerhero(int direction, int[][] lab) {

		if (direction == 3 && verifiermur(heroposition_x,heroposition_y+1, lab)){
			//droite
			heroposition_y=heroposition_y+1;
			Hero.old = lab[heroposition_x][heroposition_y];
		}
		else if (direction == 1 && verifiermur(heroposition_x,heroposition_y-1, lab)){
			//gauche
			heroposition_y=heroposition_y-1;
			Hero.old = lab[heroposition_x][heroposition_y];
		}
		else if (direction == 2 && verifiermur(heroposition_x+1,heroposition_y, lab)){
			//bas
			heroposition_x=heroposition_x+1;
			Hero.old = lab[heroposition_x][heroposition_y];
		}
		else if (direction == 5 && verifiermur(heroposition_x-1,heroposition_y, lab)){
			//haut
			heroposition_x=heroposition_x-1;
			Hero.old = lab[heroposition_x][heroposition_y];
		}
		
	}
	public static void interaction( int[][] lab) {
		if (Hero.old==4) {
			System.out.println("Tresor recupéré");
			Hero.piece+=10;}
		else if (Hero.old==5) {
			System.out.println("Régeneration");
			Hero.herosante+=10;}
			
		}
	}
	


