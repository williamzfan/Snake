import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.awt.Color;

import org.junit.jupiter.api.Test;




public class SnakeTest {
    
    private int width = 600;
    private int height = 600;
    private int size = 20;
    
    private int initX = 280;
    private int initY = 300;

    @Test
    public void moveRight() {
        GameObj s = new SnakeBody(Color.GREEN);
        s.setVx(size);
        s.move();
        assertEquals(s.getPx(), initX + size);
        s.move();
        assertEquals(s.getPx(), initX + 2*size);
    }
    
    @Test
    public void moveUp() {
        GameObj s = new SnakeBody(Color.GREEN);
        s.setVy(size);
        s.move();
        assertEquals(s.getPy(), initY + size);
        s.move();
        assertEquals(s.getPy(), initY + 2*size);
    }
    
    @Test
    public void moveDown() {
        GameObj s = new SnakeBody(Color.GREEN);
        s.setVy(-size);
        s.move();
        assertEquals(s.getPy(), initY - size);
        s.move();
        assertEquals(s.getPy(), initY - 2*size);
    }
    
    
    /*
     * If user starts by moving left, the head needs to be changed so that it's the leftmost
     * rectangle in the list.
     */
    
    @Test
    public void moveLeft() {
        GameObj s = new SnakeBody(Color.GREEN);
        s.setVx(-size);
        s.move();
        assertEquals(s.getPx(), initX - 3*size);
        s.move();
        assertEquals(s.getPx(), initX - 4*size);
    }
    
    @Test
    public void grow() {
        GameObj s = new SnakeBody(Color.GREEN);
        s.setVx(size);
        s.move();
        ((SnakeBody) s).grow();
        assertEquals(s.getPx(), initX + 2*size);
    }
    
    @Test
    public void eatFoodGrow() {
        GameObj s = new SnakeBody(Color.GREEN);
        GameObj f = new Food(Color.RED);
        int xDir = 1;
        if(s.getPx() > f.getPx()) {
            xDir*=-1;
            
        }
        s.setVx(size*xDir);
        while(s.getPx() != f.getPx()) {
            s.move();
        }
        
        int yDir = 1;
        if(s.getPy() > f.getPy()) {
            yDir*=-1;
            
        }
        s.setVy(size*yDir);
        int fy = f.getPy();
        while(s.getPy() != f.getPy()) {
            s.move();
        }
        
        assertTrue(s.intersects(f));
        ((SnakeBody) s).grow();
        
        assertEquals(s.getPy(), fy + yDir*size);
        
        s.move();
        assertEquals(s.getPy(), fy + yDir*2*size);
    }

    
    @Test
    public void intersectsBody() {
        GameObj s = new SnakeBody(Color.GREEN);
        s.setVx(size);
        s.move();
        ((SnakeBody) s).grow();
        ((SnakeBody) s).grow();
        ((SnakeBody) s).grow();
        s.setVy(-size);
        s.move();
        s.setVx(-size);
        s.move();
        s.setVy(size);
        s.move();
        assertTrue(((SnakeBody) s).intersectsBody());
    }
    
    @Test
    public void outOfBounds() {
        GameObj s = new SnakeBody(Color.GREEN);
        s.setVy(-size);
        for(int i = 0; i < 15; ++i) {
            s.move();
        }
        assertFalse(((SnakeBody) s).isOutOfBounds());
        s.move();
        assertTrue(((SnakeBody) s).isOutOfBounds());
    }
    
    

}