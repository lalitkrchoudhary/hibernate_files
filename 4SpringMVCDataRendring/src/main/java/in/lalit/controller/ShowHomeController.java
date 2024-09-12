package in.lalit.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ShowHomeController {
	
	@GetMapping
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping(value = "/report")
	public String showDisplayPage(Map<String, Object> model) {
		model.put("name", "kholi");
		model.put("age", 35);
		model.put("address", "RCB");
		
		// now sending throw the array
		String[] gameNames= new String[]{"Cricket","Basketball","Football","Badminton","Tennis"};
		model.put("gameNames", gameNames);
		
		//list of data having 
		List<String> subjectList= List.of("java", "javascript","python");
		model.put("subjectList", subjectList);
		
		//Set of data which does not contain duplicate of data
		Set<Long> mobileSet= Set.of(9999939393L, 838393893L, 90932048903L);
		model.put("mobileSet", mobileSet);
		
		// Map data in key value pair
		Map<String, Number> idsMap= Map.of("adhar",897033, "voterId", 898989, "panNo",9080990);
		model.put("idsMap", idsMap);
		return "display";
	}
	
	
	
}
