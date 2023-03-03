package egovframework.example.sample.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping(value = "/testZZ.do", method = RequestMethod.GET)
	public ResponseEntity<Test> testZ(Model model) {
		Test searchVO = new Test();
		searchVO.setEmail("dinh@gmail.com");
		searchVO.setName("Dinh Nguyen ");

		return new ResponseEntity<Test>(searchVO, HttpStatus.OK);
	}

	@RequestMapping(value = "/testMM.do", method = RequestMethod.GET)
	public String test() {
		return "Nhà em có kon mèo";
	}

	@RequestMapping(value = "/testJson.do", method = RequestMethod.POST)
	public Test testPost(@RequestBody Test test) {
		System.out.println(" Test " + test.getEmail() + " Name " + test.getName());
		return test;
	}
}
