package cronservice;

import model.Beer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import parsers.Bruuveri;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

    private FileOutputStream fop = null;
    private File file;
    private StringBuffer bisset = new StringBuffer();

    //@Scheduled(cron="*/1 * * * * THU")
    //@Scheduled(fixedDelay = 5000)  //testiä varten  ajaa 5 sekunnin välein getpagesia !ei serverille tätä versiota kiitos!
    public void getPages() {
        Bruuveri bruuveri = new Bruuveri();

        //käydään baari läpi
        for (Beer bisse : bruuveri.parsePage()){
             bisset.append(bisse);
        }

        writePages(bisset, "bruuveri");

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
            e.printStackTrace();
        } finally {
            try{
                 fop.close();
            } catch (Exception ee) {

            }
        }

    }
}
