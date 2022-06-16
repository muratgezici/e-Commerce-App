package Database;

import com.mongodb.client.*;
import org.bson.Document;
import org.bson.conversions.Bson;


public class MongoDBCommercial {
    public static MongoCollection ConnectionUserCommercial() {
        MongoClient mongoClient1 = MongoClients.create("mongodb://admin_user:admin_pass@10.10.10.241:27017/");
        MongoDatabase database = mongoClient1.getDatabase("ecommerceapp-mgezici");
        System.out.println(database);

        MongoCollection collectionS = database.getCollection("users-commercial");
      //  Document document1 = new Document().
      //          append("company_name", "Migros Ticaret A.Ş.").
      //          append("company_sname", "Migros").append("username", "migros").append("email", "migros@migros.com").append("address", "Istanbul Merkez Ofis").append("password", "123");
     //   collectionS.insertOne(document1);

        return collectionS;
    }
        public static Commercial MongoUserCheckCommercial (String username, String password){
           MongoCollection collection = ConnectionUserCommercial();
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
                        String cname=temp.getString("company_name");
                        String cshortname=temp.getString("company_sname");
                        String address=temp.getString("address");
                        Commercial comm = new Commercial(id, cname, cshortname,users, email,address, pass );
                        return comm;
                    }
                }
            } finally {
                cursor.close();
            }
            return null;
        }
        public static void mongoInsertCommercial(String cname, String cshortname, String username, String email, String address, String password){
            MongoCollection collection = ConnectionUserCommercial();

            Document document = new Document().
                    append("company_name", cname).
                    append("company_sname", cshortname).append("username", username).
                    append("email", email).append("address", address).
                    append("password", password);
            collection.insertOne(document);
        }


public static void MongoDBUpdateCommercial(String _id, String cname, String cshortname, String username, String email, String address){
    MongoCollection collection = ConnectionUserCommercial();
    FindIterable<Document> fi = collection.find();
    MongoCursor<Document> cursor = fi.iterator();
    try {
        while (cursor.hasNext()) {
            Document temp = cursor.next();
            if(_id.equals(temp.getObjectId("_id").toString())){
                Document updatedVal = new Document().
                        append("company_name", cname).
                        append("company_sname", cshortname).append("username", username).
                        append("email", email).append("address", address);
                Bson updateOp = new Document("$set", updatedVal);
               collection.updateOne(temp,updateOp);
            }

        }
    } finally {
        cursor.close();
    }

}
    }