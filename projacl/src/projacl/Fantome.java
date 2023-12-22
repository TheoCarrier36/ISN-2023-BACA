
package projacl;

import java.util.ArrayList;
import java.util.List;

public class Fantome {
	public int fantsante = 2;	
	
	int get_santefant() {
		return(fantsante);
	}

	public static int fantposition_x=8;
	public static int fantposition_y=8;
	
	public static int get_fantposx() {
		return(fantposition_x);
	}
	public static int get_fantposy() {
		return(fantposition_y);
	}
	
	static boolean fantverifiermur(int pos_x,int pos_y, int[][] lab) {
		if (pos_x>lab.length-1 ||pos_x<0 || pos_y>lab[0].length-1 ||pos_y<0) {
			//System.out.println("sorti du cadre");
			return(false);
		}
		if (lab[pos_x][pos_y]!=0) {
			if (lab[pos_x][pos_y]==1) {
				return(true);
			}
			//System.out.println("mur");
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
		return dirpos;

	}
	public static int dirfant(List<Integer> dirpos) {
		int ou  = (int)(Math.random()*(dirpos.size()));
		int direction = dirpos.get(ou);
		return direction;
	}
	public static void deplacerfant(int direction, int[][] lab) {
		if (direction == 3 ){
			fantposition_y=fantposition_y+1;
		}
		else if (direction == 1){
			fantposition_y=fantposition_y-1;
		}
		else if (direction == 2 ){
			fantposition_x=fantposition_x+1;
		}
		else if (direction == 5){
			fantposition_x=fantposition_x-1;
		}
		
	}
	public static void heromonstre(int[][] lab) {
		
		double dist = (Math.abs(fantposition_x-Hero.heroposition_x)+Math.abs(fantposition_y-Hero.heroposition_y)-0.5);
		
				if (dist<0.5) {
					Hero.herosante -= 1;
						
					}
					}
							}
	
	
	
	