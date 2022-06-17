package Database;

import java.util.Date;

public class Product {
    private String id;
    private String sid;

    private String name;
    private String desc;
    private String price;
    private String stock_quantity;
    private Date add_date;
    private Date ex_date;
    private String category;

    private String status;// accepted, waiting, denied

    private String amount;
   // private ArrayList<String> tags;
   // private Byte image;


    public Product(String id, String sid, String name, String desc, String price, String stock_quantity, Date add_date, Date ex_date, String category, String status, String amount) {
        this.id = id;
        this.sid = sid;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.stock_quantity = stock_quantity;
        this.add_date = add_date;
        this.ex_date = ex_date;
        this.category = category;
        this.status = status;
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Product(String id, String sid, String name, String desc, String price, String stock_quantity, Date add_date, Date ex_date, String category) {
        this.id = id;
        this.sid = sid;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.stock_quantity = stock_quantity;
        this.add_date = add_date;
        this.ex_date = ex_date;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(String stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public Date getAdd_date() {
        return add_date;
    }

    public void setAdd_date(Date add_date) {
        this.add_date = add_date;
    }

    public Date getEx_date() {
        return ex_date;
    }

    public void setEx_date(Date ex_date) {
        this.ex_date = ex_date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}
