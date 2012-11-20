package tmp.tmp.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@ModelAttribute("Customer")
	public Customer getGreetingObject() {
		Customer customer = new Customer();
		customer.setUserName("cpf123");
		return customer;
	}

	@RequestMapping(value = "/home")
	public ModelAndView test(HttpServletResponse response) throws IOException {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public void handleSubmit(Customer model, BindingResult result) {
		System.out.println(model.getUserName());
		result.rejectValue("userName", "required.userName", "user name invalid");
	}
}
