=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=
CIS 120 Game Project README
PennKey: willfan
=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=

===================
=: Core Concepts :=
===================

- List the four core concepts, the features they implement, and why each feature
  is an appropriate use of the concept. Incorporate the feedback you got after
  submitting your proposal.

  1. Collections: (I switched to collections instead of 2d array to store snake). I used collections
throughout this project. For instance, I used linked lists to store high scores and eventually
print them on screen. To store the snake, I used a linked list of rectangles that vary in x and y
positions to correspond to the snake. To display the snake, I iterated through the linked list
and printed individual rectangles. This is appropriate because it is an efficient way to store
the snake since each individual rectangle that has a different x and y position that correspond
to the shape of the snake.

  2. Testable: I wrote test cases to test the game state. In particular, I checked that the snake's
movement worked, that it grew appropriately, that it correctly registered when it intersected food,
went out of bounds, and intersected its own body. These cases are extensive and cover everything
that can happen in snake. This is appropriate because I want to be able to make sure that the
Snake works correctly independent of the GUI

  3. Inheritance/Dynamic Dispatch: I used inheritance in multiple ways. I first had snake
and food inherit from gameobj. This was useful to check when the snake intersected the food and
should thus, grow. The biggest way I used inheritance/dynamic dispatch was through my menu class.
Since my game has multiple menus i.e. Main menu, high score menu, instructions menu etc., that all
have the same basic properties but differ in actual implementation and display, I found that
inheritance was appropriate. I used a menu interface and these specific menus all implemented it.
All of their "render" methods were different which allowed for the different appearances when
displayed on the screen but their overall structure was the same. They all had options for users
to choose and appropriately reacted when users selected options. It was also useful in GameCourt
as I had a menu field but the type of menu field could change based on what the user wanted.

  4. Input/Output: I used IO to store high scores and display them when the user requested to see
  the high score menu. High scores are consistent even between different game sessions meaning
  you can close the application and the high scores will still be the same when you open it back up.
  That is possible because of IO which was appropriate because it allowed me to store information
  efficiently and storing in a txt file meant it could stay consistent between different sessions.
  I created static methods to write a users score (plus a username they can enter if the program
  recognizes it is a high score) to the file and also methods to read in the top 10 users/scores.

=========================
=: Your Implementation :=
=========================

- Provide an overview of each of the classes in your code, and what their
  function is in the overall game.
  Food: A gameobj that when a snake intersects it, the snake grows.
  Game: Same as in template code. Basically lays foundations for displaying and setting up game.
  GameCourt: Displays the game (paint component), has the appropriate key listeners, stores
  what menu the user is in and displays it as appropriate.
  GameObj: Superclass for snake and food. They are objects in the game.
  GameOverMenu: A menu that displays when the game is over. Gives user option of playing again
  or seeing high scores.
  HighScoreIO: Has static methods that aid with IO and high scores.
  HighScoreMenu: Menu that displays all the high scores and gives user chance to play again or go
  back to main menu.
  InstructionsMenu: Menu that displays instructions on how to play game and option to go back to
  main menu.
  MainMenu: Main menu that allows you to play or view instructions.
  Menu: interface that serves as basis for menu classes
  SnakeBody: Representation of snake that handles how the snake is stored, movement etc.


- Were there any significant stumbling blocks while you were implementing your
  game (related to your design, or otherwise)?

N/A

- Evaluate your design. Is there a good separation of functionality? How well is
  private state encapsulated? What would you refactor, if given the chance?
I think there is a really good separation of functionality as most of the model is independent
of the GUI. Everything is encapsulated except for GameCourt size which is used throughout the
program. Not much I'd change.


========================
=: External Resources :=
========================

- Cite any external resources (libraries, images, tutorials, etc.) that you may
  have used while implementing your game.

None. I read up on things like drawString(), setColor(), drawRect() etc. for graphics. 

