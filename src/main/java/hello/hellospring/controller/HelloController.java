package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@GetMapping("hello-api")
	@ResponseBody
	public Hello helloApi(@RequestParam("name") String name) {
		Hello hello = new Hello();
		hello.setName(name);
		return hello;
		//@ResponseBody를 사용하고, 객체를 반환하면 객체가 JSON으로 변환됨
	}

	static class Hello {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	@GetMapping("hello-string")
	@ResponseBody 
	public String helloString(@RequestParam("name") String name) {
		return "hello " + name; // "hello spring"
		//@ResponseBody 뷰 리졸버(viewResolver)를 사용하지 않음
		//HTTP의 BODY에 문자 내용을 직접 반환
	}

	@GetMapping("hello-mvc")
	public String helloMvc(@RequestParam("name") String name, Model model) {
		model.addAttribute("name", name);
		return "hello-template";
	}
	
	@GetMapping("hello")
	public String hello(Model model) {
		model.addAttribute("data", "Hello!!");
		return "hello";
	}

}
