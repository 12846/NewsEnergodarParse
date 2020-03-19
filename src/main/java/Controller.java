import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    private int number = 0;
    private String heading;
    private String text;
    private String date;
    private String photoUrl;
    private String url;

    CustomNews customNews;
    ArrayList<CustomNews> arrayList;

    public void start() {
        customNews = new CustomNews();
        arrayList = new ArrayList<>();
        new Thread(() -> {
            try {
                Document doc = Jsoup.connect("http://www.en-news.com.ua/").get();

                Elements ipElements = doc.getElementsByAttributeValue("class", "_self");

                ipElements.forEach(ipElement -> {
                    number++;
                    Element aElement = ipElement;
                    url = aElement.attr("href");
                    heading = aElement.text();

                    try {
                        Document docUrl = Jsoup.connect(url).get();

                        Elements urlImageElements = docUrl.getElementsByAttributeValue("class", "attachment-colormag-featured-image size-colormag-featured-image wp-post-image");

                        urlImageElements.forEach(urlImageElement -> {
                            Element imElement = urlImageElement;
                            photoUrl = imElement.attr("src");

                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        Document docTime = Jsoup.connect(url).get();

                        Elements dateElements = docTime.getElementsByAttributeValue("class","entry-date published");

                        dateElements.forEach(dateElement -> {
                            Element dataElement = dateElement;
                            date = dateElement.text();

                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        Document docText = Jsoup.connect(url).get();

                        Elements textElements = docText.getElementsByAttributeValue("class", "entry-content clearfix");

                        textElements.forEach(textUrlElement -> {
                            Element textElement = textUrlElement;
                            text = textElement.text();
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    arrayList.add(new CustomNews(number, heading, text, date, photoUrl, url));


                });

                //arrayNews.add(title);

                arrayList.forEach(System.out::println);


            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
