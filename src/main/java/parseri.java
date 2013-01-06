import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Created with IntelliJ IDEA.
 * User: vulp
 * Date: 1/6/13
 * Time: 6:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class parseri  {

    Document doc;

    public void parsePage() {
        try {
            doc  = Jsoup.connect("http://pikkulintu.fi/hanassa/").get();
        }catch (Exception e) {
            System.out.println("error " +e);
        }

    }
}
