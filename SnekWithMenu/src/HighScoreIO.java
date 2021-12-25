import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class HighScoreIO {
    
    
    public static void writeStringsToFile(List<String> stringsToWrite, String filePath) {
        File file = Paths.get(filePath).toFile();
        if (!file.exists()) {
            
            throw new IllegalArgumentException();
        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, false));
            for (int i = 0; i < stringsToWrite.size(); i++) {
                bw.write(stringsToWrite.get(i));
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("IOException in writeStringsToFile");
        }

    }
    
    
    public static List<String> fileToString(String filePath) {
        
        List<String> l = new LinkedList<String>();
        try {
            
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String str;
            
            str = reader.readLine();
            while(str != null) {
                l.add(str);
                str = reader.readLine();
            }
            reader.close();
            
        } catch (FileNotFoundException e) {
            
        } catch (IOException e) {
        }
        
        return l;
        
    }
    
    public static List<String> updateHighScores(String fileName, String name, int score) {
        List<String> l = new LinkedList<String>();
        
        l = fileToString(fileName);
        List<String> l2 = new LinkedList<String>();
        
        
        int n = 0;
        boolean bool = true;
        int size = l.size();
        for(int i = 0; i < 10 && i < size+1; i++) {
            if(i == size && bool) {
                l2.add(name + "," + score);
            }
            else if(score > Integer.parseInt(l.get(n).split(",")[1]) && bool) {
                bool = false;
                l2.add(name + "," + score);
            } else {
                l2.add(l.get(n));
                n++;
            }
        }
        writeStringsToFile(l2, fileName);
        
        return l2;
        
    }
    
    public static boolean isHighScore(String fileName, int score) {
        List<String> l = fileToString(fileName);
        if(l.size() < 10) {
            return true;
        }
        for(String s: l) {
            if(score > Integer.parseInt(s.split(",")[1])) {
                return true;
            }
        }
        return false;
    }

}
