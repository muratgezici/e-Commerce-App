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
                    Double totalprice = temp.getDouble("totalprice");

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
                            String statusP = productDoc.getString("status");


                            //ArrayList<String> tags = (ArrayList<String>) temp.getList("tags", String.class);
                            Product pro = new Product(idP,sid,name,desc,price,stock_quantity,add_dateP,ex_date,category,statusP,amount);
                            products.add(pro);
                        }
                        Order order = new Order(id,cid,add_date,status,products,totalprice);
                        allOrders.add(order);


                    }

                }

            }
            finally {
                cursor.close();

            }
            return allOrders;
        }
    public static ArrayList<Product> MongoGetOrdersProductAll (){
        MongoCollection collection = ConnectionOrders();
        FindIterable<Document> fi = collection.find();
        MongoCursor<Document> cursor = fi.iterator();
        ArrayList<Order> allOrders = new ArrayList<Order>();
        ArrayList<Product> products = new ArrayList<Product>();
        try {
            while (cursor.hasNext()) {
                Document temp = cursor.next();

                String id = temp.getObjectId("_id").toString();
                String cid = temp.getString("cid");
                String status = temp.getString("status");
                Date add_date = temp.getDate("order_date");
                Double totalprice = temp.getDouble("totalprice");

                    Document productsDoc = (Document) temp.get("products");
                    System.out.println(productsDoc);
                    int docSize = productsDoc.size();
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
                             String statusP = productDoc.getString("status");
                            String flaglocation = productDoc.getString("flaglocation");
                            //ArrayList<String> tags = (ArrayList<String>) temp.getList("tags", String.class);
                            Product pro = new Product(idP,sid,name,desc,price,stock_quantity,add_dateP,ex_date,category,statusP,amount,flaglocation);
                            products.add(pro);

                    }

            }

        }
        finally {
            cursor.close();

        }
        return products;
    }
    public static ArrayList<Order> MongoGetOrdersSeller (String _sid) {
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
                Double totalprice = temp.getDouble("totalprice");

                    Document productsDoc = (Document) temp.get("products");
                    System.out.println(productsDoc);
                    int docSize = productsDoc.size();
                    ArrayList<Product> products = new ArrayList<Product>();
                    for(int i=0; i<docSize;i++){

                        Document productDoc = (Document) productsDoc.get("product"+i);
                        String sid = productDoc.getString("sid");
                        if(sid.equalsIgnoreCase(_sid)){

                            String name = productDoc.getString("name");
                            String category = productDoc.getString("category");
                            String desc = productDoc.getString("desc");
                            String idP = productDoc.getString("id");
                            String price = productDoc.getString("price");
                            String stock_quantity = productDoc.getString("stock_quantity");
                            Date add_dateP = productDoc.getDate("add_date");
                            Date ex_date = productDoc.getDate("ex_date");
                            String amount = productDoc.getString("amount");
                            String statusP = productDoc.getString("status");
                            //ArrayList<String> tags = (ArrayList<String>) temp.getList("tags", String.class);
                            Product pro = new Product(idP,sid,name,desc,price,stock_quantity,add_dateP,ex_date,category,statusP,amount);
                            products.add(pro);
                        }

                    }
                    Order order = new Order(id,cid,add_date,status,products,totalprice);
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
            double totalprice=0;
            int flag=0;
            for(Product pro:products){
                Document docPro = new Document().append("id", pro.getId()).
                        append("sid", pro.getSid()).
                        append("name", pro.getName()).append("desc", pro.getDesc()).
                        append("price", pro.getPrice()).append("stock_quantity", pro.getStock_quantity()).
                        append("add_date", pro.getAdd_date()).append("ex_date", pro.getEx_date()).append("category", pro.getCategory())
                        .append("amount", pro.getAmount()).append("status", "waiting").append("flaglocation",flag+"");
                docPro2.put("product"+flag, docPro);
                totalprice+=Double.parseDouble(pro.getAmount())*Double.parseDouble(pro.getPrice());
                flag++;
            }
            document1.put("products", docPro2);
            document1.append("totalprice", totalprice);
            collection.insertOne(document1);
        }
