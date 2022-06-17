package Database;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    private String oid;
    private String cid;
    private Date order_date;
    private String status; //waiting, accepted, partial, denied
    private ArrayList<Product> products;

    public Order(String oid, String cid, Date order_date, String status, ArrayList<Product> products) {
        this.oid = oid;
        this.cid = cid;
        this.order_date = order_date;
        this.status = status;
        this.products = products;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
