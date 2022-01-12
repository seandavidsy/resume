// Virginia Tech Honor Code Pledge:
// As a Hokie, I will conduct myself with honor and integrity at all times. I
// Will not lie, cheat, or steal, nor will I accept the actions of those who do
// -- Sean Sy (906311775)

package game;
import cs2.Window; 
import cs2.Button;
import cs2.CircleShape;
import cs2.WindowSide;
import cs2.Shape;
import cs2.SquareShape;
import cs2.TextShape;
import java.awt.Color;
import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * This class creates the GUI functionality used for the project
 * 
 * @author Sean Sy (906311775)
 * @version 2020.10.05
 */
public class WhackAShape {

    private SimpleBagInterface<Shape> bag;
    private Window window;
    private TestableRandom randomGenerator = new TestableRandom();
    
    /**
     * Default WhackAShape constructor used to create a new WhackAShape object
     */
    public WhackAShape() {
        
        bag = new SimpleArrayBag<Shape>();
        window = new Window("Whack A Shape");
        
        Button quit = new Button("Quit");
        window.addButton(quit, WindowSide.SOUTH);
        quit.onClick(this, "clickedQuit");
        
        String[] shapes = {"red circle", "blue circle",
            "red square", "blue square"};
        int size = randomGenerator.nextInt(6) + 7; 
        for (int i = 0; i < size; i++) {  
            int random = randomGenerator.nextInt(shapes.length);
            Shape shape = buildShape(shapes[random]);
            bag.add(shape);
        }     
        window.addShape(bag.pick());
    }
    
    /**
     * WhackAShape constructor used to create a new WhackAShape object
     * that fills the bag with shapes from the inputed String array
     * 
     * @param inputs user inputed strings as shapes to add to the bag
     */
    public WhackAShape(String[] inputs) {
        
        bag = new SimpleArrayBag<Shape>();    
        window = new Window("Whack A Shape");
        
        Button quit = new Button("Quit");
        window.addButton(quit, WindowSide.SOUTH);
        quit.onClick(this, "clickedQuit");

        for (int i = 0; i < inputs.length; i++) {
            try {
                buildShape(inputs[i]);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            bag.add(buildShape(inputs[i]));
        }
        
        window.addShape(bag.pick());       
    }
    
    /**
     * Getter method to return the bag field
     *
     * @return bag field
     */
    public SimpleBagInterface<Shape> getBag() {
        
        return bag;
    }
    
    /**
     * Getter method to return the window field
     * 
     * @return window field
     */
    public Window getWindow() {
        
        return window;
    }
    
    /**
     * Causes the window to close
     * 
     * @param button will close the window when clicked
     */
    public void clickedQuit(Button button) {
        
        System.exit(0);
    }
    
    /**
     * Displays a new Shape object from the bag every time
     * it is clicked if the bag is not empty. If the bag is
     * empty it will display "You Win!" in center of screen
     * 
     * @param shape current shape that displays new shape when clicked
     */
    public void clickedShape(Shape shape) {
        
        window.removeShape(shape);
        bag.remove(shape);
        
        TextShape text = new TextShape(0, 0, "You Win!");
        Shape nextShape = bag.pick();
        if (nextShape == null) {
            int width = (window.getGraphPanelWidth() - text.getWidth()) / 2;
            int height = (window.getGraphPanelHeight() - text.getHeight()) / 2;
            text.moveTo(width, height);
            window.addShape(text);
        }
        else {
            window.addShape(nextShape);
        }
    }
    
    /**
     * Creates a shape of random size in a random location in the window,
     * either being a red square, red circle, blue square, or blue circle
     * dependent on the input
     * 
     * @param input the String form of the shape to be created
     * @return the created Shape object
     * @throws IllegalArgumentException if input is not one of the
     * four recognized shapes
     */
    public Shape buildShape(String input) {
        
        int size = randomGenerator.nextInt(101) + 100;
        int width = randomGenerator.nextInt
            (window.getGraphPanelWidth() - size);
        int height = randomGenerator.nextInt
            (window.getGraphPanelHeight() - size);
        
        Shape currentShape = new Shape(0, 0);
        
        if (!input.contains("red") && !input.contains("blue") &&
            !input.contains("circle") && !input.contains("square")) {
            throw new IllegalArgumentException();
        }
        
        if (input.contains("red") && input.contains("circle")) {
            currentShape = new CircleShape(width, height, size, Color.RED);
        }
        if (input.contains("blue") && input.contains("circle")) {
            currentShape = new CircleShape(width, height, size, Color.BLUE);
        }
        if (input.contains("red") && input.contains("square")) {
            currentShape = new SquareShape(width, height, size, Color.RED);
        }
        if (input.contains("blue") && input.contains("square")) {
            currentShape = new SquareShape(width, height, size, Color.BLUE);
        }
        
        currentShape.onClick(this, "clickedShape");
        return currentShape;
    }
}
