package com.company;

import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.text.DecimalFormat;

public class Main {

    /*******************************************************
    This method asks for the user name and returns the name
    ********************************************************/
    public static String GetUserName() {
        // Variable declarations
        String userName = "";                   // String object to hold user name
        Scanner scan = new Scanner(System.in);  // Scanner object to get user input

        // Prompt user to enter name
        System.out.print("What is your name? (enter your name): ");
        userName = scan.nextLine();
        System.out.println();
        System.out.println("Hi " + userName + "!  Nice to meet you! ");

        // Return the user name
        return userName;
    }

    /*******************************************************
    This method asks the user if they want to continue the program or not
     *******************************************************/
    public static boolean AskUserYesNo() {
        // Variable declarations
        String userInput = "";                  // User input string
        Scanner scan = new Scanner(System.in);  // Scanner object for user input

        // Prompt comes outside method before, just take in user input
        System.out.print("(enter \"Yes\" or \"No\"): ");
        userInput = scan.nextLine();

        // Validate whether user input is ok, and continue asking until right
        while (!userInput.equalsIgnoreCase("y") &&
                !userInput.equalsIgnoreCase("yes") &&
                !userInput.equalsIgnoreCase("n") &&
                !userInput.equalsIgnoreCase("no")) {
            System.out.print("That is not a valid input.  Please try again.  ");
                    System.out.print("Enter \"Yes\" or \"No\": ");
            userInput = scan.nextLine();
        }

        // Extra line for better readability
        System.out.println("");

        // Return true if user says yes, and false if user says no
        if (userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes")) {
            return true;
        } else {
            return false;
        }
    }

    /*******************************************************
    This method returns the name of whatever the user inputs
     *******************************************************/
    public static String GetNameOfThing() {
        // Variable declarations
        String userInput = "";                  // User input string
        Scanner scan = new Scanner(System.in);  // Scanner object for name

        System.out.print("(enter name): ");
        userInput = scan.nextLine();

        return userInput;
    }

    /********************************************************
    This is the part where you're trying to escape the planet
     ********************************************************/
    public static boolean EscapeOriginPlanet(String planet, String galaxy, String spaceship) {
        // Declaration of variables
        Scanner scan = new Scanner(System.in);        // Scanner object for user input
        Random rand = new Random();                   // Random number generator
        int literFuel = rand.nextInt(3000);     // Amount of fuel in spaceship
        int userInput = 0;                            // user input integer
        final int LITER_FUEL_NEEDED = 3000;           // amount of fuel needed

        // Oh no! Planet is in danger and we need to leave
        // Ask the user to calculate how much fuel is needed.
        System.out.println("Planet " + planet + " is in danger!!  It is about to explode!!");
        System.out.println("Everyone aboard The " + spaceship + "!  We're leaving!");
        System.out.println("The " + spaceship + " needs at least " + LITER_FUEL_NEEDED +
                            " liters of Super Fuel to leave Planet " + planet + "!");
        System.out.println("It has " + literFuel + " liters right now...");
        System.out.print("At least how many more liters are needed? (enter number of liters): ");
        userInput = scan.nextInt();
        System.out.println("");

        System.out.println("Ok, blast off!!!!!!");

        if (userInput >= (LITER_FUEL_NEEDED - literFuel)) {
            System.out.println("Yes!!  We escaped Planet " + planet + "!!!!!!");
            System.out.println("");
            return true;
        }
        else {
            System.out.println("Uh oh... Something's wrong.........");
            System.out.println("The " + spaceship + " is running out of fuel!!! We're crashing!!!");
            System.out.println("");
            return false;
        }
    }

