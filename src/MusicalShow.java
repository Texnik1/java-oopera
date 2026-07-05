import java.util.List;

public class MusicalShow extends Show{
    private String musicAuthor;
    private String librettoText;

    public MusicalShow(String title, int duration, Director director, String musicAuthor,
                       String librettoText) {
        super(title, duration, director);
        this.musicAuthor = musicAuthor;
        this.librettoText = librettoText;
    }

    public String getMusicAuthor() {
        return musicAuthor;
    }

    public String getLibrettoText() {
        return librettoText;
    }

    // Распечатать текст либретто
    public void printLibretto() {
        System.out.println("Либретто спектакля \"" + getTitle() + "\":\n" + librettoText);
    }

    @Override
    public String toString() {
        return super.toString() + "\nАвтор музыки: " + musicAuthor;
    }
}
