package acl_tests;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class GUI extends JFrame {
    private MazePanel mazePanel;
    private Player player;

    public GUI() {
        setTitle("Maze Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);

        try {
            BufferedImage playerImage = resizeImage(loadImage("player.png"), MazePanel.CELL_SIZE, MazePanel.CELL_SIZE);
            BufferedImage wallImage = resizeImage(loadImage("wall.png"), MazePanel.CELL_SIZE, MazePanel.CELL_SIZE);
            BufferedImage openImage = resizeImage(loadImage("pavement.png"), MazePanel.CELL_SIZE, MazePanel.CELL_SIZE);

            int[][] mazeArray =
                    { {1,1,1,1,1,1,1,1,1,1,1,1,1},
                            {1,0,1,0,1,0,1,0,0,0,0,0,1},
                            {1,0,1,0,0,0,1,0,1,1,1,0,1},
                            {1,0,0,0,1,1,1,0,0,0,0,0,1},
                            {1,0,1,0,0,0,0,0,1,1,1,0,1},
                            {1,0,1,0,1,1,1,0,1,0,0,0,1},
                            {1,0,1,0,1,0,0,0,1,1,1,0,1},
                            {1,0,1,0,1,1,1,0,1,0,1,0,1},
                            {1,0,0,0,0,0,0,0,0,0,1,9,1},
                            {1,1,1,1,1,1,1,1,1,1,1,1,1}
                    };

            mazePanel = new MazePanel(mazeArray, playerImage, wallImage, openImage);
            player = new Player(1, 1, mazePanel, playerImage);

            add(mazePanel);

            addKeyListener(new KeyListener() {

                public void keyTyped(KeyEvent e) {}


                public void keyPressed(KeyEvent e) {
                    player.move(e.getKeyCode());
                    mazePanel.repaint();  // Explicitly repaint the mazePanel
                }

                public void keyReleased(KeyEvent e) {}
            });

            setFocusable(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BufferedImage loadImage(String fileName) throws IOException {
        URL url = getClass().getResource(fileName);
        if (url != null) {
            return ImageIO.read(url);
        } else {
            throw new IOException("Unable to load image: " + fileName);
        }
    }

    private BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(resultingImage, 0, 0, null);
        g.dispose();
        return resizedImage;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GUI GUI = new GUI();
            GUI.setVisible(true);
        });
    }
}

class MazePanel extends JPanel {
    static final int CELL_SIZE = 40;
    int[][] mazeArray;
    private BufferedImage playerImage;
    private BufferedImage wallImage;
    private BufferedImage openImage;
    private Player player;  // Added Player instance

    public MazePanel(int[][] mazeArray, BufferedImage playerImage, BufferedImage wallImage, BufferedImage openImage) {
        this.mazeArray = mazeArray;
        this.playerImage = playerImage;
        this.wallImage = wallImage;
        this.openImage = openImage;
        this.player = new Player(1, 1, this, playerImage);  // Initialize Player
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i < mazeArray.length; i++) {
            for (int j = 0; j < mazeArray[i].length; j++) {
                int x = j * CELL_SIZE;
                int y = i * CELL_SIZE;

                if (mazeArray[i][j] == 1) {
                    g2d.drawImage(wallImage, x, y, null);
                } else {
                    g2d.drawImage(openImage, x, y, null);
                }
            }
        }

        player.draw(g2d);  // Call draw method of Player
    }
}


class Player {
    private int x;
    private int y;
    private MazePanel mazePanel;
    private BufferedImage playerImage;

    public Player(int initialX, int initialY, MazePanel mazePanel, BufferedImage playerImage) {
        this.x = initialX;
        this.y = initialY;
        this.mazePanel = mazePanel;
        this.playerImage = playerImage;
    }

    public void move(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_UP:
                if (isValidMove(x, y - 1)) {
                    y--;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (isValidMove(x, y + 1)) {
                    y++;
                }
                break;
            case KeyEvent.VK_LEFT:
                if (isValidMove(x - 1, y)) {
                    x--;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (isValidMove(x + 1, y)) {
                    x++;
                }
                break;
        }
    }

    private boolean isValidMove(int newX, int newY) {
        int row = newY / MazePanel.CELL_SIZE;
        int col = newX / MazePanel.CELL_SIZE;

        // Check if the move is within the maze bounds and not a wall
        return newX >= 0 && newY >= 0 &&
                newX < mazePanel.getWidth() && newY < mazePanel.getHeight() &&
                mazePanel.mazeArray[row][col] != 1;
    }

    public void draw(Graphics2D g) {
        g.drawImage(playerImage, x * MazePanel.CELL_SIZE, y * MazePanel.CELL_SIZE, null);
    }
}
