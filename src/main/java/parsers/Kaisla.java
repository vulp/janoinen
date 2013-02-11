package parsers;
     
import Beer.Beer;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
     
     
import java.util.ArrayList;
import java.util.List;
     
/**
 * Created by IntelliJ IDEA.
 * User: vulp && vetoketju
 * Date: 1/7/13
 * Time: 10:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class Kaisla {
    private Document doc;
    private List<Beer> beerList;
    private static final Logger logger = Logger.getLogger(Kaisla.class);
    public List<Beer> parsePage() {
        try {
            beerList = new ArrayList<Beer>();
            doc  = Jsoup.connect("http://www.oluthuone.fi/kaisla-juomalista.html").get();
            Elements elements = doc.select("div#c165 td");
     
            double percent;
            String nimi = "";
            for (Element element : elements) {
                if(!element.text().equalsIgnoreCase("Hanaoluet") &&
                        !element.text().equalsIgnoreCase("Suomalaiset") &&
                        !element.text().equalsIgnoreCase("KUUKAUDEN HANAOLUT >") &&
                        !element.text().equalsIgnoreCase("VAIHTUVA PIENPANIMO-OLUT >") &&
                        !element.text().equalsIgnoreCase("Brittiläiset") &&
                        !element.text().equalsIgnoreCase("Belgialaiset") &&
                        !element.text().equalsIgnoreCase("Saksalaiset") &&
                        !element.text().equalsIgnoreCase("Muut Maat") &&
                        !element.text().replace('\u00A0',' ').trim().equals("")
                ) {
                    try {
                        String eT = element.text().trim();
                        int prosenttimerkinKohta = eT.indexOf("%");
                                int alku = 0;
                                for(int i = prosenttimerkinKohta-1; i>=alku; i--){
                                        if(!Character.isDigit(eT.charAt(i)) && eT.charAt(i) != ',' && eT.charAt(i) != ' '){
                                                alku = i;
                                                break;
                                        }
                                }
                                nimi = eT.substring(0,alku+1).trim();
                                percent = Double.parseDouble(eT.substring(alku+1,prosenttimerkinKohta).replace(',','.').trim());
                    } catch (Exception e) {
                        percent = -1;
                    }
                    if(percent == -1) {
                       nimi = element.text();
                    }
                    beerList.add(new Beer(nimi, -1, percent,""));
                }
            }
               
        } catch (Exception e) {
            logger.error("Kaisla error: " +e);
        }
        return beerList;
    }
}
