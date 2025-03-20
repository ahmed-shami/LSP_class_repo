package org.howard.edu.lsp.midterm.question5;

/**
 * Represents a streamable media type with common behaviors.
 */
public interface Streamable {
    /**
     * Plays the media.
     */
    void play();

    /**
     * Pauses the media.
     */
    void pause();

    /**
     * Stops the media.
     */
    void stop();
}
