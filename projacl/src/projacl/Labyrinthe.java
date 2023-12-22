package projacl;
import java.util.Random;

public class Labyrinthe {
	
	public static void afficherlab(int [][] lab) {
		System.out.print("|");
		for (int i=0;i<lab.length;i++) {
			System.out.print("-");
		}
		System.out.println("|");
		System.out.print("|");
		for (int i=0;i<lab.length;i++) {
			for (int j=0;j<lab[0].length;j++) {
				if (lab[i][j]==1){
					System.out.print('+');	}
				else if (lab[i][j]==2) {
					System.out.print('H');}
				else if (lab[i][j]==3) {
					System.out.print('S');}
				else if (lab[i][j]==4) {
					System.out.print('T');}
				else if (lab[i][j]==5) {
					System.out.print('G');}
				else if (lab[i][j]==6) {
					System.out.print('F');}
				else if (lab[i][j]==7) {
					System.out.print('A');}
				else {
					System.out.print(' ');	}
				}
			System.out.print("|"+"\n"+"|");
		}	
		
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
	public static int [][] niveau1(){
		//int [][] mazeArray = new int[13][10];
		int[][] lab =
            { {1,1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,0,1,0,1,0,1,0,0,0,0,0,1},
                    {1,0,1,0,0,0,1,0,1,1,1,0,1},
                    {1,0,0,0,1,1,1,0,0,0,0,0,1},
                    {1,0,1,0,0,0,0,0,1,1,1,0,1},
                    {1,0,1,0,1,1,1,0,1,0,0,0,1},
                    {1,0,1,0,1,0,0,0,1,1,1,0,1},
                    {1,0,1,0,1,1,1,0,1,0,1,0,1},
                    {1,0,0,0,0,0,0,0,0,0,1,7,1},
                    {1,1,1,1,1,1,1,1,1,1,1,1,1}
            };
		//lab[1][1]=2;
		//lab[6][6]=3;
		//lab[3][4]=4;
		//lab[1][6]=5;
		//lab[0][6]=6;
		return(lab);
	}
	
}

