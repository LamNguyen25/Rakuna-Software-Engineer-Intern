import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int nbFloors = in.nextInt(); // number of floors
        int width = in.nextInt(); // width of the area
        int nbRounds = in.nextInt(); // maximum number of rounds
        int exitFloor = in.nextInt(); // floor on which the exit is found
        int exitPos = in.nextInt(); // position of the exit on its floor
        int nbTotalClones = in.nextInt(); // number of generated clones
        int nbAdditionalElevators = in.nextInt(); // ignore (always zero)
        int nbElevators = in.nextInt(); // number of elevators

        // HashMap stores floor on which this elevator is found and position of the elevator on its floor
        Hashtable<Integer, Integer> elevators = new Hashtable<Integer, Integer>();

        for (int i = 0; i < nbElevators; i++) {
            int elevatorFloor = in.nextInt(); // floor on which this elevator is found
            int elevatorPos = in.nextInt(); // position of the elevator on its floor
            elevators.put(elevatorFloor, elevatorPos);
        }

        // game loop
        while (true) {
            int cloneFloor = in.nextInt(); // floor of the leading clone
            int clonePos = in.nextInt(); // position of the leading clone on its floor
            String direction = in.next(); // direction of the leading clone: LEFT or RIGHT
            int currentExitPos = 0; // the position the clone should be
            boolean isCorrectDirection = true; //Check to see if the leading clone is going in the right direction

            // If the leading clone is on the exit floor 
            if(cloneFloor == exitFloor) {
                currentExitPos = exitPos;
            }
            // if the leading clone is on the floor which this elevator is found
            else if(elevators.containsKey(cloneFloor)){
                currentExitPos = elevators.get(cloneFloor);
            }
            // Check to see if the leadig clone is going in the right direction
            if((clonePos > currentExitPos && direction.equals("RIGHT")) || (clonePos < currentExitPos && direction.equals("LEFT"))) {
                isCorrectDirection = false;
            }

            if(isCorrectDirection == true) {
                System.out.println("WAIT");
            }
            else {
                System.out.println("BLOCK");
            }
            
        }
    }
}