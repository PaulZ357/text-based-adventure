import java.util.Scanner;

public class TextBasedAdventure {
    boolean hasSword = false;
    Scanner keyboardInput = new Scanner(System.in);

    public void execute() {
        System.out.println("Welcome to Escape from the Cave! Press enter when you are ready to start...");
        keyboardInput.nextLine();
        System.out.println("You are trapped in a cave!");
        start();
    }

    public void start() {
        System.out.println("You find yourself in a large room. What would you like to do?\n1. Go left \n2. Go right\n3. Go straight");
        int input = keyboardInput.nextInt();
        if (input == 1) {
            goLeft();
        }
        else if (input == 2) {
            goRight();
        }
        else if (input == 3){
            goStraight();
        }
    }

    public void goStraight(){
        boolean wandering = true;
        while (wandering){
            System.out.println("You seem to have wandered into a long hallway. It might go on forever. What would you like to do?\n1. Go back\n2. Keep going");
            int input = keyboardInput.nextInt();
            if (input ==1){
                start();
            }
            else if (input == 2){
                // it will loop again
            }
        }
        
    }

    public void goLeft() {
        System.out.println("Oh no! You run into a giant! Fight, flight, or freeze?\n1. Fight \n2. Flight\n3. Freeze");
        int input = keyboardInput.nextInt();
        if (input == 1) {
            fight();
        }
        else if (input == 2) {
            start();
        }  
        else if (input == 3) {
            freeze();
        }  
    }

    public void goRight() {
        if (!hasSword) {
            System.out.println("You find a sword on the ground!");
            hasSword = true;
        }
        else {
            System.out.println("There's nothing here...");
        }
        start();
    }

    public void fight() {
        if (hasSword) {
            System.out.println("You defeat the giant with your sword and run out of the cave!");
        } else {
            System.out.println("You get stomped by the giant and red stuff goes everywhere.");
        }
    }

    public void freeze() {
        System.out.println("You decided to not do anything and the giant decided to leave you alone without a single hit. You are no longer anxious.");
    }

    public static void main(String[] args) {
        new TextBasedAdventure().execute();
    }
}