    /********************************************************
    This is the part where you're trying to get out from the Galaxy
     ********************************************************/
    public static boolean EscapeOriginGalaxy(String originGalaxy, String destinationGalaxy, String spaceship) {
        // Declaration of variables
        Scanner scan = new Scanner(System.in);                                  // Scanner object for user input
        double distToGalaxy = ThreadLocalRandom.current().nextDouble(200000, 1000000000);  // distance of Galaxy
        double speedShip = ThreadLocalRandom.current().nextDouble(1.0, 100.00);            // speed of ship
        double userInput = 0.0;                                                 // user input integer
        double correctYears = distToGalaxy / speedShip;                         // The correct number of years the machine should be set
        DecimalFormat df = new DecimalFormat("#.##");                    // For formatting the numbers to two decials places

        // Getting to the final galaxy takes a while,
        // Let's calculate when we have to wake up
        System.out.println("We've reached the edge of the " + originGalaxy + " Galaxy.");
        System.out.println("Wow!  The distance from the " + originGalaxy + " Galaxy to the " + destinationGalaxy +
                            " Galaxy is " + df.format(distToGalaxy) + " light years...");
        System.out.println("Let's go into our hibernation receptacle so we don't age while we travel.");
        System.out.println("The " + spaceship + " is travelling at " + df.format(speedShip) + " light years per year.");
        System.out.print("When should we set the hibernation receptacle to wake us up? \n" +
                        "Remember, the receptacle uses A LOT of energy upon waking us up,\n" +
                        "so we can only let it wake us up once...  (Enter number of years with at least two decimal places): ");
        userInput = scan.nextDouble();
        System.out.println("");

        // Let's sleep
        System.out.println("Ok, let's get in the receptacle and sleep until our destination Galaxy...\n......zzzzzz......");
        for (int i = 1; i <= 10; i++) {
            System.out.println("......zzzzzz......");
        }

        // Determine whether user input is correct or not
        // If correct, return true
        if (Math.abs(userInput - correctYears) < 0.0001) {
            System.out.println("Time to wake up!.....\nLook! We arrived at the " + destinationGalaxy + " Galaxy!!");
            return true;
        }
        // If overslept, then we die
        if ((userInput - correctYears) > 0.0001) {
            System.out.println("Time to wake up!.....\n" +
                               "Wait, the " + destinationGalaxy + " Galaxy is behind us according to the interstellar radar!\n" +
                               "Oh no!!! We don't have any power left in The " + spaceship + " to turn around!!!");
            return false;
        }
        // else if we sleep too less, then we run out of power and we die.
        else {
            System.out.println("Time to wake up!.....\n" +
                               "Wait, the " + destinationGalaxy + " Galaxy is still too far according to the interstellar radar!\n" +
                               "Oh no!!! We don't have any power left in The " + spaceship + " to keep us going!!!");
            return false;
        }
    }

    /********************************************************
    This is the part where your companion gets sick
     ********************************************************/
    public static boolean InterGalaxySickness(String spaceship, String companion) {
        // Variable declarations
        Scanner scan = new Scanner(System.in);                                  // Scanner object for user input
        Random rand = new Random();                                             // Random number generator
        int companionWeight = rand.nextInt(195) + 45;                     // companion is from 45 to 150 kgs
        final int POTION_PORTION = 3;                                           // Per kg potion mL
        int userInput = 0;                                                      // user input amount

        // Prompt user on how much Super Potion is needed to save the user's companion
        System.out.println("Oh no!  " + companion + " is sick with the Intra-galaxy virus!");
        System.out.println("Without " + companion + ", The " + spaceship + " can't be flown properly!");
        System.out.println("Let's get the Super Potion!");
        System.out.println("You need " + POTION_PORTION + " mL of the Super Potion per kgs of body weight.");
        System.out.println(companion + " is " + companionWeight + " kgs.");
        System.out.println("If you provide more than the needed amount, " + companion + " can overdose and die!");
        System.out.print("How many mL of Super Potion do you need? (enter a whole number): ");
        userInput = scan.nextInt();
        System.out.println("");

        // Determine whether user input will save companion
        // Right amount will save the companion
        if (userInput == (companionWeight * POTION_PORTION)) {
            System.out.println("Yes!  " + companion + " is recovering and in good shape!");
            return true;
        }
        // Too less than companion dies
        else if (userInput < (companionWeight * POTION_PORTION)) {
            System.out.println("Oh no!  " + companion + " is not getting any better!");
            System.out.println(companion + " seems to be dying!");
            System.out.println("Without " + companion + ", the ship is spiraling out of control!");
            System.out.println("AHHHHHH!!!");
            return false;
        }
        // Too much than companion dies
        else {
            System.out.println("Oh no!  " + companion + " is turning purple!");
            System.out.println(companion + " seems to be dying!");
            System.out.println("Without " + companion + ", the ship is spiraling out of control!");
            System.out.println("AHHHHHH!!!");
            return false;
        }
    }

    public static boolean LandTheShip(String planet, String galaxy, String spaceship) {
        // Variable declarations
        final String specialFeature1 = "Mega Susension Blaster Switch";         // Feature
        Scanner scan = new Scanner(System.in);                                  // Scanner object for user input
        Random rand = new Random();                                             // Random number generator


        // This is based on complete luck, you need luck to survive in space
        // Perhaps add more features to ask whether
        System.out.println("Ok, we've arrived at Planet " + planet + " in the " + galaxy + " Galaxy!");
        System.out.println("We just need to land The " + spaceship + "!!");
        System.out.print("The main-control status pane in the cockpit is asking whether the " + specialFeature1 +
                           " should be engaged.  Should it? ");
        AskUserYesNo();

        // This is why it is completely random
        if (rand.nextInt(1) == 0) {

            return true;
        }
        else {
            return false;
        }

    }

