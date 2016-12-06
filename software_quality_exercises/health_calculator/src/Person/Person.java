package Person;

public class Person {
    private Genre genre;
    private int age;
    private double tall;
    private double weight;

    public Person(String genre, double tall, double weight) {
        this.genre = Genre.valueOf(genre);
        this.tall = tall;
        this.weight = weight;
    }

    public Person(String genre, int age, double tall, double weight) {
        this.genre = Genre.valueOf(genre);
        this.age = age;
        this.tall = tall;
        this.weight = weight;
    }

    public String getGenre() {
        return genre.name();
    }
    public int getGenreNumber() {
        return genre.ordinal();
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getTall() {
        return tall;
    }

    public void setTall(double tall) {
        this.tall = tall;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
