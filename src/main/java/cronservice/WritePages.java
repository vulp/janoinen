package cronservice;

import model.Beer;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import parsers.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: vulp
 * Date: 1/23/13
 * Time: 4:24 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class WritePages {

    private static final Logger logger = Logger.getLogger(WritePages.class);
    private FileOutputStream fop = null;
    private File file;
    private StringBuffer bisset;
    private List<Beer> beerList;
    private List barList = new ArrayList();
    private final Lintu lintu = new Lintu();
    private final Kaisla kaisla = new Kaisla();
    private final Penni penni = new Penni();
    private final Urho urho = new Urho();
    private final OnePint onePint = new OnePint();
    private final Stones stones = new Stones();
    private final Bruuveri bruuveri = new Bruuveri();
    private final Teereenpeli teereenpeli = new Teereenpeli();
    private final Blackdoor blackdoor = new Blackdoor();
    private final Vltava vltava = new Vltava();

    //@Scheduled(cron="*/1 * * * * THU")
    //@Scheduled(fixedDelay = 5000)  //testiä varten  ajaa 5 sekunnin välein getpagesia !ei serverille tätä versiota kiitos!
    public void getPages() {
        barList.add(bruuveri.parsePage());
        barList.add(lintu.parsePage());
        barList.add(kaisla.parsePage());//parse pages
        barList.add(penni.parsePage());
        barList.add(urho.parsePage());
        barList.add(onePint.parsePage());
        barList.add(stones.parsePage());
        barList.add(teereenpeli.parsePage());
        barList.add(blackdoor.parsePage());
        barList.add(vltava.parsePage());

        //check beerlist
        for(Object bar : barList) {
            beerList = (List<Beer>) bar;

            bisset = new StringBuffer();

            //write beer to stringbuffer
            for (Beer bisse : beerList){
                bisset.append(bisse);
            }
            writePages(bisset, "bruuveri");//todo baarin nimi ja bissen listaus tähän
        }
    }

    private void writePages(StringBuffer parsedBeers, String  barName) {
        try {
            file = new File(barName + ".txt");
			fop = new FileOutputStream(file);

            // if file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            // get the content in bytes
            byte[] contentInBytes = parsedBeers.toString().getBytes();
            fop.write(contentInBytes);
            fop.flush();
            fop.close();
            System.out.println("Beers done");

        }catch(Exception e){
            logger.error("Cronservice error: " +e);
        } finally {
            try{
                 fop.close();
            } catch (Exception ee) {
                logger.error("Cronservice error2: " +ee);
            }
        }

    }
}
