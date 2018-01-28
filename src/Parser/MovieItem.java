package Parser;

public class MovieItem {

    private boolean moviePremier;
    private String movieNameUkr;
    private String movieNameEng;
    private String moviePosterUrl;
    private String movieGenre;
    private String movieTime;
    private String moviePremierDay;
    private String movieYear;
    private String movieCountry;
    private String movieActors;
    private String movieProducer;
    private String movieScenario;
    private String movieTechnologies;
    private String movieYoutubeUrl;
    private String movieYoutubeImg;
    private String movieDescription;

    public MovieItem(boolean moviePremier, String movieNameUkr, String movieNameEng, String moviePosterUrl,
                     String movieGenre, String movieTime, String moviePremierDay, String movieYear,
                     String movieCountry, String movieActors, String movieProducer, String movieScenario,
                     String movieTechnologies, String movieYoutubeUrl, String movieYoutubeImg, String movieDescription){
        this.moviePremier = moviePremier;
        this.movieNameUkr = movieNameUkr;
        this.movieNameEng = movieNameEng;
        this.moviePosterUrl = moviePosterUrl;
        this.movieGenre = movieGenre;
        this.movieTime = movieTime;
        this.moviePremierDay = moviePremierDay;
        this.movieYear = movieYear;
        this.movieCountry = movieCountry;
        this.movieActors = movieActors;
        this.movieProducer = movieProducer;
        this.movieScenario = movieScenario;
        this.movieTechnologies = movieTechnologies;
        this.movieYoutubeUrl = movieYoutubeUrl;
        this.movieYoutubeImg = movieYoutubeImg;
        this.movieDescription = movieDescription;
    }

    public boolean isMoviePremier() {
        return moviePremier;
    }

    public String getMovieNameUkr() {
        return movieNameUkr;
    }

    public String getMovieNameEng() {
        return movieNameEng;
    }

    public String getMoviePosterUrl() {
        return moviePosterUrl;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public String getMovieTime() {
        return movieTime;
    }

    public String getMoviePremierDay() {
        return moviePremierDay;
    }

    public String getMovieYear() {
        return movieYear;
    }

    public String getMovieCountry() {
        return movieCountry;
    }

    public String getMovieActors() {
        return movieActors;
    }

    public String getMovieProducer() {
        return movieProducer;
    }

    public String getMovieScenario() {
        return movieScenario;
    }

    public String getMovieTechnologies() {
        return movieTechnologies;
    }

    public String getMovieYoutubeUrl() {
        return movieYoutubeUrl;
    }

    public String getMovieYoutubeImg() {
        return movieYoutubeImg;
    }

    public String getMovieDescription() {
        return movieDescription;
    }
}
