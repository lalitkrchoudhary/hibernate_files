package in.ineuron.controller;

import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/demo")
public class DemoController {

	@Autowired
	private ServletContext sc;
	
	
	@Autowired
	private ServletConfig cg;
	
	@Autowired
	private HttpSession ses;

	@GetMapping(value = "/report")
	public String showReport(Map<String, Object> model) {
		System.out.println("DemoController.showReport()");
		System.out.println("Web app name is    :: "+sc.getContextPath());
		System.out.println("DS logical name is ::"+cg.getServletName());
		System.out.println("Session Id:"+ses.getId());
		return "display";
	}

	/*
	 * @RequestMapping public String showHome() { return "home"; }
	 */

	/*
	 * @PostMapping(value = "/report") // @RequestMapping(value = "/report", method
	 * = RequestMethod.POST) public String showReport(Map<String, Object> model) {
	 * System.out.println("TestController.showReport()"); return "display"; }
	 * 
	 * @GetMapping(value = "/report") // @RequestMapping(value = "/report", method =
	 * RequestMethod.GET) public String showReport1(Map<String, Object> model) {
	 * System.out.println("TestController.showReport1()"); return "display1"; }
	 */

	/*
	 * @GetMapping(value = {"/report","/report1","/report2"}) public String
	 * showReport(Map<String, Object> model) {
	 * System.out.println("TestController.showReport()"); return "display"; }
	 */

	/*
	 * @GetMapping(value = "report") public String showReport(Map<String, Object>
	 * model) { System.out.println("TestController.showReport()"); return "display";
	 * }
	 * 
	 * @PostMapping(value="report") public String showReport1(Map<String, Object>
	 * model) { System.out.println("TestController.showReport1()"); return
	 * "display"; }
	 */

}
