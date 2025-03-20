// Source: https://www.geeksforgeeks.org/interfaces-in-java/
// Source: https://www.geeksforgeeks.org/polymorphism-in-java/
package org.howard.edu.lsp.midterm.question5;

/**
 * A driver class to test the streaming service with different media types.
 */
public class StreamingServiceDriver {
    /**
     * The main method that executes test cases for the streaming service.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Create instances of different media types
        Streamable music = new Music("Still a Friend - Incognito");
        Streamable movie = new Movie("Avengers End Game");
        Streamable audiobook = new Audiobook("A Promised Land – Barack Obama");

        // Test common behaviors for all media types
        System.out.println("Testing common behaviors for all media types:\n");

        // Test Music
        System.out.println("Testing Music:");
        music.play();
        music.pause();
        music.stop();
        System.out.println();

        // Test Movie
        System.out.println("Testing Movie:");
        movie.play();
        movie.pause();
        movie.stop();
        System.out.println();

        // Test Audiobook
        System.out.println("Testing Audiobook:");
        audiobook.play();
        audiobook.pause();
        audiobook.stop();
        System.out.println();

        // Test unique behaviors for each media type
        // Test Movie-specific behavior (rewind)
        Movie movieWithRewind = (Movie) movie;  // Cast to Movie for specific method
        movieWithRewind.rewind(30);
        System.out.println();

        // Test Audiobook-specific behavior (setPlaybackSpeed)
        Audiobook audiobookWithSpeed = (Audiobook) audiobook;  // Cast to Audiobook for specific method
        audiobookWithSpeed.setPlaybackSpeed(1.5);
        System.out.println();

        // Test Music-specific behavior (addToPlaylist)
        Music musicWithPlaylist = (Music) music;  // Cast to Music for specific method
        musicWithPlaylist.addToPlaylist("Favorites");
        System.out.println();
    }
}
