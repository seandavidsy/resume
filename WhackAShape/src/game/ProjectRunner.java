// Virginia Tech Honor Code Pledge:
// As a Hokie, I will conduct myself with honor and integrity at all times. I
// Will not lie, cheat, or steal, nor will I accept the actions of those who do
// -- Sean Sy (906311775)

package game;

public class ProjectRunner {

    /**
     * Main method used to run the project
     * 
     * @param args checks arguments to choose the correct constructor
     */
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        
        if (args.length > 0) {
            WhackAShape game = new WhackAShape(args);
        }
        else {
            WhackAShape game = new WhackAShape();
        }
    }
}
