package vn.hamalaja.mvc.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.hamalaja.mvc.services.AuthenticationService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private AuthenticationService authService;

	@Value("${foo}")
	private int foo;


	@RequestMapping(value = "/login/{token}", method = RequestMethod.GET)
	public ModelAndView login(@PathVariable(required = true) String token) {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("user", authService.verify(token));
		return mv;
	}


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {
		model.put("title", "Vi du");
		model.put("msg", "Mo ta");
		return "login";
	}

}
