package acl;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		int lab1[][] = Labyrinthe.lab0(5);
		System.out.println("lab cree : \n");
		Labyrinthe.afficherlab(lab1);
		System.out.println("\n" + "finit" + "\n");
		
		System.out.print(Hero.get_heroposx());
		System.out.print(Hero.get_heroposy());
		
		Hero.deplacerhero(3,lab1);
		System.out.print(Hero.get_heroposx());
		System.out.print(Hero.get_heroposy()+"\n");
		Labyrinthe.afficherlab(lab1);
		
		System.out.println("\n" + "debut jeu :" + "\n");
		int niveau =1;
		int direction ;
		Scanner scan = new Scanner(System.in);
		int laby[][] = Labyrinthe.lab0(5);
		Hero.heroposition_x=0;
		Hero.heroposition_y=0;
		Shrek.shrekposition_x=3;
		Shrek.shrekposition_y=3;
		Labyrinthe.afficherlab(laby);
		while (niveau==1){
			 
			System.out.println("droite, gauche, bas, haut");
			direction = scan.nextInt();
			Hero.deplacerhero(direction,laby);
			Labyrinthe.afficherlab(laby);
			System.out.print("Shrekx"+Shrek.shrekposition_x+"\n");
			System.out.print("Shreky"+Shrek.shrekposition_y+"\n");
			System.out.print("Herox"+Hero.heroposition_x+"\n");
			System.out.print("Heroy"+Hero.heroposition_y+"\n");
			Shrek.heromonstre(laby);
			if (Hero.herosante == 0) {
				System.out.println("mort");
				niveau = 1;
				scan.close();
			}
			System.out.println("1 continuer, 0 arreter");
			niveau=scan.nextInt();
		}
		scan.close();
	}
		
	}


