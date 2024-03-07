import java.util.Scanner;

public class TextBasedAdventure {
    boolean hasSword = false;
    Scanner keyboardInput = new Scanner(System.in);

    int score = 0;

    public void execute() {
        System.out.println("Welcome to Escape from the Cave! Press enter when you are ready to start...");
        keyboardInput.nextLine();
        System.out.println("You are trapped in a cave!");
        start();
    }

    public void start() {
        System.out.println("You find yourself in a large room. What would you like to do?\n1. Go left \n2. Go right");
        int input = keyboardInput.nextInt();
        if (input == 1) {
            goLeft();
        }
        else if (input == 2) {
            goRight();
        }
    }

    public void goLeft() {
        System.out.println("Oh no! You run into a giant! Fight or flight?\n1. Fight \n2. Flight");
        int input = keyboardInput.nextInt();
        if (input == 1) {
            fight();
        }
        else if (input == 2) {
            System.out.println("You run away from the Giant.");
            start();
        }
    }

    public void goRight() {
        if (!hasSword) {
            getSword();
        }
        else {
            System.out.println("There's nothing here...");
        }
        start();
    }

    private void getSword() {
        System.out.println("You find a sword on the ground!");
        hasSword = true;
        score += 200;
    }

    public void fight() {
        if (hasSword) {
            System.out.println("You defeat the giant with your sword and run out of the cave!");
            score += 1000;
            victoryScreen();
        } else {
            System.out.println("You get stomped by the giant and red stuff goes everywhere.");
            deathScreen();
        }
    }


    public void victoryScreen() {
        System.out.printf("Congratulations! You have won!%nFinal Score: %s%n", score);
    }

    public void deathScreen() {
        System.out.printf("You have died.%nGame Over!%nFinal Score: %s%n", score);
    }


    public static void main(String[] args) {
        new TextBasedAdventure().execute();
    }
}