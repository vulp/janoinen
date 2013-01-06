package controller;

/**
 * Created by IntelliJ IDEA.
 * User: vulp
 * Date: 1/6/13
 * Time: 6:17 PM
 * To change this template use File | Settings | File Templates.
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jano")
public class jano {
    @RequestMapping()
	public String printWelcome(Model model) {

        //todo hae parse metodista tulos tähän ja palauta se modelissa

		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "hello";

	}
}
