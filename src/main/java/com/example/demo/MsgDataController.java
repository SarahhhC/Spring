package com.example.demo;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.repositories.MsgDataRepository;

@Controller
public class MsgDataController {
	
	@Autowired
	MsgDataRepository repository;
	
	@PersistenceContext
	EntityManager entityManager;
	
	MsgDataDaoImpl dao;

	@RequestMapping(value = "/msg", method = RequestMethod.GET)
	public ModelAndView msg(ModelAndView mav) {
		mav.setViewName("showMsgData");
		mav.addObject("title","Sample");
		mav.addObject("msg","MsgData의 예제입니다.");
		MsgData msgdata = new MsgData();
		mav.addObject("formModel", msgdata);
		List<MsgData> list = (List<MsgData>)dao.getAll();
		mav.addObject("datalist", list);
		return mav;
	}

	@RequestMapping(value = "/msg", method = RequestMethod.POST)
	public ModelAndView msgform(
			@Valid @ModelAttribute MsgData msgdata, 
			Errors result, 
			ModelAndView mav) {
		if (result.hasErrors()) {
			mav.setViewName("showMsgData");
			mav.addObject("title", "Sample [ERROR]");
			mav.addObject("msg", "값을 다시 확인해주세요!");
			return mav;
		} else {
			repository.save(msgdata);
			return new ModelAndView("redirect:/msg");
		}
	}

	@PostConstruct
	public void init(){
		System.out.println("ok");
		dao = new MsgDataDaoImpl(entityManager);
	}

}
