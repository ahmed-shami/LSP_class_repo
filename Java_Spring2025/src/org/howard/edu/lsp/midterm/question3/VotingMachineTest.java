package org.howard.edu.lsp.midterm.question3;

/**
 * A driver class to test the VotingMachine class.
 */
public class VotingMachineTest {
    /**
     * The main method that executes the test cases for VotingMachine.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        VotingMachine vm = new VotingMachine();

        // Adding candidates
        vm.addCandidate("Alice");
        vm.addCandidate("Bob");
        vm.addCandidate("Charlie");

        // Casting votes
        vm.castVote("Alice");
        vm.castVote("Alice");
        vm.castVote("Bob");
        vm.castVote("Charlie");
        vm.castVote("Charlie");
        vm.castVote("Charlie");

        // Attempt to vote for a non-existent candidate
        boolean success = vm.castVote("Eve");
        System.out.println("Vote for Eve successful? " + success);

        // Displaying results
        System.out.println("Winner: " + vm.getWinner());
    }
}
