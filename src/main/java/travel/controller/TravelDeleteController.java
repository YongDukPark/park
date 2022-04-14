package travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import travel.model.TravelDao;

@Controller
public class TravelDeleteController {

	private final String Command = "delete.tv";
	private String getPage = "redirect:/list.tv";
	
	@Autowired
	private TravelDao Dao;
	
	@RequestMapping(value=Command)
	public ModelAndView doAction(
							@RequestParam(value="num", required = true)int num,
							@RequestParam(value="pageNumber", required = false)int pageNumber
							) {
		ModelAndView mao = new ModelAndView();
		
		Dao.getNyNumDelete(num);
		mao.addObject("pageNumber", pageNumber);
		mao.setViewName(getPage);
		
		return mao;
	}
	
	
}
