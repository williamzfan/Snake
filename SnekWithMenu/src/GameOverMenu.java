import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class GameOverMenu implements Menu{
    
    private String[] options = {"PLAY AGAIN", "HIGH SCORES"};
    private int selected = 0;

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(new Color(10, 10, 10));
        graphics.fillRect(0, 0, GameCourt.COURT_WIDTH, GameCourt.COURT_HEIGHT);
        
        
        graphics.setColor(Color.RED);
        graphics.drawString("GAME OVER", GameCourt.COURT_WIDTH/3, 100);
        
        
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Arial", Font.PLAIN, 20));
        for(int i=0;i<options.length;i++) {
            if(selected == i) 
                graphics.setColor(Color.GREEN);
            else
                graphics.setColor(Color.WHITE);
            
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
