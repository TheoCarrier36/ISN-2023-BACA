package acl;
import java.util.Random;
public class Labyrinthe {
	public static void afficherlab(int [][] lab) { //a modif pr rajout les entites ( elseif )
		System.out.print("|");
		for (int i=0;i<lab.length;i++) {
			System.out.print("-");
		}
		System.out.println("|");
		System.out.print("|");
		for (int i=0;i<lab.length;i++) {
			for (int j=0;j<lab.length;j++) {
				if (lab[i][j]==1){
					System.out.print('+');	}
				else if (lab[i][j]==2) {
					System.out.print('H');}
				else if (lab[i][j]==3) {
					System.out.print('S');}
				else {
					System.out.print(' ');	}
				}
			System.out.print("|"+"\n"+"|");
		}	
		for (int i=0;i<lab.length;i++) {
			System.out.print("-");
		}
		System.out.println("|");
	}
	
	public static int [][] creerlabyrithe(int taille){
		Random random= new Random();
		int[][] lab = new int[taille][taille];
		for (int i=0;i<lab.length;i++) {
			for (int j=0;j<lab.length;j++) {
				lab[i][j]= random.nextInt(2);	
		}
		}
		lab[0][0]=2;
		lab[taille-1][taille-1]=3;
		return(lab);
	}
	public static int [][] lab0(int taille){
		int[][] lab = new int[taille][taille];
		for (int i=0;i<lab.length;i++) {
			for (int j=0;j<lab.length;j++) {
				lab[i][j]= 0;	
		}
		}
		lab[0][0]=2;
		lab[3][3]=3;
		return(lab);
	}
	}

