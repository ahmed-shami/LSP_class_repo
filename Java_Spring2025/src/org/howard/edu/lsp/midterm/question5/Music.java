package org.howard.edu.lsp.midterm.question5;

/**
 * Represents a music track that can be streamed.
 */
public class Music implements Streamable {
    private String title;

    /**
     * Constructs a Music object with a title.
     *
     * @param title The title of the music track.
     */
    public Music(String title) {
        this.title = title;
    }

    @Override
    public void play() {
        System.out.println("Playing music: " + title);
    }

    @Override
    public void pause() {
        System.out.println("Paused music: " + title);
    }

    @Override
    public void stop() {
        System.out.println("Stopped music: " + title);
    }

    /**
     * Adds the music track to a playlist.
     *
     * @param playlistName The name of the playlist.
     */
    public void addToPlaylist(String playlistName) {
        System.out.println("Added " + title + " to " + playlistName + " playlist");
    }
}
