package Tools;

import com.google.gson.annotations.SerializedName;

public class ListItems {

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("img")
    private String imgUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
