package controller;

/**
 * Created by IntelliJ IDEA.
 * User: vulp
 * Date: 1/6/13
 * Time: 6:17 PM
 * To change this template use File | Settings | File Templates.
 */

import model.Beer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import parsers.*;

import java.util.List;


@Controller
@RequestMapping("/")
final class jano {

    private Lintu lintu = new Lintu();
    private Kaisla kaisla = new Kaisla();
    private Penni penni = new Penni();
    private Urho urho = new Urho();
    private OnePint onePint = new OnePint();
    private Stones stones = new Stones();
    private Bruuveri bruuveri = new Bruuveri();
    private List<Beer> beerList = null;
    private Teereenpeli teereenpeli = new Teereenpeli();
    private Blackdoor blackdoor = new Blackdoor();
    private Vltava vltava = new Vltava();
    private Amsterdam amsterdam = new Amsterdam();

    @RequestMapping("/")
    public String showIndex() {
        return "index";
    }

    @RequestMapping(value = "/lintu/", method = RequestMethod.GET)
    public String showLintu(Model model) {
        beerList = lintu.parsePage();
        model.addAttribute("olvi", beerList);
        return "beerlist";
    }

    @RequestMapping(value = "/penni/", method = RequestMethod.GET)
    public String showPenni(Model model) {
        beerList = penni.parsePage();
        model.addAttribute("olvi", beerList);
        return "beerlist";
    }

    @RequestMapping(value = "/kaisla/", method = RequestMethod.GET)
    public String showKaisla(Model model) {
        beerList = kaisla.parsePage();
        model.addAttribute("olvi", beerList);
        return "beerlist";
    }

    @RequestMapping(value = "/stones/", method = RequestMethod.GET)
    public String showStones(Model model) {
        beerList = stones.parsePage();
        model.addAttribute("olvi", beerList);
        return "beerlist";
    }

    @RequestMapping(value = "/bruuveri/", method = RequestMethod.GET)
    public String showBruuveri(Model model) {
        beerList = bruuveri.parsePage();
        model.addAttribute("olvi", beerList);
        return "beerlist";
    }

    @RequestMapping(value = "/onepint/", method = RequestMethod.GET)
    public String showOnepint(Model model) {
        beerList = onePint.parsePage();
        model.addAttribute("olvi", beerList);
        return "beerlist";
    }

    @RequestMapping(value = "/blackdoor/", method = RequestMethod.GET)
    public String showBlackdoor(Model model) {
        beerList = blackdoor.parsePage();
        model.addAttribute("olvi", beerList);
        return "beerlist";
    }

    @RequestMapping(value = "/vltava/", method = RequestMethod.GET)
    public String showVltava(Model model) {
        beerList = vltava.parsePage();
        model.addAttribute("olvi", beerList);
        return "beerlist";
    }

    @RequestMapping(value = "/teerenpeli/", method = RequestMethod.GET)
    public String showTeerenpeli(Model model) {
        beerList = teereenpeli.parsePage();
        model.addAttribute("olvi", beerList);
        return "beerlist";
    }

    @RequestMapping(value = "/urho/", method = RequestMethod.GET)
    public String showUrho(Model model) {
        beerList = urho.parsePage();
        model.addAttribute("olvi", beerList);
        return "beerlist";
    }

    @RequestMapping(value = "/asterdam/", method = RequestMethod.GET)
    public String showAmsterdam(Model model) {
        //beerList = penni.parsePage();
        return "beerlist";
    }
}
