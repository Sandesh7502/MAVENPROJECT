public class Game {
    private Controller controller;

    public Game(Controller controller) {
        this.controller = controller;
        // Initialize the decision tree and other game logic here in later phases
    }

    // Add methods for game logic in later phases

    public void play() {
        // Simplified game loop for Phase 1
        help(); // Display the help message

        boolean playAgain = true;

        while (playAgain) {
            // Replace with actual game logic in later phases
            if (controller.choose("Is your animal a cat?")) {
                playAgain = controller.choose("I won! Play again?");
            } else {
                playAgain = controller.choose("You won! Play again?");
            }
        }
    }

    private void help() {
        controller.display("Think of an animal. If my tree is non-empty, I will ask some yes/no questions to try to determine what it is.");
    }

    // Other game-related methods to be implemented in later phases
}
