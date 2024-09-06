package in.lalit;









import org.apache.log4j.Logger;

import in.lalit.bo.StudentBo;

/**
 * Hello world!
 */
public class App {
	 private static  Logger logger = Logger.getLogger(App.class);
    public static void main(String[] args) {
       
        

        System.out.println("Hello Lombok!");
        logger.info("THIS IS HEADING");
        StudentBo std = new StudentBo();
        std.setSid(1);
        std.setSname("Dhoni");
        std.setSadd("Delhi");
        std.setSage(43);
       logger.info(std);
        
    }
}
