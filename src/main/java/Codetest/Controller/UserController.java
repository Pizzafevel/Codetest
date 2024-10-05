package Codetest.Controller;

import javax.servlet.http.HttpSession; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import Codetest.Model.LoginBean;
import Codetest.Model.UserBean;
import Codetest.Repository.UserRepository;

@Controller
public class UserController {

@GetMapping(value="/")
	
	public ModelAndView Login() {
		UserBean bean = new UserBean();
		ModelAndView mv = new ModelAndView("login","logobj", bean);
		return mv;
	}
	@GetMapping(value="/reg")
	public ModelAndView toregi() {
		UserBean bean = new UserBean();
		ModelAndView mv = new ModelAndView("register","regobj",bean);
		return mv;
	}
	
	@PostMapping(value="/adduser")
	public String addUser(@ModelAttribute("regobj")UserBean bean,BindingResult br,ModelMap m) {
		if(br.hasErrors()) {
			System.out.println("reg has error");
			return "register";
		} 
		UserRepository repo = new UserRepository();
		repo.insertUser(bean);
		m.addAttribute("user", bean);
		return "success";
	}
	
	@GetMapping(value="/login")
	public String tologin() {
		return "redirect:/";
	}
	
	@PostMapping(value="/dologin")
	public String doLogin(@ModelAttribute("logobj")LoginBean login,UserBean user,Model model,HttpSession session) {
		UserRepository repo = new UserRepository();
		if (user.getEmail()==null) {
			model.addAttribute("error", "Fill the blank");
			return "login";
		} else {
			boolean result = repo.checkEmail(user.getEmail());
			
			if (result) {
				UserBean obj = repo.loginUser(login);
				if (obj==null) {
					model.addAttribute("error","Incorrect password");
					return "login";
				} else {
					model.addAttribute("user", obj);
					model.addAttribute("email", obj.getEmail());
					
					if (obj.getRole()!=null && obj.getRole().equals("admin")) {
						return "loginsuccess";
					} else {
						return "welcome";
					}
				}
			} else {
				model.addAttribute("error", "Invalid email");
				return "login";
			}
		}  
	
	}
}
