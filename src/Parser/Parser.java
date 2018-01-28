package Parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;


public class Parser {

    public ArrayList getMovieInfo(){
        String URL = "https://vkino.ua/ua/ternopol";
        String USER_AGENT = "Chrome/19.0.1042.0";
        ArrayList<MovieItem> moviesArrayList = new ArrayList<MovieItem>();

        boolean moviePremier = false;
        String movieNameUkr = "";
        String movieNameEng = "";
        String moviePosterUrl = "";
        String movieGenre = "";
        String movieTime = "";
        String moviePremierDay = "";
        String movieYear = "";
        String movieCountry = "";
        String movieActors = "";
        String movieProducer = "";
        String movieScenario = "";
        String movieTechnologies = "";
        String movieYoutubeUrl = "";
        String movieYoutubeImg = "";
        String movieDescription = "";
        try {
            Document document = Jsoup.connect(URL)
                    .userAgent(USER_AGENT)
                    .get();
            Elements movieBoxes = document.getElementsByClass("film-box");
            for(Element movie : movieBoxes){
                document = Jsoup.connect("https://vkino.ua"+movie.getElementsByClass("film-title").tagName("a").attr("href"))
                        .userAgent(USER_AGENT)
                        .get();
                Element movieContent = document.getElementById("content");
                movieNameUkr = movieContent.select(".title.mobile-hidden").text();
                movieNameEng = movieContent.select(".sub-title.mobile-hidden").text();

                if(!movie.tagName("img").attr("src").equals("/images/loader.gif")){
                    String temp[] = movie.tagName("img").toString().split(",");
                    if (temp.length >= 4){
                        String temp2[] = temp[3].split("2x");
                        moviePosterUrl = temp2[0].replace(" ","");
                    } else {
                        String temp2[] = temp[2].split("2x");
                        moviePosterUrl = temp2[0].replace(" ","");
                    }
                }
                if(movie.getElementsByClass("premiere-title").text().equals("Прем`єра")) moviePremier = true;
                else moviePremier = false;
                Elements filmDataList = movieContent.select(".film-data-list > dt,dd");
                for (int i = 0; i < filmDataList.size()-1; i++) {
                    switch (filmDataList.get(i).select("dt").text()) {
                        case "Жанр:": movieGenre = filmDataList.get(i + 1).select("dd").text();
                            break;
                        case "Час:": movieTime = filmDataList.get(i + 1).select("dd").text();
                            break;
                        case "Прем`єра:": moviePremierDay = filmDataList.get(i + 1).select("dd").text();
                            break;
                        case "Рік:": movieYear = filmDataList.get(i + 1).select("dd").text();
                            break;
                        case "Країна:": movieCountry = filmDataList.get(i + 1).select("dd").text();
                            break;
                        case "У ролях:": movieActors = filmDataList.get(i + 1).select("dd").text();
                            break;
                        case "Режисер:": movieProducer = filmDataList.get(i + 1).select("dd").text();
                            break;
                        case "Сценарій:": movieScenario = filmDataList.get(i + 1).select("dd").text();
                            break;
                    }
                }
                movieTechnologies = movie.getElementsByClass("technologies-list").text();
                movieYoutubeUrl = movie.select(".btn-play").attr("data-youtube_url");
                movieYoutubeImg = movieContent.select(".player-thumbnail").attr("src");
                movieDescription = movieContent.select(".text-block").text();
                MovieItem readyMovie = new MovieItem(moviePremier,movieNameUkr,movieNameEng,moviePosterUrl,movieGenre,
                        movieTime,moviePremierDay,movieYear,movieCountry,movieActors,movieProducer,movieScenario,movieTechnologies,movieYoutubeUrl,movieYoutubeImg,movieDescription);
                moviesArrayList.add(readyMovie);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return moviesArrayList;
    }
}
