package projacl;

import java.util.ArrayList;
import java.util.List;
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
		boolean niveau = true;
		int direction ;
		Scanner scan = new Scanner(System.in);
		int laby[][] = Labyrinthe.niveau1();
		Hero.heroposition_x=0;
		Hero.heroposition_y=0;
		Shrek.shrekposition_x=6;
		Shrek.shrekposition_y=6;
		Fantome.fantposition_x=0;
		Fantome.fantposition_y=6;
		Labyrinthe.afficherlab(laby);
		while (niveau==true){
			 
			System.out.println("gauche, bas, droite , haut : 5");
			direction = scan.nextInt();
			Hero.deplacerhero(direction,laby);
			List<Integer> listedir = Shrek.listdirpos(laby);
			int dir = Shrek.dirshrek(listedir);
			Shrek.deplacershrek(dir,laby);
			List<Integer> listedirf = Fantome.listdirpos(laby);
			int dirf = Fantome.dirfant(listedirf);
			Fantome.deplacerfant(dirf,laby);
			Labyrinthe.afficherlab(laby);
			Shrek.heromonstre(laby);
			Fantome.heromonstre(laby);
			Hero.interaction(laby);
			System.out.println("SANTE : "+ Hero.herosante);
			System.out.println("PIECE : "+ Hero.piece);
			//System.out.print("Shrekx"+Shrek.shrekposition_x+"\n");
			//System.out.print("Shreky"+Shrek.shrekposition_y+"\n");
			//System.out.print("Herox"+Hero.heroposition_x+"\n");
			//System.out.print("Heroy"+Hero.heroposition_y+"\n");
			
			if (Hero.herosante <= 0) {
				System.out.println("mort");
				niveau = false;
				scan.close();
			}
		}
	}
		
	}


