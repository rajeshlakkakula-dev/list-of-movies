package rajesh.com.listofmovies;

/**
 * Created by rajesh on 3/18/2018.
 */

public class Movies {
    private String movie_name;
    private String movie_image_url;
    private String movie_cast_and_crew;
    private String movie_rating;

    public Movies(String movie_name, String movie_image_url, String movie_cast_and_crew, String movie_rating) {
        this.movie_name = movie_name;
        this.movie_image_url = movie_image_url;
        this.movie_cast_and_crew = movie_cast_and_crew;
        this.movie_rating = movie_rating;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getMovie_image_url() {
        return movie_image_url;
    }

    public void setMovie_image_url(String movie_image_url) {
        this.movie_image_url = movie_image_url;
    }

    public String getMovie_cast_and_crew() {
        return movie_cast_and_crew;
    }

    public void setMovie_cast_and_crew(String movie_cast_and_crew) {
        this.movie_cast_and_crew = movie_cast_and_crew;
    }

    public String getMovie_rating() {
        return movie_rating;
    }

    public void setMovie_rating(String movie_rating) {
        this.movie_rating = movie_rating;
    }
}
