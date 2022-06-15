package Database;

import com.mongodb.client.*;
import org.bson.Document;
import org.bson.conversions.Bson;


public class MongoDBCustomer {
    public static MongoCollection ConnectionUserCustomer() {
        MongoClient mongoClient1 = MongoClients.create("mongodb://admin_user:admin_pass@10.10.10.241:27017/");
        MongoDatabase database = mongoClient1.getDatabase("ecommerceapp-mgezici");
        System.out.println(database);

        MongoCollection collectionU = database.getCollection("users-customer");
        Document document1 = new Document().
                append("name", "Murat").
                append("surname", "Gezici").append("username", "mgezici").
                append("email", "mgez@windowslive.com").append("address", "Ankara Golbasi").
                append("password", "123");
        collectionU.insertOne(document1);

        return collectionU;
    }
    public static Customer MongoUserCheckCustomer (String username, String password){
        MongoCollection collection = ConnectionUserCustomer();
        String abc = "";
        FindIterable<Document> fi = collection.find();
        MongoCursor<Document> cursor = fi.iterator();
        try {
            while (cursor.hasNext()) {
                Document temp = cursor.next();
                String users = temp.getString("username");
                String email = temp.getString("email");
                String pass = temp.getString("password");
                String id = temp.getObjectId("_id").toString();
                System.out.println(users + " " + pass);

                if((users.equals(username) || email.equals(username)  ) && pass.equals(password)){
                    String cname=temp.getString("name");
                    String cshortname=temp.getString("surname");
                    String address=temp.getString("address");
                    Customer comm = new Customer(id, cname, cshortname,users, email,address, pass );
                    return comm;
                }
            }
        } finally {
            cursor.close();
        }
        return null;
    }
    public static void mongoInsertCustomer(String cname, String cshortname, String username, String email, String address, String password){
        MongoCollection collection = ConnectionUserCustomer();

        Document document = new Document().
                append("name", cname).
                append("surname", cshortname).append("username", username).
                append("email", email).append("address", address).
                append("password", password);
        collection.insertOne(document);
    }


    public static void MongoDBUpdateCustomer(String _id, String cname, String cshortname, String username, String email, String address, String password){
        MongoCollection collection = ConnectionUserCustomer();
        FindIterable<Document> fi = collection.find();
        MongoCursor<Document> cursor = fi.iterator();
        try {
            while (cursor.hasNext()) {
                Document temp = cursor.next();
                if(_id.equals(temp.getObjectId("_id").toString())){
                    Document updatedVal = new Document().
                            append("name", cname).
                            append("surname", cshortname).append("username", username).
                            append("email", email).append("address", address).
                            append("password", password);
                    Bson updateOp = new Document("$set", updatedVal);
                    collection.updateOne(temp,updateOp);
                }

            }
        } finally {
            cursor.close();
        }

    }
}