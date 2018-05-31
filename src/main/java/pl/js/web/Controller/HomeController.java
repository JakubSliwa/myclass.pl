package pl.js.web.Controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.js.dao.AdminDao;
import pl.js.entity.users.Admin;

@Controller
@Transactional

public class HomeController {

	@Autowired
	AdminDao adminDao;

	@GetMapping("/save")
	@ResponseBody
	public String addA() {
		Admin admin = new Admin("admin", "password");
		adminDao.save(admin);
		return "success";
	}

	@GetMapping("/update/{id}/{name}/{password}")
	@ResponseBody
	public String updateA(@PathVariable Long id, @PathVariable String name, @PathVariable String password) {
		Admin admin = adminDao.findAById(id);
		admin.setLogin(name);
		admin.setPassword(password);
		adminDao.update(admin);
		return "success update";
	}

	@GetMapping(path = "/deletedById/{id}")
	@ResponseBody
	String delete(@PathVariable Long id) {
		Admin admin = adminDao.findAById(id);
		adminDao.delete(admin);
		return "succes delete";
	}

	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("admins", adminDao.getAll());
		return "testLists";
	}
}
