package org.howard.edu.lsp.midterm.question2;

/**
 * Represents a book in the library.
 * This class stores details about a book, including its title, author, ISBN, and year of publication.
 */
public class Book {
    private String title;
    private String author;
    private String ISBN;
    private int yearPublished;

    /**
     * Constructs a new Book with the specified details.
     *
     * @param title         The title of the book.
     * @param author        The author of the book.
     * @param ISBN          The ISBN number of the book (a unique identifier).
     * @param yearPublished The year the book was published.
     */
    public Book(String title, String author, String ISBN, int yearPublished) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.yearPublished = yearPublished;
    }

    /**
     * Gets the title of the book.
     *
     * @return The book title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     *
     * @param title The new title to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the author of the book.
     *
     * @return The book author.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author of the book.
     *
     * @param author The new author to set.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets the ISBN number of the book.
     *
     * @return The book's ISBN.
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * Sets the ISBN number of the book.
     *
     * @param ISBN The new ISBN to set.
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * Gets the year the book was published.
     *
     * @return The year of publication.
     */
    public int getYearPublished() {
        return yearPublished;
    }

    /**
     * Sets the year the book was published.
     *
     * @param yearPublished The new year of publication to set.
     */
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    /**
     * Determines whether two books are equal based on their ISBN and author.
     *
     * @param obj The object to compare with.
     * @return {@code true} if both books have the same ISBN and author, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return this.ISBN.equals(book.ISBN) && this.author.equals(book.author);
    }

    /**
     * Returns a string representation of the book with all its details.
     *
     * @return A formatted string containing book details.
     */
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN + ", Year Published: " + yearPublished;
    }
}
