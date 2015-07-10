package net.awpspace.android_gridview_transition.model;

/**
 * Created by haint on 7/10/2015.
 */
public class Item {
    private String image;
    private String title;

    public Item(String image, String title) {
        this.image = image;
        this.title = title;
    }
    public Item(String image) {
        this.image = image;
        this.title = "awpspace.net";
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
