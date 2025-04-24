package org.howard.edu.lspfinal.question2;

/**
 * Exception thrown when attempting to add a duplicate task.
 */
public class DuplicateTaskException extends Exception {
    public DuplicateTaskException(String message) {
        super(message);
    }
}
