import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;

public class HighScoreMenu implements Menu{
    
    private String[] options = {"PLAY AGAIN", "MAIN MENU"};
    private int selected = 0;
    private String fileName = "HighScores.txt";
    private List<String> hs;
    
    public HighScoreMenu() {
        hs = HighScoreIO.fileToString(fileName);
    }
    
    public HighScoreMenu(String s, int i) {
        //hs = HighScoreIO.updateHighScores(fileName, s, i);
        hs = HighScoreIO.fileToString(fileName);
    }

    /*
    public HighScoreMenu(int i) {
        hs = HighScoreIO.updateHighScores(fileName, "UNKNOWN", i);
    }*/
    @Override
    public void render(Graphics graphics) {
        graphics.setColor(new Color(10, 10, 10));
        graphics.fillRect(0, 0, GameCourt.COURT_WIDTH, GameCourt.COURT_HEIGHT);
        
        
        graphics.setColor(Color.BLUE);
        graphics.drawString("HIGH SCORES", GameCourt.COURT_WIDTH/3, 100);
        
        graphics.setColor(Color.white);
        
        int n = 120;
        for(String s: hs) {
            String s1 = s.split(",")[0];
            String s2 = s.split(",")[1];
            graphics.drawString(s1 + " " + s2, GameCourt.COURT_WIDTH/3, n);
            n+=20;
        }
        
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Arial", Font.PLAIN, 20));
        for(int i=0;i<options.length;i++) {
            if(selected == i) 
                graphics.setColor(Color.GREEN);
            else
                graphics.setColor(Color.WHITE);
            
            graphics.drawString(options[i], GameCourt.COURT_WIDTH/3, 390 + 100 * i);
        }
        
    }

    public void incSelected (){
        if(selected < options.length-1) {
            selected++;
        }
    }
    
    public void decSelected () {  
        if(selected > 0) { 
            selected--;
        }
    }
    
    public String getSelected() {
        return options[selected];
    }
    
    

}