public static void MongoDBUpdateOrder(String _id, String status,String oid){
    MongoCollection collection = ConnectionOrders();
    ArrayList<Product> products = MongoGetOrdersProductAll();
    Document docPro2 = new Document();
    Document document1 = new Document();
    FindIterable<Document> fi = collection.find();
    MongoCursor<Document> cursor = fi.iterator();
    try {
        while (cursor.hasNext()) {
            Document temp = cursor.next();
            if(temp.getObjectId("_id").toString().equalsIgnoreCase(oid)) {
                for (Product pro : products) {
                    if (_id.equals(pro.getId())) {
                        Document docPro = new Document().append("id", pro.getId()).
                                append("sid", pro.getSid()).
                                append("name", pro.getName()).append("desc", pro.getDesc()).
                                append("price", pro.getPrice()).append("stock_quantity", pro.getStock_quantity()).
                                append("add_date", pro.getAdd_date()).append("ex_date", pro.getEx_date()).append("category", pro.getCategory())
                                .append("amount", pro.getAmount()).append("status", status).append("flaglocation", pro.getFlaglocation());
                        docPro2.put("product" + pro.getFlaglocation(), docPro);
                    } else {
                        Document docPro = new Document().append("id", pro.getId()).
                                append("sid", pro.getSid()).
                                append("name", pro.getName()).append("desc", pro.getDesc()).
                                append("price", pro.getPrice()).append("stock_quantity", pro.getStock_quantity()).
                                append("add_date", pro.getAdd_date()).append("ex_date", pro.getEx_date()).append("category", pro.getCategory())
                                .append("amount", pro.getAmount()).append("status", pro.getStatus()).append("flaglocation", pro.getFlaglocation());
                        docPro2.put("product" + pro.getFlaglocation(), docPro);
                    }
                }
                Document updatedVal = new Document().append("products", docPro2);
                System.out.println("updateval :" + updatedVal);
                Bson updateOp = new Document("$set", updatedVal);
                collection.updateOne(temp, updateOp);
            }


        }

    } finally {
        cursor.close();
    }




}

    public static void MongoDBUpdateOrderStatus(){
        MongoCollection collection = ConnectionOrders();
        ArrayList<Product> products = MongoGetOrdersProductAll();
        Document docPro2 = new Document();
        Document document1 = new Document();
        FindIterable<Document> fi = collection.find();
        MongoCursor<Document> cursor = fi.iterator();
        try {
            while (cursor.hasNext()) {
                Document temp = cursor.next();
                boolean wait=false,accept=false,deny=false;
                for(Product pro:products) {
                    if( pro.getStatus().equalsIgnoreCase("waiting")){
                        wait=true;
                        System.out.println("waitttt");
                    }
                    else if( pro.getStatus().equalsIgnoreCase("accepted")){
                        accept=true;
                        System.out.println("wacceeptttt");
                    }
                    else if( pro.getStatus().equalsIgnoreCase("denied")){
                        deny=true;
                        System.out.println("deneeyyyy");
                    }
                }
                if(wait && !accept && !deny){
                    Document updatedVal1 = new Document().append("status", "waiting");
                    Bson updateOp1 = new Document("$set", updatedVal1);
                    collection.updateOne(temp,updateOp1);
                    System.out.println("waitttt");
                }
                else if(!wait && accept && !deny){
                    Document updatedVal1 = new Document().append("status", "accepted");
                    Bson   updateOp1 = new Document("$set", updatedVal1);
                    collection.updateOne(temp,updateOp1);
                    System.out.println("wacceeptttt");
                }
                else if(!wait && !accept && deny){
                    Document updatedVal1 = new Document().append("status", "denied");
                    Bson updateOp1 = new Document("$set", updatedVal1);
                    collection.updateOne(temp,updateOp1);
                    System.out.println("deneeyyyy");
                }
                else {
                    Document updatedVal1 = new Document().append("status", "partial");
                    Bson  updateOp1 = new Document("$set", updatedVal1);
                    collection.updateOne(temp,updateOp1);
                }
            }

        } finally {
            cursor.close();
        }
    }

}


