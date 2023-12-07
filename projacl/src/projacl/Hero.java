package projacl;

public class Hero {
	public static int herosante = 45;	
	public static int piece = 0;
	public static int old= 0;
	public int heroforce = 1;
	
	int get_santehero() {
		return(herosante);
	}
	int get_heroforce() {
		return(heroforce);
	}
	public static int heroposition_x=0;
	public static int heroposition_y=0;
	
	public static int get_heroposx() {
		return(heroposition_x);
	}
	public static int get_heroposy() {
		return(heroposition_y);
	}
	
	public static boolean verifiermur(int pos_x,int pos_y, int[][] lab) {
		//test dans le lab
		if (pos_x>lab.length-1 ||pos_x<0 || pos_y>lab[0].length-1 ||pos_y<0) {
			System.out.println("sorti du cadre");
			return(false);
		}
		if (lab[pos_x][pos_y]==1) {
			System.out.println("mur");
			return(false);
		}
		else {
			return(true);
		}
	}
	public static void deplacerhero(int direction, int[][] lab) {
		//1 droite
		//2 gauche
		//3 bas
		//4 haut
		if (direction == 3 && verifiermur(heroposition_x,heroposition_y+1, lab)){
			//droite
			lab[heroposition_x][heroposition_y]=0;
			heroposition_y=heroposition_y+1;
			Hero.old = lab[heroposition_x][heroposition_y];
			lab[heroposition_x][heroposition_y]=2;
		}
		else if (direction == 1 && verifiermur(heroposition_x,heroposition_y-1, lab)){
			//gauche
			lab[heroposition_x][heroposition_y]=0;
			heroposition_y=heroposition_y-1;
			Hero.old = lab[heroposition_x][heroposition_y];
			lab[heroposition_x][heroposition_y]=2;
		}
		else if (direction == 2 && verifiermur(heroposition_x+1,heroposition_y, lab)){
			//bas
			lab[heroposition_x][heroposition_y]=0;
			heroposition_x=heroposition_x+1;
			Hero.old = lab[heroposition_x][heroposition_y];
			lab[heroposition_x][heroposition_y]=2;
		}
		else if (direction == 5 && verifiermur(heroposition_x-1,heroposition_y, lab)){
			//haut
			lab[heroposition_x][heroposition_y]=0;
			heroposition_x=heroposition_x-1;
			Hero.old = lab[heroposition_x][heroposition_y];
			lab[heroposition_x][heroposition_y]=2;
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
	


