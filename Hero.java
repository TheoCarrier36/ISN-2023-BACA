package acl;

public class Hero {
	public static int herosante = 10;	
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
		if (pos_x>lab.length ||pos_x<0 || pos_y>lab.length ||pos_y<0) {
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
		if (direction == 1 && verifiermur(heroposition_x,heroposition_y+1, lab)){
			lab[heroposition_x][heroposition_y]=0;
			heroposition_y=heroposition_y+1;
			lab[heroposition_x][heroposition_y]=2;
		}
		else if (direction == 2 && verifiermur(heroposition_x,heroposition_y-1, lab)){
			lab[heroposition_x][heroposition_y]=0;
			heroposition_y=heroposition_y-1;
			lab[heroposition_x][heroposition_y]=2;
		}
		else if (direction == 3 && verifiermur(heroposition_x+1,heroposition_y, lab)){
			lab[heroposition_x][heroposition_y]=0;
			heroposition_x=heroposition_x+1;
			lab[heroposition_x][heroposition_y]=2;
		}
		else if (direction == 4 && verifiermur(heroposition_x-1,heroposition_y, lab)){
			lab[heroposition_x][heroposition_y]=0;
			heroposition_x=heroposition_x-1;
			lab[heroposition_x][heroposition_y]=2;
		}
		
	}
	
	
	}

