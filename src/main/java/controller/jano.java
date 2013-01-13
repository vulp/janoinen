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

    private final Lintu lintu = new Lintu();
    private final Kaisla kaisla = new Kaisla();
    private final Penni penni = new Penni();
    private final Urho urho = new Urho();
    private final OnePint onePint = new OnePint();
    private final Stones stones = new Stones();
    private final Bruuveri bruuveri = new Bruuveri();
    private List<Beer> beerList = null;
    private final Teereenpeli teereenpeli = new Teereenpeli();
    private final Blackdoor blackdoor = new Blackdoor();
    private final Vltava vltava = new Vltava();
    private final Amsterdam amsterdam = new Amsterdam();

    @RequestMapping("/")
    private String showIndex() {
        return "index";
    }

    @RequestMapping(value = "/lintu/", method = RequestMethod.GET)
    private String showLintu(Model model) {
        beerList = lintu.parsePage();
        model.addAttribute("olvi", beerList);
        return "beerlist";
    }

    @RequestMapping(value = "/penni/", method = RequestMethod.GET)
    private String showPenni(Model model) {
        beerList = penni.parsePage();
        model.addAttribute("olvi", beerList);
        return "beerlist";
    }

    @RequestMapping(value = "/kaisla/", method = RequestMethod.GET)
    private String showKaisla(Model model) {
        beerList = kaisla.parsePage();
        model.addAttribute("olvi", beerList);
        return "beerlist";
    }

    @RequestMapping(value = "/stones/", method = RequestMethod.GET)
    private String showStones(Model model) {
        beerList = stones.parsePage();
        model.addAttribute("olvi", beerList);
        return "beerlist";
    }

    @RequestMapping(value = "/bruuveri/", method = RequestMethod.GET)
    private String showBruuveri(Model model) {
        beerList = bruuveri.parsePage();
        model.addAttribute("olvi", beerList);
        return "beerlist";
    }

    @RequestMapping(value = "/onepint/", method = RequestMethod.GET)
    private String showOnepint(Model model) {
        beerList = onePint.parsePage();
        model.addAttribute("olvi", beerList);
        return "beerlist";
    }

    @RequestMapping(value = "/blackdoor/", method = RequestMethod.GET)
    private String showBlackdoor(Model model) {
        beerList = blackdoor.parsePage();
        model.addAttribute("olvi", beerList);
        return "beerlist";
    }

    @RequestMapping(value = "/vltava/", method = RequestMethod.GET)
    private String showVltava(Model model) {
        beerList = vltava.parsePage();
        model.addAttribute("olvi", beerList);
        return "beerlist";
    }

    @RequestMapping(value = "/teerenpeli/", method = RequestMethod.GET)
    private String showTeerenpeli(Model model) {
        beerList = teereenpeli.parsePage();
        model.addAttribute("olvi", beerList);
        return "beerlist";
    }

    @RequestMapping(value = "/urho/", method = RequestMethod.GET)
    private String showUrho(Model model) {
        beerList = urho.parsePage();
        model.addAttribute("olvi", beerList);
        return "beerlist";
    }

    @RequestMapping(value = "/asterdam/", method = RequestMethod.GET)
    private String showAmsterdam(Model model) {
        //beerList = penni.parsePage();
        return "beerlist";
    }
}
