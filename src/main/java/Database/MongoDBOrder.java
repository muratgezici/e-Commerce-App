package Database;

import com.mongodb.client.*;
import net.amygdalum.stringsearchalgorithms.io.CharProvider;
import net.amygdalum.stringsearchalgorithms.io.StringCharProvider;
import net.amygdalum.stringsearchalgorithms.search.Horspool;
import net.amygdalum.stringsearchalgorithms.search.StringFinder;
import net.amygdalum.stringsearchalgorithms.search.StringMatch;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.sql.Array;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MongoDBOrder {
    public static MongoCollection ConnectionOrders() {
        MongoClient mongoClient1 = MongoClients.create("mongodb://admin_user:admin_pass@10.10.10.241:27017/");
        MongoDatabase database = mongoClient1.getDatabase("ecommerceapp-mgezici");
        System.out.println(database);
        MongoCollection collection = database.getCollection("orders");
        return collection;
    }
        public static ArrayList<Order> MongoGetOrdersCustomer (String _cid){
            MongoCollection collection = ConnectionOrders();
            FindIterable<Document> fi = collection.find();
            MongoCursor<Document> cursor = fi.iterator();
            ArrayList<Order> allOrders = new ArrayList<Order>();
            try {
                while (cursor.hasNext()) {
                    Document temp = cursor.next();

                    String id = temp.getObjectId("_id").toString();
                    String cid = temp.getString("cid");
                    String status = temp.getString("status");
                    Date add_date = temp.getDate("order_date");

                    if(cid.equalsIgnoreCase(_cid)){
                        Document productsDoc = (Document) temp.get("products");
                        System.out.println(productsDoc);
                        int docSize = productsDoc.size();
                        ArrayList<Product> products = new ArrayList<Product>();
                        for(int i=0; i<docSize;i++){
                            Document productDoc = (Document) productsDoc.get("product"+i);
                            String name = productDoc.getString("name");
                            String category = productDoc.getString("category");
                            String desc = productDoc.getString("desc");
                            String sid = productDoc.getString("sid");
                            String idP = productDoc.getString("id");
                            String price = productDoc.getString("price");
                            String stock_quantity = productDoc.getString("stock_quantity");
                            Date add_dateP = productDoc.getDate("add_date");
                            Date ex_date = productDoc.getDate("ex_date");
                            String amount = productDoc.getString("amount");


                            //ArrayList<String> tags = (ArrayList<String>) temp.getList("tags", String.class);
                            Product pro = new Product(idP,sid,name,desc,price,stock_quantity,add_dateP,ex_date,category,status,amount);
                            products.add(pro);
                        }
                        Order order = new Order(id,cid,add_date,status,products);
                        allOrders.add(order);


                    }

                }

            }
            finally {
                cursor.close();

            }
            return allOrders;
        }
    public static List<Order> MongoGetOrders () {
        MongoCollection collection = ConnectionOrders();
        FindIterable<Document> fi = collection.find();
        MongoCursor<Document> cursor = fi.iterator();
        List<Order> allOrders = new ArrayList<Order>();
        ArrayList<Product> products = new ArrayList<Product>();
        try {
            while (cursor.hasNext()) {
                Document temp = cursor.next();
                temp.get("products");
                Document productsDoc = (Document) temp.get("products");
                System.out.println(productsDoc);
                int docSize = productsDoc.size();
                for(int i=0; i<docSize;i++){
                    Document productDoc = (Document) productsDoc.get("product"+i);
                    String name = productDoc.getString("name");
                    String category = productDoc.getString("category");
                    String desc = productDoc.getString("desc");
                    String sid = productDoc.getString("sid");
                    String id = productDoc.getString("id");
                    String price = productDoc.getString("price");
                    String stock_quantity = productDoc.getString("stock_quantity");
                    Date add_date = productDoc.getDate("add_date");
                    Date ex_date = productDoc.getDate("ex_date");

                    //ArrayList<String> tags = (ArrayList<String>) temp.getList("tags", String.class);
                    Product pro = new Product(id,sid,name,desc,price,stock_quantity,add_date,ex_date,category);
                    products.add(pro);
                }



                    String id = temp.getObjectId("_id").toString();
                    String cid = temp.getString("cid");
                    String status = temp.getString("status");
                   Date add_date = temp.getDate("order_date");

                    Order order = new Order(id,cid,add_date,status,products);
                    allOrders.add(order);
                }

            }
         finally {
            cursor.close();

        }
        return allOrders;
    }

        public static void mongoInsertOrder(String cid, Date date, ArrayList<Product> products){
            MongoCollection collection = ConnectionOrders();
            Document docPro2 = new Document();
            Document document1 = new Document().
                    append("cid", cid).
                    append("order_date", date).append("status", "waiting");
            int flag=0;
            for(Product pro:products){
                Document docPro = new Document().append("id", pro.getId()).
                        append("sid", pro.getSid()).
                        append("name", pro.getName()).append("desc", pro.getDesc()).
                        append("price", pro.getPrice()).append("stock_quantity", pro.getStock_quantity()).
                        append("add_date", pro.getAdd_date()).append("ex_date", pro.getEx_date()).append("category", pro.getCategory())
                        .append("amount", pro.getAmount()).append("status", "waiting");
                docPro2.put("product"+flag, docPro);
                flag++;
            }
            document1.put("products", docPro2);
            collection.insertOne(document1);
        }
public static void MongoDBUpdateOrder(String _id, String status){
    MongoCollection collection = ConnectionOrders();
    FindIterable<Document> fi = collection.find();
    MongoCursor<Document> cursor = fi.iterator();
    try {
        while (cursor.hasNext()) {
            Document temp = cursor.next();
            if(_id.equals(temp.getObjectId("_id").toString())){
                Document updatedVal = new Document().append("status", status);
                Bson updateOp = new Document("$set", updatedVal);
               collection.updateOne(temp,updateOp);
            }
        }
    } finally {
        cursor.close();
    }
}

}