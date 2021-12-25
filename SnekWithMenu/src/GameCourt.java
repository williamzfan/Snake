import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameCourt extends JPanel {
    
    private SnakeBody snake;
    private Food food;
    private boolean playing = false;
    private JLabel status;
    
    private Menu menu = new MainMenu();
    
    private int score;
    
    public static final int COURT_WIDTH = 600;
    public static final int COURT_HEIGHT = 600;
    
    public static final int SIZE = 20;
    
    public static final int INTERVAL = 50;
    
    public GameCourt(JLabel status) {
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        Timer timer = new Timer(INTERVAL, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tick();
            }
        });
        timer.start();
        score = 0;
        
        setFocusable(true);
        
        
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    
                    if(menu == null) {
                        if(snake.getVx() <= 0) {
                            snake.setVx(-SIZE);
                        }
                    } else if (menu instanceof MainMenu) {
                        
                    }

                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    
                    if(menu == null) {
                        if(snake.getVx() >= 0) {
                            snake.setVx(SIZE);
                        }
                    } else if (menu instanceof MainMenu) {
                        
                    }


                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    
                    if(menu == null) {
                        if(snake.getVy() >= 0) {
                            snake.setVy(SIZE);
                        }
                    } else if (menu instanceof MainMenu) {
                        menu.incSelected();
                    } else if (menu instanceof GameOverMenu) {
                        menu.incSelected();
                    } else if (menu instanceof HighScoreMenu) {
                        menu.incSelected();
                    }


                } else if (e.getKeyCode() == KeyEvent.VK_UP){
                    if(menu == null) {
                        if(snake.getVy() <= 0) {
                            snake.setVy(-SIZE);
                        }
                    } else if (menu instanceof MainMenu) {
                        menu.decSelected();
                    } else if (menu instanceof GameOverMenu) {
                        menu.decSelected();
                    } else if (menu instanceof HighScoreMenu) {
                        menu.decSelected();
                    }


                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if(menu == null) {
                        
                    } else if (menu instanceof MainMenu) {
                        if(menu.getSelected().equals("START")) {
                            menu = null;
                            reset();
                        } else if (menu.getSelected().equals("INSTRUCTIONS")) {
                            menu = new InstructionsMenu();
                            status.setText("Press enter to go back.");
                        }
                    } else if (menu instanceof GameOverMenu) {
                        if(menu.getSelected().equals("PLAY AGAIN")) {
                            menu = null;
                            reset();
                        } else if (menu.getSelected().equals("HIGH SCORES")) {
                            menu = new HighScoreMenu();
                            
                        }
                        status.setText("Use arrow keys to navigate between menu options.");
                    } else if (menu instanceof HighScoreMenu) {
                        if(menu.getSelected().equals("PLAY AGAIN")) {
                            menu = null;
                            reset();
                        } else if (menu.getSelected().equals("MAIN MENU")) {
                            menu = new MainMenu();
                        }
                        status.setText("Use arrow keys to navigate between menu options.");
                    } else if (menu instanceof InstructionsMenu) {
                        menu = new MainMenu();
                        status.setText("Use arrow keys to navigate between menu options.");
                    }
                }
                
            }
                  

            public void keyReleased(KeyEvent e) {
            }
        });      
            
            
        
        
        
        
        this.status = status;
        status.setText("Welcome! Use arrow keys to navigate between menu options.");
        
        
        
    }
    
    
    
    void tick() {
        if (playing) {
            //if(snake.getPx() < 0 || snake.getPy() < 0 || snake.getPx() + 
              //      GameCourt.SIZE > COURT_WIDTH || snake.getPy() + GameCourt.SIZE > COURT_HEIGHT) {
            if(snake.isOutOfBounds()) {
                playing = false;
                menu = new GameOverMenu();
                if(HighScoreIO.isHighScore("HighScores.txt", score)) {
                    String s;
                    s = JOptionPane.showInputDialog("You got a high score! Enter name: ");
                    if(s == null || s.length() == 0) {
                        s = "UNKNOWN";
                    }
                    HighScoreIO.updateHighScores("HighScores.txt", s, score);
                }
                status.setText("GAME OVER\n SCORE: " + score);
            } else if (snake.intersectsBody()) {

                playing = false;
                menu = new GameOverMenu();
                if(HighScoreIO.isHighScore("HighScores.txt", score)) {
                    String s = "UNKNOWN";
                    s = JOptionPane.showInputDialog("You got a high score! Enter name: ");
                    HighScoreIO.updateHighScores("HighScores.txt", s, score);
                }
                status.setText("GAME OVER\n SCORE: " + score);
            }
            else {
                if(snake.intersects(food)) {
                    score+=1;
                    snake.grow();
                    status.setText("Score: " + score);
                    food = new Food(Color.RED);
                }
                snake.move();
                //repaint();
            }            
        }
        repaint();
    }
    
    
    public void reset() {
        
        //snake = new Snake(COURT_WIDTH, COURT_HEIGHT, Color.GREEN);
        snake = new SnakeBody(Color.GREEN);
        food = new Food(Color.RED);
        score = 0;
        playing = true;
        status.setText("Score: " + score);
        

        requestFocusInWindow();
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(menu != null) {
            menu.render(g);
        } else {
            g.setColor(new Color(10, 10,10));
            g.fillRect(0, 0, GameCourt.COURT_WIDTH, GameCourt.COURT_HEIGHT);
            snake.draw(g);
            food.draw(g);
        }
        
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(COURT_WIDTH, COURT_HEIGHT);
    }


    
    
    
}