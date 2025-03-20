package org.howard.edu.lsp.midterm.question3;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents an electronic voting machine that records votes for candidates.
 */
public class VotingMachine {
    private Map<String, Integer> votes;

    /**
     * Constructs a new VotingMachine with an empty candidate list.
     */
    public VotingMachine() {
        this.votes = new HashMap<>();
    }

    /**
     * Adds a candidate to the voting machine.
     *
     * @param candidate The name of the candidate.
     */
    public void addCandidate(String candidate) {
        if (!votes.containsKey(candidate)) {
            votes.put(candidate, 0);
        }
    }

    /**
     * Casts a vote for a given candidate.
     *
     * @param candidate The name of the candidate to vote for.
     * @return {@code true} if the vote was successfully cast, {@code false} if the candidate does not exist.
     */
    public boolean castVote(String candidate) {
        if (votes.containsKey(candidate)) {
            votes.put(candidate, votes.get(candidate) + 1);
            return true;
        }
        return false;
    }

    /**
     * Gets the name of the candidate with the most votes.
     *
     * @return A formatted string announcing the winner.
     */
    public String getWinner() {
        String winner = null;
        int maxVotes = 0;

        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }

        return (winner != null) ? winner + " WINS with " + maxVotes + " votes!!" : "No votes cast!";
    }
}
