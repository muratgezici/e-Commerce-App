package Database;

import com.mongodb.client.*;
import net.amygdalum.stringsearchalgorithms.io.CharProvider;
import net.amygdalum.stringsearchalgorithms.io.StringCharProvider;
import net.amygdalum.stringsearchalgorithms.search.Horspool;
import net.amygdalum.stringsearchalgorithms.search.StringFinder;
import net.amygdalum.stringsearchalgorithms.search.StringMatch;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
      //  as.add("s");
     //   as.add("b");
     //   Document document1 = new Document().
      //          append("sid", "migros").
       //        append("name", "Migros").append("desc", "migros").
        //        append("price", "migros@migros.com").append("stock_quantity", "Istanbul Merkez Ofis").
      //          append("add_date", "12/12/2022").append("ex_date", "12/12/2022").append("category", "123");//.append("tags",as);
      //  collection.insertOne(document1);

        return collection;
    }
        public static Product MongoGetProduct (String _id){
           MongoCollection collection = ConnectionProducts();
            FindIterable<Document> fi = collection.find();
            MongoCursor<Document> cursor = fi.iterator();
            try {
                while (cursor.hasNext()) {
                    Document temp = cursor.next();

                    String id = temp.getObjectId("_id").toString();

                    if(id.equals(_id)){
                        String sid = temp.getString("sid");
                        String name = temp.getString("name");
                        String desc = temp.getString("desc");
                        String price = temp.getString("price");
                        String stock_quantity = temp.getString("stock_quantity");
                        String category = temp.getString("category");

                        String add_date = temp.getString("add_date");
                        String ex_date = temp.getString("ex_date");

                        Date date1=null,date2=null;
                        try {
                            date1 = new SimpleDateFormat("yyyy-mm-dd").parse(add_date);
                            date2=new SimpleDateFormat("yyyy-mm-dd").parse(ex_date);
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                        //ArrayList<String> tags = (ArrayList<String>) temp.getList("tags", String.class);
                            Product pro = new Product(id,sid,name,desc,price,stock_quantity,date1,date2,category);
                        return pro;
                    }
                }
            } finally {
                cursor.close();
            }
            return null;
        }
    public static List<Product> MongoGetProducts () {
        MongoCollection collection = ConnectionProducts();
        FindIterable<Document> fi = collection.find();
        MongoCursor<Document> cursor = fi.iterator();
        List<Product> allproducts = new ArrayList<Product>();
        try {
            while (cursor.hasNext()) {
                Document temp = cursor.next();

                    String id = temp.getObjectId("_id").toString();
                    String sid = temp.getString("sid");
                    String name = temp.getString("name");
                    String desc = temp.getString("desc");
                    String price = temp.getString("price");
                    String stock_quantity = temp.getString("stock_quantity");
                    String category = temp.getString("category");
                    String add_date = temp.getString("add_date");
                    String ex_date = temp.getString("ex_date");
                    Date date1=null,date2=null;
                try {
                   date1 = new SimpleDateFormat("yyyy-mm-dd").parse(add_date);
                   date2=new SimpleDateFormat("yyyy-mm-dd").parse(ex_date);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                    //ArrayList<String> tags = (ArrayList<String>) temp.getList("tags", String.class);
                    Product pro = new Product(id,sid,name,desc,price,stock_quantity,date1,date2,category);
                    allproducts.add(pro);
                }

            }
         finally {
            cursor.close();

        }
        return allproducts;
    }

    public static List<Product> MongoGetProductsFilter (String search){
        MongoCollection collection = ConnectionProducts();
        FindIterable<Document> fi = collection.find();
        MongoCursor<Document> cursor = fi.iterator();
        List<Product> allproducts = new ArrayList<Product>();
        try {
            while (cursor.hasNext()) {
                Document temp = cursor.next();
                String name = temp.getString("name");
                String category = temp.getString("category");
                String desc = temp.getString("desc");

                StringMatch nextName = null;
                StringMatch nextCategory = null;
                StringMatch nextDesc = null;

                String[] searchArray = search.split(" ");
                for(String s:searchArray){
                    Horspool stringSearch = new Horspool(s.toLowerCase());
                    CharProvider textName = new StringCharProvider(name.toLowerCase(), 0);
                    CharProvider textCategory = new StringCharProvider(category.toLowerCase(),0);
                    CharProvider textDesc = new StringCharProvider(desc.toLowerCase(),0);

                    StringFinder finderName = stringSearch.createFinder(textName);
                    StringFinder finderCategory = stringSearch.createFinder(textCategory);
                    StringFinder finderDesc = stringSearch.createFinder(textDesc);
                    if(nextName == null)
                    nextName = finderName.findNext();
                    if(nextCategory == null)
                    nextCategory = finderCategory.findNext();
                    if(nextDesc == null)
                    nextDesc = finderDesc.findNext();

                }

                if(nextName!=null || nextCategory!=null || nextDesc!=null){
                    String sid = temp.getString("sid");
                    String id = temp.getObjectId("_id").toString();
                    String price = temp.getString("price");
                    String stock_quantity = temp.getString("stock_quantity");

                    String add_date = temp.getString("add_date");
                    String ex_date = temp.getString("ex_date");
                    Date date1=null,date2=null;
                    try {
                        date1 = new SimpleDateFormat("yyyy-mm-dd").parse(add_date);
                        date2=new SimpleDateFormat("yyyy-mm-dd").parse(ex_date);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }

                    //ArrayList<String> tags = (ArrayList<String>) temp.getList("tags", String.class);
                    Product pro = new Product(id,sid,name,desc,price,stock_quantity,date1,date2,category);
                    allproducts.add(pro);
                }
            }
        } finally {
            cursor.close();
        }
        return allproducts;
    }


        public static String mongoInsert(String sid, String name, String desc, String price, String stock_quantity, String add_date, String ex_date, String category){
            MongoCollection collection = ConnectionProducts();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Document document1 = new Document().
                    append("sid", sid).
                    append("name", name).append("desc", desc).
                    append("price", price).append("stock_quantity", stock_quantity).
                    append("add_date", add_date).append("ex_date", ex_date).append("category", category);

            collection.insertOne(document1);
            ObjectId id = document1.getObjectId("_id");
            String pid = id.toString();
            return pid;
        }

        public static List<Product> mongoViewProductsSeller(String sid){
            MongoCollection collection = ConnectionProducts();
            List<Product> list=new ArrayList<Product>();
            FindIterable<Document> fi = collection.find();
            MongoCursor<Document> cursor = fi.iterator();
            try {
                while (cursor.hasNext()) {
                    Document temp = cursor.next();

                    String uidCheck = temp.getString("sid");
                    System.out.println("uidcheck "+uidCheck);
                    if(uidCheck.equalsIgnoreCase(sid)){
                        String id = temp.getObjectId("_id").toString();
                        String sid1 = temp.getString("sid");
                        String name = temp.getString("name");
                        String desc = temp.getString("desc");
                        String price = temp.getString("price");
                        String stock_quantity = temp.getString("stock_quantity");
                        String category = temp.getString("category");

                        String add_date = temp.getString("add_date");
                        String ex_date = temp.getString("ex_date");
                        Date date1=null,date2=null;
                        try {
                            date1 = new SimpleDateFormat("yyyy-mm-dd").parse(add_date);
                            date2=new SimpleDateFormat("yyyy-mm-dd").parse(ex_date);
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }

                        Product pro = new Product(id,sid1,name,desc,price,stock_quantity,date1,date2,category);
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
                    if(_id.equalsIgnoreCase(temp.getObjectId("_id").toString())){
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