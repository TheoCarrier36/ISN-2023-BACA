
package projacl;

import java.util.ArrayList;
import java.util.List;

public class Fantome {
	public int fantsante = 10;	
	public int fantforce = 1;
	
	int get_santefant() {
		return(fantsante);
	}
	int get_fantforce() {
		return(fantforce);
	}
	public static int fantposition_x;
	public static int fantposition_y;
	
	public static int get_fantposx() {
		return(fantposition_x);
	}
	public static int get_fantposy() {
		return(fantposition_y);
	}
	
	static boolean fantverifiermur(int pos_x,int pos_y, int[][] lab) {
		if (pos_x>lab.length-1 ||pos_x<0 || pos_y>lab.length-1 ||pos_y<0) {
			System.out.println("sorti du cadre");
			return(false);
		}
		if (lab[pos_x][pos_y]!=0) {
			if (lab[pos_x][pos_y]==1) {
				return(true);
			}
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
		if (fantverifiermur(fantposition_x,fantposition_y+1, lab)){
			dirpos.add(3);
		}
		if (fantverifiermur(fantposition_x,fantposition_y-1, lab)){
			dirpos.add(1);
	}
		if (fantverifiermur(fantposition_x+1,fantposition_y, lab)){
			dirpos.add(2);
	}
		if (fantverifiermur(fantposition_x-1,fantposition_y, lab)){
			dirpos.add(5);
	}
		System.out.println("fant directions possibles : "+ dirpos);
		System.out.println("longeur: "+ dirpos.size());
		return dirpos;

	}
	public static int dirfant(List<Integer> dirpos) {
		int ou  = (int)(Math.random()*(dirpos.size()));
		int direction = dirpos.get(ou);
		System.out.println(direction);
		return direction;
	}
	public static void deplacerfant(int direction, int[][] lab) {
		if (direction == 3 ){
			lab[fantposition_x][fantposition_y]=0;
			fantposition_y=fantposition_y+1;
			lab[fantposition_x][fantposition_y]=6;
		}
		else if (direction == 1){
			lab[fantposition_x][fantposition_y]=0;
			fantposition_y=fantposition_y-1;
			lab[fantposition_x][fantposition_y]=6;
		}
		else if (direction == 2 ){
			lab[fantposition_x][fantposition_y]=0;
			fantposition_x=fantposition_x+1;
			lab[fantposition_x][fantposition_y]=6;
		}
		else if (direction == 5){
			lab[fantposition_x][fantposition_y]=0;
			fantposition_x=fantposition_x-1;
			lab[fantposition_x][fantposition_y]=6;
		}
		
	}
	public static void heromonstre(int[][] lab) {
		
		double dist = (Math.abs(fantposition_x-Hero.heroposition_x)+Math.abs(fantposition_y-Hero.heroposition_y)-0.5);
		 
				//System.out.println(dist);
				if (dist<2.0) {
					if ( ( (Math.abs(fantposition_x-Hero.heroposition_x)==1) && (Math.abs(fantposition_y-Hero.heroposition_y)==1)) || 
							( (Math.abs(fantposition_x-Hero.heroposition_x)==0) && (Math.abs(fantposition_y-Hero.heroposition_y)==1)) || 
							( (Math.abs(fantposition_x-Hero.heroposition_x)==1) && (Math.abs(fantposition_y-Hero.heroposition_y)==0))
							){
						System.out.println("danger");
						Hero.herosante -= 10;
						
					}
					}
							}
	}
	
	
	