package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.PhoneService;
import com.javaex.vo.PersonVo;

@Controller
public class PhoneController {

	// 필드
	@Autowired
	private PhoneService phoneService;

	// 생성자

	// 메소드-gs

	// 메소드-일반

	// 전화번호 리스트
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("PhoneController>list()");

		List<PersonVo> personList = phoneService.getPersonList();
		System.out.println(personList);

		model.addAttribute("personList", personList);

		return "list";

	}

	// 전화번호 등록 폼
	@RequestMapping(value = "/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		System.out.println("PhoneController>writeForm()");

		return "writeForm";
	}

	// 전화번호 등록(@ModelAttribute 사용)
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController>write()");

		phoneService.personInsert(personVo);

		return "redirect:/list";
	}

	// 전화번호 등록(파라미터 사용)
	@RequestMapping(value="/write2", method={RequestMethod.GET, RequestMethod.POST})
	public String write2(@RequestParam("name") String name, 
					    @RequestParam("hp") String hp,
					    @RequestParam("company") String company) {
		System.out.println("PhoneController>write2()");
		
		PersonVo personVo = new PersonVo(name, hp, company);
		System.out.println(personVo);
		
		phoneService.personInsert(personVo);
		
		return "redirect:/list";
	}
	
	
	// 전화번호 삭제
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam("no") int no) {
		System.out.println("PhoneController>delete()");

		phoneService.personDelete(no);

		return "redirect:/list";
	}

	
	//전화번호 삭제(@PathVariable 사용)
	@RequestMapping(value="/delete2/{no}", method={RequestMethod.GET, RequestMethod.POST})
	public String delete2(@PathVariable("no") int num) {
		System.out.println("PhoneController>delete()");
		
		phoneService.personDelete(num);
		
		return "redirect:/list";
	}
	
	
	// 전화번호 수정폼
	@RequestMapping(value = "/updateForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateForm(Model model, @RequestParam("no") int no) {
		System.out.println("PhoneController>updateForm()");

		PersonVo personVo = phoneService.getPerson(no);

		model.addAttribute("personVo", personVo);

		return "updateForm";
	}

	// 전화번호 수정
	@RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateForm(Model model, @ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController>update()");

		phoneService.personUpdate(personVo);

		return "redirect:/list";
	}

}
