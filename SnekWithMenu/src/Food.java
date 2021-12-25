import java.awt.Color;
import java.awt.Graphics;

public class Food extends GameObj{
    
    private Color color;
    
    public Food(Color c) {
        super(0, 0,((int) (Math.random() * (GameCourt.COURT_WIDTH/GameCourt.SIZE))) * GameCourt.SIZE, 
                ((int) (Math.random() * (GameCourt.COURT_HEIGHT/GameCourt.SIZE))) * GameCourt.SIZE
                , GameCourt.SIZE, GameCourt.SIZE, GameCourt.COURT_WIDTH, GameCourt.COURT_HEIGHT);
        color = c;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillRect(this.getPx(), this.getPy(), this.getWidth(), this.getHeight());
    }

}
