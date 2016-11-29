/**
 * 
 */
package br.com.makersweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.makersweb.util.MakersWebUtil;

/**
 * @author anderson.aristides
 */
@Controller
public class IndexController {

	@RequestMapping(value = "login.html")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView(MakersWebUtil.GO_LOGIN);
		return mav;
	}
	
	@RequestMapping(value = "recover.html")
	public ModelAndView recover() {
		ModelAndView mav = new ModelAndView(MakersWebUtil.GO_RECOVER);		
		return mav;
	}
	
	@RequestMapping(value = "signup.html")
	public ModelAndView signup() {
		ModelAndView mav = new ModelAndView(MakersWebUtil.GO_SIGNUP);		
		return mav;
	}
	
	@RequestMapping(value = "newpass.html")
	public ModelAndView newpass() {
		ModelAndView mav = new ModelAndView(MakersWebUtil.GO_NEW_PASS);		
		return mav;
	}
}
