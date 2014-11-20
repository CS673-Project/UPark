package bu.edu.upark.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import bu.edu.upark.repositories.UserAccountDAO;
import bu.edu.upark.entities.UserAccount;

import org.springframework.web.servlet.ModelAndView;

@Service
@ComponentScan("bu.edu.upark.repositories")
public class LoginServiceImpl implements LoginService{
	   @Autowired
	   private UserAccountDAO uad;
       public boolean doLogin(HttpServletRequest req,String username, String password){
    	   UserAccount ua = uad.findUserbyName(username);
    	   if(ua!=null&&ua.getPassword().equals(password)){
    		  System.out.println("OK");
    		  req.getSession().setMaxInactiveInterval(60*30);
    		  req.getSession().setAttribute("username", username);
    		  req.getSession().setAttribute("password", password);
    		   return true;
    	   }
    	   else{
    		   System.out.println("Wrong");
    		   return  false;
    	   }
    	   
       }
       
       
       public void printSession(HttpServletRequest req)
       {
    	   HttpSession session = req.getSession();
    	   String username = (String) session.getAttribute("username");
   		
   			System.out.println(username);
       }

	

}
