package projacl;


import javax.swing.*;
import java.awt.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {

	int laby[][] = Labyrinthe.niveau1();

	Hero h = new Hero();
	Monstre z = new Monstre();
	Fantome f = new Fantome();

	//Potion Potion = new Potion(0,0);
	//Boolean potion_v = true;


	static final int UNIT_SIZE = 50;
	static final int SCREEN_WIDTH = 550;
	static final int SCREEN_HEIGHT = 650;
	static final int DELAY = 100;
	static final int temps_depl_z = 400;
	static final int temps_depl_f = 400;
	static final int longueur = SCREEN_WIDTH/UNIT_SIZE;
	static final int hauteur = SCREEN_HEIGHT/UNIT_SIZE;
	int time = -DELAY;
	boolean running = false;
	int win = 0;
	Timer timer;

	GamePanel() {

		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setBackground(Color.white);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());

		startGame();
	}

	public void startGame() {
		running = true;
		timer = new Timer(DELAY,this);
		timer.start();
	}

	//@Override
	public void actionPerformed(ActionEvent e) {
		if(running) {

			checkMort();
			if (time % temps_depl_f == 0) {
				
			}
			List<Integer> listedirf = Fantome.listdirpos(laby);
			int dirf = Fantome.dirfant(listedirf);
			Fantome.deplacerfant(dirf,laby);
			Fantome.heromonstre(laby);

			}
			if (time % temps_depl_f == 0) {
				List<Integer> listedir = Shrek.listdirpos(laby);
				int dir = Shrek.dirshrek(listedir);
				Shrek.deplacershrek(dir,laby);
				Shrek.heromonstre(laby);
			}
			//if (potion_v) {
				//checkPotion();
			//}
			time += DELAY;
		
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	public void draw(Graphics g) {
		if(running) {
			//draw_lines(g);
			draw_f(g);
			draw_z(g);
			//if (potion_v) {
				//draw_pot(g);
			//}
			draw_h(g);
			draw_p(g);
			draw_f(g);
			draw_z(g);
			draw_vie(g);
		}
		else {
			gameOver(g);
		}
	}

	public class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			int cmd = 0;
			switch(e.getKeyCode()) {
			case KeyEvent.VK_Q:
				cmd = 5;
				break;
			case KeyEvent.VK_D:
				cmd = 2;
				break;
			case KeyEvent.VK_Z:
				cmd = 1;
				break;
			case KeyEvent.VK_S:
				cmd = 3;
				break;
			}
			Hero.deplacerhero(cmd, laby);
		}
	}
	public void gameOver(Graphics g) {
		//Le joueur gagne
		if(win==1) {
			g.setColor(Color.red);
			g.setFont(new Font("Ink Free",Font.BOLD, 75));
			FontMetrics metrics1 = getFontMetrics(g.getFont());
			g.drawString("C'est gagné", (SCREEN_WIDTH - metrics1.stringWidth("C'est gagné"))/2, SCREEN_HEIGHT/2);
		}
		//Le joueur a perdu
		else {
			g.setColor(Color.red);
			g.setFont(new Font("Ink Free",Font.BOLD, 75));
			FontMetrics metrics2 = getFontMetrics(g.getFont());
			g.drawString("C'est perdu", (SCREEN_WIDTH - metrics2.stringWidth("C'est perdu"))/2,SCREEN_HEIGHT/2);
		}
	}
	
	public void draw_h(Graphics g) {
		BufferedImage image = null;
		try {
			 image = ImageIO.read(new File("src/hero.PNG"));
		}
		catch(IOException e) {
		}
		g.drawImage(image,UNIT_SIZE*Hero.heroposition_x,UNIT_SIZE*Hero.heroposition_y,UNIT_SIZE,UNIT_SIZE,null);
	}
	public void draw_p(Graphics g) {
		BufferedImage imagemur = null;
		BufferedImage imagetres = null;
		
		try {
			 imagemur = ImageIO.read(new File("src/mur.jpg"));
			 imagetres = ImageIO.read(new File("src/tresor.png"));
		}
		catch(IOException e) {
		}
		
		for (int i=0;i<laby.length;i++) {
			for (int j=0;j<laby[0].length;j++) {
				if (laby[i][j]==1){
					g.drawImage(imagemur, i*UNIT_SIZE, UNIT_SIZE*j, UNIT_SIZE, UNIT_SIZE, null);}
				else if (laby[i][j]==7){
					g.drawImage(imagetres, i*UNIT_SIZE, UNIT_SIZE*j, UNIT_SIZE, UNIT_SIZE, null);}
		
	}
	
	
}

	}
	
	public void draw_f(Graphics g) {
		BufferedImage image = null;
		try {
			 image = ImageIO.read(new File("src/fantome.PNG"));
		}
		catch(IOException e) {
		}
		g.drawImage(image,UNIT_SIZE*Fantome.fantposition_x,UNIT_SIZE*Fantome.fantposition_y,UNIT_SIZE,UNIT_SIZE,null);
	}
	
	public void draw_vie(Graphics g) {
		g.setColor(Color.red);
		for(int i = 0;i<h.get_santehero();i++) {
			g.fillOval(UNIT_SIZE*(longueur-1-i),0,30,30);
			g.fillOval(UNIT_SIZE*(longueur-1-i)+20,0,30,30);
			int[] x = {UNIT_SIZE*(longueur-1-i)+UNIT_SIZE/2,UNIT_SIZE*(longueur-1-i)+UNIT_SIZE-5,UNIT_SIZE*(longueur-1-i)+UNIT_SIZE/2,UNIT_SIZE*(longueur-1-i)+5};
			int[] y = {5,UNIT_SIZE/2,UNIT_SIZE-5,UNIT_SIZE/2};
			g.fillPolygon(x,y,4);
		}
	}
	public void checkMort() {
		if (h.get_santehero()<=0) {
			running = false;
		}
		if (Hero.heroposition_x == 8 && Hero.heroposition_y == 11 ) {
			win=1;
			running = false;
		}
	}
	public void draw_z(Graphics g) {
		BufferedImage image = null;
		try {
			 image = ImageIO.read(new File("src/zombie.PNG"));
		}
		catch(IOException e) {
		}
		g.drawImage(image,UNIT_SIZE*Shrek.shrekposition_x,UNIT_SIZE*Shrek.shrekposition_y,UNIT_SIZE,UNIT_SIZE,null);
	}
}
