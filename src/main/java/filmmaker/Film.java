package filmmaker;

import java.util.Objects;

public class Film {
    private String title;
    private String director;
    private Integer duration;

    public Film() {
    }


    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getDuration() {
        return duration;
    }
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return title.equals(film.title) && director.equals(film.director) && duration.equals(film.duration);
    }
    @Override
    public int hashCode() {
        return Objects.hash(title, director, duration);
    }
    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", duration=" + duration +
                '}';
    }
}
