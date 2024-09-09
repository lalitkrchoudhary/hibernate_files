package in.lalit.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import in.lalit.service.IWishMessageService;

@Controller
public class ShowHomeController {
	
	@Autowired
	private IWishMessageService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHomePage() {
		return "home";
	}
	
	//The old type used for exchange the data 
	/*
	 * @RequestMapping(value = "/wish", method = RequestMethod.GET)
	 * 
	 * public ModelAndView showWishMessage() { //calling the service to get the
	 * information String msg= service.generateWishMessage();
	 * 
	 * //Send the data from controller to View ModelAndView mav = new
	 * ModelAndView(); mav.addObject("msg",msg);
	 * 
	 * mav.setViewName("display");
	 * 
	 * return mav; //ViewName ->LVN }
	 */
	
	/*
	 * //Another way of writing the Logic
	 * 
	 * @RequestMapping(value = "/wish", method = RequestMethod.GET) public String
	 * showWishMessage(Model model) { String msg= service.generateWishMessage();
	 * model.addAttribute("msg", msg);
	 * 
	 * return "display"; }
	 */
	
	
	/*
	 * //Real time coding uses this logic means it is losely copuled means non
	 * invasive
	 * 
	 * @RequestMapping(value = "/wish", method = RequestMethod.GET) public String
	 * showWishMessage(Map<String, Object> model) { String msg=
	 * service.generateWishMessage(); model.put("msg", msg);
	 * 
	 * return "display"; }
	 */
	
	
	//Having the return type is void
	@RequestMapping(value = "/wish", method = RequestMethod.GET)
	public void showWishMessage(Map<String, Object> model) { 
		String msg= service.generateWishMessage();
	  model.put("msg", msg);
	  
	  return ; 
	  }
	
}
