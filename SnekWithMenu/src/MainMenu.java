import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class MainMenu implements Menu {
    
    private String[] options = {"START", "INSTRUCTIONS"};
    private int selected = 0;
    
    public MainMenu() {
        
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(new Color(10, 10, 10));
        graphics.fillRect(0, 0, GameCourt.COURT_WIDTH, GameCourt.COURT_HEIGHT);
        
        
        
        graphics.setFont(new Font("Arial", Font.PLAIN, 35));
        graphics.setColor(Color.RED);
        graphics.drawString("SNAKE", GameCourt.COURT_WIDTH/2-100, 50);
        
        
        
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Arial", Font.PLAIN, 20));
        //graphics.drawString("Use arrow keys to navigate menu options."
          //      , GameCourt.COURT_WIDTH/5, 70);
        for(int i=0;i<options.length;i++) {
            if(selected == i) {
                graphics.setColor(Color.GREEN);
            }
            else {
                graphics.setColor(Color.WHITE);
            }

            graphics.drawString(options[i], GameCourt.COURT_WIDTH/3, 190 + 100 * i);
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
