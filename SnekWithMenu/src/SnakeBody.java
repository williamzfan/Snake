import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

public class SnakeBody extends GameObj{
    
    private List<Rectangle> snake;
    private Color color;
    private boolean started;

    
    
    public SnakeBody(Color color) {
        //super(0,0, courtWidth/2-GameCourt.SIZE, courtHeight/2, GameCourt.SIZE, GameCourt.SIZE,
          //      courtWidth, courtHeight);
        super(0, 0, GameCourt.COURT_WIDTH/2-GameCourt.SIZE, GameCourt.COURT_HEIGHT/2,
                GameCourt.SIZE, GameCourt.SIZE, GameCourt.COURT_WIDTH, GameCourt.COURT_HEIGHT);
        
        snake = new LinkedList<Rectangle>();
        this.color = color;
        started = false;

        
        
        
        snake.add(new Rectangle(GameCourt.COURT_WIDTH/2 - GameCourt.SIZE, 
                GameCourt.COURT_HEIGHT/2, GameCourt.SIZE, GameCourt.SIZE));
        snake.add(new Rectangle(GameCourt.COURT_WIDTH/2 - 2*GameCourt.SIZE, 
                GameCourt.COURT_HEIGHT/2, GameCourt.SIZE, GameCourt.SIZE));
        snake.add(new Rectangle(GameCourt.COURT_WIDTH/2 - 3*GameCourt.SIZE, 
                GameCourt.COURT_HEIGHT/2, GameCourt.SIZE, GameCourt.SIZE));
        
        
    }

    public void draw(Graphics g) {
        for(Rectangle s: snake) {
            g.setColor(this.color);
            g.fillRect(s.x, s.y, s.width-1, s.height-1);
        }
    }

    public void move() {
        
        if(getVx() != 0 || getVy() != 0) {
            Rectangle head = snake.get(0);
            
            if(getVy() < 0) {
                snake.add(0, new Rectangle(head.x, head.y-GameCourt.SIZE, 
                        GameCourt.SIZE, GameCourt.SIZE));
            }
            if(getVx() < 0) {
                //handle the case where user decides to go left first
                if(started == false) {

                    Rectangle temp = new Rectangle(snake.get(0).x, snake.get(0).y,
                            GameCourt.SIZE, GameCourt.SIZE);
                    snake.add(0, snake.get(2));
                    snake.remove(1);
                    snake.remove(1);
                    snake.add(temp);

                    setPx(snake.get(0).x);
                    setPy(snake.get(0).y);
                    head = snake.get(0);
                    
                    
                }
                snake.add(0, new Rectangle(head.x-GameCourt.SIZE, head.y, 
                        GameCourt.SIZE, GameCourt.SIZE));
                
            }
            if(getVx() > 0) {
                snake.add(0, new Rectangle(head.x+GameCourt.SIZE, head.y, 
                        GameCourt.SIZE, GameCourt.SIZE));
            }
            if(getVy() > 0) {
                snake.add(0, new Rectangle(head.x, head.y+GameCourt.SIZE, 
                        GameCourt.SIZE, GameCourt.SIZE));
            }
            started = true;
            setPx(getPx() + getVx());
            setPy(getPy() + getVy());
            snake.remove(snake.size()-1);
        }
    }
    
    
    public void grow() {
        
        Rectangle head = snake.get(0);
        if(getVy() < 0) {
            snake.add(0, new Rectangle(head.x, head.y-GameCourt.SIZE, 
                    GameCourt.SIZE, GameCourt.SIZE));
        }
        if(getVx() < 0) {
            snake.add(0, new Rectangle(head.x-GameCourt.SIZE, head.y, 
                    GameCourt.SIZE, GameCourt.SIZE));
        }
        if(getVx() > 0) {
            snake.add(0, new Rectangle(head.x+GameCourt.SIZE, head.y, 
                    GameCourt.SIZE, GameCourt.SIZE));
        }
        if(getVy() > 0) {
            snake.add(0, new Rectangle(head.x, head.y+GameCourt.SIZE, 
                    GameCourt.SIZE, GameCourt.SIZE));
        }
        setPx(getPx() + getVx());
        setPy(getPy() + getVy());
    }
    
    public boolean intersectsBody() {
        
        Rectangle head = snake.get(0);
        for(int i = 1; i < snake.size(); i++) {
            if (head.x >= snake.get(i).x
                    && head.y >= snake.get(i).y
                    && snake.get(i).x >= head.x
                    && snake.get(i).y >= head.y) {
                return true;
            }
        }
        
        
        return false;
    }
    
    public boolean isOutOfBounds() {
        return getPx() < 0 || getPy() < 0 || getPx() + GameCourt.SIZE > GameCourt.COURT_WIDTH || 
                getPy() + GameCourt.SIZE > GameCourt.COURT_HEIGHT;
    }
    

}
