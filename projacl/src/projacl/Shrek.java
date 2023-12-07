package projacl;

import java.util.ArrayList;
import java.util.List;

public class Shrek {
	public int shreksante = 10;	
	public int shrekforce = 1;
	
	int get_santeshrek() {
		return(shreksante);
	}
	int get_shrekforce() {
		return(shrekforce);
	}
	public static int shrekposition_x;
	public static int shrekposition_y;
	
	public static int get_shrekposx() {
		return(shrekposition_x);
	}
	public static int get_shrekposy() {
		return(shrekposition_y);
	}
	
	static boolean verifiermur(int pos_x,int pos_y, int[][] lab) {
		//test dans le lab
		//System.out.println(lab.length);
		//System.out.println(pos_x+" "+ pos_y);
		if (pos_x>lab.length-1 ||pos_x<0 || pos_y>lab[0].length-1 ||pos_y<0) {
			System.out.println("sorti du cadre");
			return(false);
		}
		if (lab[pos_x][pos_y]!=0) {
			System.out.println("mur");
			return(false);
		}
		else {
			return(true);
		}
	}
	public static List<Integer> listdirpos(int [][] lab) {
		List<Integer> dirpos = new ArrayList<Integer>();
		dirpos.add(0);
		if (verifiermur(shrekposition_x,shrekposition_y+1, lab)){
			dirpos.add(3);
		}
		if (verifiermur(shrekposition_x,shrekposition_y-1, lab)){
			dirpos.add(1);
	}
		if (verifiermur(shrekposition_x+1,shrekposition_y, lab)){
			dirpos.add(2);
	}
		if (verifiermur(shrekposition_x-1,shrekposition_y, lab)){
			dirpos.add(5);
	}
		System.out.println("direcction possibles : "+ dirpos);
		System.out.println("longeur: "+ dirpos.size());
		return dirpos;

	}
	public static int dirshrek(List<Integer> dirpos) {
		int ou  = (int)(Math.random()*(dirpos.size()));
		int direction = dirpos.get(ou);
		System.out.println(direction);
		return direction;
	}
	public static void deplacershrek(int direction, int[][] lab) {

		if (direction == 3 ){
			lab[shrekposition_x][shrekposition_y]=0;
			shrekposition_y=shrekposition_y+1;
			lab[shrekposition_x][shrekposition_y]=3;
		}
		else if (direction == 1){
			lab[shrekposition_x][shrekposition_y]=0;
			shrekposition_y=shrekposition_y-1;
			lab[shrekposition_x][shrekposition_y]=3;
		}
		else if (direction == 2 ){
			lab[shrekposition_x][shrekposition_y]=0;
			shrekposition_x=shrekposition_x+1;
			lab[shrekposition_x][shrekposition_y]=3;
		}
		else if (direction == 5){
			lab[shrekposition_x][shrekposition_y]=0;
			shrekposition_x=shrekposition_x-1;
			lab[shrekposition_x][shrekposition_y]=3;
		}
		
	}
	public static void heromonstre(int[][] lab) {
		double dist = (Math.abs(shrekposition_x-Hero.heroposition_x)+Math.abs(shrekposition_y-Hero.heroposition_y)-0.5);
				//System.out.println(dist);
		if (dist<2.0) {
			if ( ( (Math.abs(shrekposition_x-Hero.heroposition_x)==1) && (Math.abs(shrekposition_y-Hero.heroposition_y)==1)) || 
					( (Math.abs(shrekposition_x-Hero.heroposition_x)==0) && (Math.abs(shrekposition_y-Hero.heroposition_y)==1)) || 
					( (Math.abs(shrekposition_x-Hero.heroposition_x)==1) && (Math.abs(shrekposition_y-Hero.heroposition_y)==0))
					){
				System.out.println("danger");
				Hero.herosante -= 10;
			}	
			}
	}
	}
	
	
	