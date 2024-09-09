package in.lalit.service;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.stereotype.Service;

@Service
public class WishMessageServiceImpl implements IWishMessageService {

	@Override
	public String generateWishMessage() {
	    LocalDateTime ldt =  LocalDateTime.now();
	    int hours =ldt.getHour();
	    if(hours<12) return "Good Morning";
	    else if(hours<16) return "Good Afternoon";
	    else if(hours<20) return "Good Evening";
	    else return "Good Night";
	    
	}

}
