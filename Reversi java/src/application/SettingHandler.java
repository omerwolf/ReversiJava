/*
 * Name : Yoel Jasner & Omer Wolf
 */
package application;

import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class SettingHandler {
	private Integer sizeOfBoard;
	private String myPlayer;
	private String startPlayer;
	String filePath = "settings.txt";
	private static final int NUM_0F_LINES = 3;
	

    /**
     *Default constructor for setting handler.
     */
	public SettingHandler(){}

    /**
     * Read from the settings file.
     */
	public void readSetting(){
		try {
			File file = new File(this.filePath);
			if (!file.exists()){
				file.createNewFile();
				defaultValues();
				writeSetting(sizeOfBoard, myPlayer, startPlayer);
				return;
			}
			 FileReader fileReader = new FileReader(file);
	         BufferedReader buffer = new BufferedReader(fileReader);
	         String readingLine;
	         for (int i = 0; i < NUM_0F_LINES; i++) {
	        	 readingLine = buffer.readLine();
	             if (i == 0)
	                 this.sizeOfBoard = Integer.parseInt(readingLine);
	
	             if (i == 1)
	                 this.myPlayer = readingLine;
	
	             if (i == 2)
	                 this.startPlayer = readingLine;
	
	         		}
	         fileReader.close();
		 } catch (Exception e) {
	         System.out.println("Can't read settings from file");
	
	         defaultValues();
	     }
	}
    /**
     * write to the settings file.
     * 
     * @param boardS- the size of board.
     * @param stratingP -the starting player.
     * @param myP - the current player.
     */
	public void writeSetting(Integer boardS, String stratingP, String myP) {	
		        try {
		            File file = new File(this.filePath);
	
		            if (!file.exists())
		                file.createNewFile();
	
		            FileWriter fileWriter = new FileWriter(file);
		            BufferedWriter buffer = new BufferedWriter(fileWriter);
		            buffer.write(boardS.toString());
		            buffer.newLine();
		            buffer.write(myP);
		            buffer.newLine();
		            buffer.write(stratingP);
		            buffer.close();
		        } catch (Exception e) {
		            System.out.println("Can't write settings to file");
		        }
		}
    /**
     * initializes a new settings file with default values.
     */
	private void defaultValues() {
	    this.sizeOfBoard = 8;
	    this.myPlayer = "BLACK";
	    this.startPlayer = "BLACK";
	}
    /**
     * Returns the board size.
     *
     * @return sizeOfBoard - the board size.
     */
	public Integer getSizeOfBoard() {
		return sizeOfBoard;
	}
    /**
     * Returns the current player.
     *
     * @return myPlayer - the current player.
     */
	public String getMyPlayer() {
		return myPlayer;
	}
	 /**
     * Returns the first player.
     *
     * @return myPlayer - the first player.
     */
	public String getStartPlayer() {
		return startPlayer;
	}
}
