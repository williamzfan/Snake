import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class InstructionsMenu implements Menu{
    
    private String[] options = {"BACK"};
    private int selected = 0;

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(new Color(10, 10, 10));
        graphics.fillRect(0, 0, GameCourt.COURT_WIDTH, GameCourt.COURT_HEIGHT);
        
        
        graphics.setColor(Color.WHITE);
        graphics.drawString("INSTRUCTIONS", GameCourt.COURT_WIDTH/3, 100);
                
        graphics.drawString("Objective: Use arrow keys to move. "
                + "Eat food without", 100, 150);
        graphics.drawString("going out of bounds or colliding with body", 120, 170);
        
        graphics.drawString("Up: Move snake up.", GameCourt.COURT_WIDTH/3, 220);
        graphics.drawString("Down: Move snake down.", GameCourt.COURT_WIDTH/3, 240);
        graphics.drawString("Left: Move snake left.", GameCourt.COURT_WIDTH/3, 260);
        graphics.drawString("Right: Move snake right.", GameCourt.COURT_WIDTH/3, 280);
        
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

    @Override
    public void incSelected() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void decSelected() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getSelected() {
        return options[selected];
    }

}
