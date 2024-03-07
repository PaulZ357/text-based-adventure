import java.util.Random;
import java.util.Scanner;

public class TextBasedAdventure {
    boolean hasSword = false;
    Scanner keyboardInput = new Scanner(System.in);

    int score = 0;
    final int giantScore = 1000;

    public void execute() {
        System.out.println("Welcome to Escape from the Cave! Press enter when you are ready to start...");
        keyboardInput.nextLine();
        System.out.println("You are trapped in a cave!");
        start();
    }

    public void start() {
        System.out.println("You find yourself in a large room. What would you like to do?\n1. Go left \n2. Go right\n3. Go straight\n4. Go back");
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
        else if (input == 4){
            goBack();
        }
    }

    public void goBack(){
        System.out.println("A big boulder blocked your path back! It seems like the cave is caving in!! Some entrances may be blocked.. take your best guess");
        System.out.println("What would you like to do?\n1. Go left \n2. Go right\n3. Go straight");
        Random random = new Random();
        int rolledNumber = random.nextInt(4);
        int input = keyboardInput.nextInt();
        if (rolledNumber == 3){
            System.out.println("Your path was nearly blocked, but somehow you made it!");
        }

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
        int keepGoingCounter = 0;
        while (wandering){
            System.out.println("You seem to have wandered into a long hallway. It might go on forever. What would you like to do?\n1. Go back\n2. Keep going");
            int input = keyboardInput.nextInt();
            if (input ==1){
                start();
            }
            else if (input == 2){
                keepGoingCounter++;
                wandering = !(keepGoingCounter == 5);
            }
        }
        System.out.println("The hallway ended and you escaped the cave!");
        
    }

    public void goLeft() {
        System.out.println("Oh no! You run into a giant! Fight, flight, or freeze?\n1. Fight \n2. Flight\n3. Freeze");
        int input = keyboardInput.nextInt();
        if (input == 1) {
            fight();
        }
        else if (input == 2) {
            System.out.println("You run away from the Giant.");
            start();
        }
        else if (input == 3) {
            freeze();
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
        Random random = new Random();
        int rolledNumber = random.nextInt(5);
        if (hasSword) {
            System.out.println("You defeat the giant with your sword and run out of the cave!");
            score += giantScore;
            victoryScreen();
        } else if (rolledNumber == 3) {
            System.out.println("You defeat the giant with your bare hands and run out of the cave!");
            score += giantScore;
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


    public void freeze() {
        System.out.println("You decided to not do anything and the giant decided to leave you alone without a single hit. You are no longer anxious.");
    }

    public static void main(String[] args) {
        new TextBasedAdventure().execute();
    }
}