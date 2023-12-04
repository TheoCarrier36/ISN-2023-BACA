package Labyrinthe;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class premierniveau {
	    public static void main(String[] args) {
	        String filePath = "/Users/jibril/Documents/labyrinthe1.txt";
	        try {
	            FileReader lecture = new FileReader(filePath);
	            BufferedReader buffer = new BufferedReader(lecture);
	            String a;

	            while ((a = buffer.readLine()) != null) {
	                System.out.println(a);
	            }
	            buffer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	   }
}

