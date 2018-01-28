package Mongo;

import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;

public class connectToDB {

    public MongoDatabase createConnection(int permission){
            String[] userCredentials = new String[2];
            switch (permission){
                    case 6:{ //user allowed to read and write to database
                            userCredentials[0] = "writer:";
                            userCredentials[1] = "timeToUpdateBD";
                            break;
                    }
                    case 4:{ //user allowed only to read from db
                            userCredentials[0] = "customer:";
                            userCredentials[1] = "showmefilms";
                            break;
                    }
            }
            //db connection string
            MongoClientURI uri = new MongoClientURI(
                    "mongodb+srv://"+ userCredentials[0] + userCredentials[1] +"@cloudcinema-l2lx5.mongodb.net/test");

            // Creating a Mongo client
            MongoClient mongo = new MongoClient(uri);

            // Creating Credentials
            MongoCredential credential;
            credential = MongoCredential.createCredential(userCredentials[0], "CloudCinema",
                    userCredentials[1].toCharArray());

            MongoDatabase db = mongo.getDatabase("CloudCinema");

            return db;
    }

}


