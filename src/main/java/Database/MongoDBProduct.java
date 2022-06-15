package Database;

import com.mongodb.client.*;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MongoDBProduct {
    public static MongoCollection ConnectionProducts() {
        MongoClient mongoClient1 = MongoClients.create("mongodb://admin_user:admin_pass@10.10.10.241:27017/");
        MongoDatabase database = mongoClient1.getDatabase("ecommerceapp-mgezici");
        System.out.println(database);
        //mongoClient1.listDatabaseNames().forEach(System.out::println);
        //database.listCollectionNames().forEach(System.out::println);

        MongoCollection collection = database.getCollection("products");
        ArrayList<String> as = new ArrayList();
        as.add("s");
        as.add("b");
        Document document1 = new Document().
                append("sid", "birüçbeş").
                append("name", "Migros").append("desc", "migros").
                append("price", "migros@migros.com").append("stock_quantity", "Istanbul Merkez Ofis").
                append("add_date", "123").append("ex_date", "123").append("category", "123");//.append("tags",as);
        collection.insertOne(document1);

        return collection;
    }
        public static Product MongoGetProduct (String _id){
           MongoCollection collection = ConnectionProducts();
            FindIterable<Document> fi = collection.find();
            MongoCursor<Document> cursor = fi.iterator();
            try {
                while (cursor.hasNext()) {
                    Document temp = cursor.next();

                    String id = temp.getString("_id");

                    if(id.equals(_id)){
                        String sid = temp.getString("sid");
                        String name = temp.getString("name");
                        String desc = temp.getString("desc");
                        String price = temp.getString("price");
                        String stock_quantity = temp.getString("stock_quantity");
                        Date add_date = temp.getDate("add_date");
                        Date ex_date = temp.getDate("ex_date");
                        String category = temp.getString("category");
                        //ArrayList<String> tags = (ArrayList<String>) temp.getList("tags", String.class);
                            Product pro = new Product(id,sid,name,desc,price,stock_quantity,add_date,ex_date,category);
                        return pro;
                    }
                }
            } finally {
                cursor.close();
            }
            return null;
        }
        public static void mongoInsert(String sid, String name, String desc, String price, String stock_quantity, String add_date, String ex_date, String category){
            MongoCollection collection = ConnectionProducts();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Document document1 = new Document().
                    append("sid", sid).
                    append("name", name).append("desc", desc).
                    append("price", price).append("stock_quantity", stock_quantity).
                    append("add_date", add_date).append("ex_date", ex_date).append("category", category);

            collection.insertOne(document1);
        }

        public static List<Product> mongoViewProductsSeller(int sid){
            MongoCollection collection = ConnectionProducts();
            List<Product> list=new ArrayList<Product>();
            FindIterable<Document> fi = collection.find();
            MongoCursor<Document> cursor = fi.iterator();
            try {
                while (cursor.hasNext()) {
                    Document temp = cursor.next();

                    String _id = temp.getObjectId("_id").toString();
                    int uidCheck = temp.getInteger("uid");
                    if(uidCheck==sid){
                        String id = temp.getObjectId("_id").toString();
                        String sid1 = temp.getString("sid");
                        String name = temp.getString("name");
                        String desc = temp.getString("desc");
                        String price = temp.getString("price");
                        String stock_quantity = temp.getString("stock_quantity");
                        Date add_date = temp.getDate("add_date");
                        Date ex_date = temp.getDate("ex_date");
                        String category = temp.getString("category");
                        Product pro = new Product(id,sid1,name,desc,price,stock_quantity,add_date,ex_date,category);
                        list.add(pro);
                    }
                }
            } finally {
                cursor.close();
            }
            return list;
        }
        public static boolean MongoRemoveProduct(String _id){
            MongoCollection collection = ConnectionProducts();

            FindIterable<Document> fi = collection.find();
            MongoCursor<Document> cursor = fi.iterator();
            try {
                while (cursor.hasNext()) {
                    Document temp = cursor.next();
                    if(_id.equals(temp.getObjectId("_id").toString())){
                        collection.deleteOne(temp);
                        return true;
                    }

                }
            } finally {
                cursor.close();
            }
                return false;
            }


public static void MongoDBUpdateProduct(String _id, String sid, String name, String desc, String price, String stock_quantity, String add_date, String ex_date, String category){
    MongoCollection collection = ConnectionProducts();
    FindIterable<Document> fi = collection.find();
    MongoCursor<Document> cursor = fi.iterator();
    try {
        while (cursor.hasNext()) {
            Document temp = cursor.next();
            if(_id.equals(temp.getObjectId("_id").toString())){

                Document updatedVal = new Document().
                        append("sid", sid).
                        append("name", name).append("desc", desc).
                        append("price", price).append("stock_quantity", stock_quantity).
                        append("add_date", add_date).append("ex_date", ex_date).append("category", category);
                Bson updateOp = new Document("$set", updatedVal);
               collection.updateOne(temp,updateOp);

            }

        }
    } finally {
        cursor.close();
    }

}
    }