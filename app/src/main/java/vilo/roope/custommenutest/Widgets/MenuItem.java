package vilo.roope.custommenutest.Widgets;

public class MenuItem {

    private String name;
    private String description;
    private Class<?> activity;
    private String category;

    public MenuItem(String name, String description, String category, Class<?> activity) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.activity = activity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Class<?> getActivity() {
        return activity;
    }

    public String getCategory(){
        return category;
    }
}
