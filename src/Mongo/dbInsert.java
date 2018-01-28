package Mongo;

import Parser.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;


public class dbInsert {
    ArrayList<MovieItem> movieItems = new Parser().getMovieInfo();
    int size = movieItems.size();
    String query = "";

    public List<Document> prepareDocument() {
        Document document = new Document();
        List<Document> documents = new ArrayList<>();
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                document = new Document("type", "movieItem")
                        .append("moviePremier", movieItems.get(i).isMoviePremier())
                        .append("movieNameUkr", movieItems.get(i).getMovieNameUkr())
                        .append("movieNameEng", movieItems.get(i).getMovieNameEng())
                        .append("moviePosterUrl", movieItems.get(i).getMoviePosterUrl())
                        .append("movieGenre", movieItems.get(i).getMovieGenre())
                        .append("movieTime", movieItems.get(i).getMovieTime())
                        .append("moviePremierDay", movieItems.get(i).getMoviePremierDay())
                        .append("movieYear", movieItems.get(i).getMovieYear())
                        .append("movieCountry", movieItems.get(i).getMovieCountry())
                        .append("movieActors", movieItems.get(i).getMovieActors())
                        .append("movieProducer", movieItems.get(i).getMovieProducer())
                        .append("movieScenario", movieItems.get(i).getMovieScenario())
                        .append("movieTechnologies", movieItems.get(i).getMovieTechnologies())
                        .append("movieYoutubeUrl", movieItems.get(i).getMovieYoutubeUrl())
                        .append("movieYoutubeImg", movieItems.get(i).getMovieYoutubeImg());
                documents.add(document);
            }
        }
        return documents;
    }

    public void insertDocument(){
        MongoDatabase db = new connectToDB().createConnection(6);
        MongoCollection<Document> collection = db.getCollection("movieItems");
        collection.insertMany(prepareDocument());
    }
}