    /********************************************************
    This is the main program
     ********************************************************/
    public static void main(String[] args) {
	    // Variable declarations
        // Standard variables
        String userName = "";               // String to hold user name
        boolean continueProgram = true;     // boolean to determine whether program should continue
        boolean answerYes;                  // Boolean to store user answer yes/no.  Yes = true, No = false
        boolean storyContinues = true;      // Boolean to see if the story continues, based on state
        int gameState = 0;                  // Game state variable, used for switch
        // Name of objects in game
        String spaceshipName = "";          // name of spaceship
        String companionName = "";          // name of companion
        String originPlanet = "";           // name of origin plant
        String destinationPlanet = "";      // name of destination planet
        String originGalaxy = "";           // name of origin galaxy
        String destinationGalaxy = "";      // name of destination galaxy

        // Welcome user and ask for name
        System.out.print("Welcome!  ");
        userName = GetUserName();

        // Ask user if he/she wants to play a game
        System.out.print("Would you like to play a game? ");
        answerYes = AskUserYesNo();
        if (answerYes == false) {
            System.out.println("That's too bad... ");
            continueProgram = false;
        }

        // Loop while the user wants to play the game
        while (continueProgram) {

            // Congratulate user on bravery to play a game
            System.out.println("Great, " + userName + "!!\n");

            // Ask user about the things in the story
            System.out.println("First, I need to ask you some questions...");
            System.out.println("You are a captain of a spaceship.");
            System.out.print("What is the name of your spaceship? ");
            spaceshipName = GetNameOfThing();
            System.out.print("Who is your co-pilot on The " + spaceshipName + "? ");
            companionName = GetNameOfThing();
            System.out.print("What planet are you and " + companionName + " from? ");
            originPlanet = GetNameOfThing();
            System.out.print("And what galaxy is Planet "  + originPlanet + " located?");
            originGalaxy = GetNameOfThing();
            System.out.print("What planet are you trying to get to? ");
            destinationPlanet = GetNameOfThing();
            System.out.print("And what galaxy is Planet " + destinationPlanet + " located?");
            destinationGalaxy = GetNameOfThing();
            System.out.println("Thanks " + userName + "!  Let's begin our journey\n");

            // Initialize gameState
            gameState = 0;


            // TODO: the condition needs to be adjusted depending on the story state
            while (storyContinues) {
                switch (gameState) {
                    case 0: // Escape the planet
                            if (EscapeOriginPlanet(originPlanet, originGalaxy, spaceshipName) == true) {
                                gameState = 1;
                            }
                            else {
                                gameState = 6;  // dead
                            }
                            break;

                    case 1: // Escape the galaxy, if we're going to a different galaxy
                            if (!originGalaxy.equalsIgnoreCase(destinationGalaxy) &&
                                    EscapeOriginGalaxy(originGalaxy, destinationGalaxy, spaceshipName)) {
                                gameState = 2;
                            }
                            // If travelling in the same galaxy, land and help companion
                            else if (originGalaxy.equalsIgnoreCase(destinationGalaxy) &&
                                    InterGalaxySickness(spaceshipName, companionName)) {
                                gameState = 3;
                            }
                            else {
                                gameState = 6;  // dead
                            }
                            break;

                    case 2: // TODO: add one more game state here
                            gameState = 3;
                            break;

                    case 3: // Let's land the ship
                            if (LandTheShip(destinationPlanet, destinationGalaxy, spaceshipName)) {

                            }
                            else {
                            gameState = 5; // dead
                            }
                            break;

                    case 4: // You survived!
                            System.out.println("Great job!  You, " + companionName + ", and the people on " +
                                                spaceshipName + " have survived the journey through space!!!");
                            System.out.println("");
                            storyContinues = false;
                            break;

                    case 5: // You are dead
                            System.out.println("You, along with " + companionName + " and the people on The " +
                            spaceshipName + " are now dead; just a dust in the universe...");
                            storyContinues = false;
                            break;

                    default: // Shouldn't get here
                             System.out.println("Uh oh, something went wrong in the program!!");
                             System.out.println("");
                             storyContinues = false;
                             break;
                }
            }


            // Ask the user if they want to continue
            System.out.print("Do you want to play again? ");
            continueProgram = AskUserYesNo();
        }

        // Exit message
        System.out.println("Thanks for playing " + userName + "!  See you next time!");

    }
}
