package pl.js.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.js.dao.StudentDao;

@Service
@SessionAttributes({ "class" })
public class StudentService {
	@Autowired
	StudentDao studentDao;

	
}
