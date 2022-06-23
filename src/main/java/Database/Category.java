package Database;

import java.util.ArrayList;

public class Category {
    private String name;
    private ArrayList<String> tags;

    public Category(String name, ArrayList<String> tags) {
        this.name = name;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", tags=" + tags +
                '}';
    }
}
