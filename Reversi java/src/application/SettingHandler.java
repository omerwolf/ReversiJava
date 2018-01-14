package application;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class SettingHandler {
private Integer sizeOfBoard;
private String myPlayer;
private String startPlayer;
String filePath = "settings.txt";
private static final int NUM_0F_LINES = 3;


public SettingHandler(){}

public void readSetting(){
	try {
		File file = new File(filePath);
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
public void writeSetting(Integer boardS, String myP, String stratingP) {	
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

private void defaultValues() {
    this.sizeOfBoard = 8;
    this.myPlayer = Color.BLACK.toString();
    this.startPlayer = "player1";
}

public Integer getSizeOfBoard() {
	return sizeOfBoard;
}

public String getMyPlayer() {
	return myPlayer;
}

public String getStartPlayer() {
	return startPlayer;
}

}
