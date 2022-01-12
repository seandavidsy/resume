//Virginia Tech Honor Code Pledge:
//As a Hokie, I will conduct myself with honor and integrity at all times. I
//Will not lie, cheat, or steal, nor will I accept the actions of those who do
//-- Sean Sy (906311775)
package towerofhanoi;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;

/**
 * 
 * 
 * @author Sean Sy 906311775
 * @version 10/20/2020
 */
public class PuzzleWindow implements Observer {

    private HanoiSolver game;
    private Shape left;
    private Shape middle;
    private Shape right;
    private Window window;
    public static final int WIDTH_FACTOR = 20;
    public static final int DISK_GAP = 0;
    public static final int DISK_HEIGHT = 15;
    
    private void moveDisk(Position position) {
        
        Disk currentDisk = game.getTower(position).peek();
        Shape currentPole;
        switch (position) {
            case LEFT:
                currentPole = left;
                break;
            case MIDDLE:
                currentPole = middle;
                break;
            case RIGHT:
                currentPole = right;
                break;
            default:
                currentPole = middle;
                break;
        }
        int diskWidth = currentDisk.getWidth();
        int poleX = currentPole.getX();
        int poleY = currentPole.getHeight() * 2;
        
        currentDisk.moveTo(poleX - diskWidth,
            poleY - DISK_HEIGHT * (game.getTower(position).size()));
        
    }
    
    public PuzzleWindow(HanoiSolver game) {
        
        this.game = game;
        this.game.addObserver(this);
        window = new Window("Tower of Hanoi");
        int midHeight = window.getGraphPanelHeight() / 2;
        left = new Shape(100, midHeight, 25, midHeight, Color.RED);
        middle = new Shape(300, midHeight, 25, midHeight, Color.GREEN);
        right = new Shape(500, midHeight, 25, midHeight, Color.BLUE);
        Disk[] disks = new Disk[this.game.disks()];
        
        for (int i = disks.length - 1; i >= 0; i--) {
            disks[i] = new Disk(i * WIDTH_FACTOR);
            window.addShape(disks[i]);
            game.getTower(Position.RIGHT).push(disks[i]);
            moveDisk(Position.RIGHT);
        }
        
        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);
        
        Button solve = new Button("Solve");
        window.addButton(solve, WindowSide.SOUTH);
        solve.onClick(this, "clickedSolve");
    }
    
    @Override
    public void update(Observable o, Object arg) {
        
        if (arg.getClass() == Position.class) {
            moveDisk((Position)arg);
            sleep();
        }
        
    }
    
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }


    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }

}
