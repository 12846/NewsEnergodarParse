public class CustomNews {
    private int number;
    private String heading;
    private String text;
    private String date;
    private String photoUrl;
    private String url;

    public CustomNews() {
    }

    public CustomNews(int number, String heading, String text, String date, String photoUrl, String url) {
        this.number = number;
        this.heading = heading;
        this.text = text;
        this.date = date;
        this.photoUrl = photoUrl;
        this.url = url;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "CustomNews{" +
                "number=" + number +
                ", heading='" + heading + '\'' +
                ", text='" + text + '\'' +
                ", date='" + date + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
