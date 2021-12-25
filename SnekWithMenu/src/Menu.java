
import java.awt.Graphics;

public interface Menu {
        
    /**Called in GameScreen#paintComponent<br>
     * Renders everything that should be rendered in this state
     * @param graphics - Graphics object
     */
    public void render(Graphics graphics);
    
    public void incSelected();
    
    public void decSelected();
    
    public String getSelected();

}
