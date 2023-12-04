package acl;

public class Shrek {
	public int shreksante = 10;	
	public int shrekforce = 1;
	
	int get_santeshrek() {
		return(shreksante);
	}
	int get_shrekforce() {
		return(shrekforce);
	}
	public static int shrekposition_x=0;
	public static int shrekposition_y=0;
	
	public static int get_shrekposx() {
		return(shrekposition_x);
	}
	public static int get_shrekposy() {
		return(shrekposition_y);
	}
	
	static boolean verifiermur(int pos_x,int pos_y, int[][] lab) {
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
	public static void deplacershrek(int direction, int[][] lab) {
		//1 droite
		//2 gauche
		//3 bas
		//4 haut
		if (direction == 1 && verifiermur(shrekposition_x,shrekposition_y+1, lab)){
			lab[shrekposition_x][shrekposition_y]=0;
			shrekposition_y=shrekposition_y+1;
			lab[shrekposition_x][shrekposition_y]=3;
		}
		else if (direction == 2 && verifiermur(shrekposition_x,shrekposition_y-1, lab)){
			lab[shrekposition_x][shrekposition_y]=0;
			shrekposition_y=shrekposition_y-1;
			lab[shrekposition_x][shrekposition_y]=3;
		}
		else if (direction == 3 && verifiermur(shrekposition_x+1,shrekposition_y, lab)){
			lab[shrekposition_x][shrekposition_y]=0;
			shrekposition_x=shrekposition_x+1;
			lab[shrekposition_x][shrekposition_y]=3;
		}
		else if (direction == 4 && verifiermur(shrekposition_x-1,shrekposition_y, lab)){
			lab[shrekposition_x][shrekposition_y]=0;
			shrekposition_x=shrekposition_x-1;
			lab[shrekposition_x][shrekposition_y]=3;
		}
		
	}
	public static void heromonstre(int[][] lab) {
		double dist = Math.sqrt((shrekposition_x-Hero.heroposition_x)^2+(shrekposition_y-Hero.heroposition_y)^2);
				System.out.println(dist);
				(dist<2) {
					Hero.herosante=0;
							}
	}
	
	
	}
