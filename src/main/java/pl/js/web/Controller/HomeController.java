package pl.js.web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.js.dao.AdminDao;
import pl.js.entity.users.Admin;

@Controller
public class HomeController {
	@Autowired
	AdminDao adminDao;

	@GetMapping("/save")
	@ResponseBody
	public String addB() {
		Admin admin = new Admin("admin", "password");
		adminDao.save(admin);
		return "success";
	}
}
