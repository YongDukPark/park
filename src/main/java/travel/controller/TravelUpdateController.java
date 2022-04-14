package travel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelUpdateController {
	
	private final String command="update.tv";	//2������ ���ķ� �Ѿ�� /�� ������ /�� �νĸ���
	private String getPage = "travelUpdateForm";
	private String gotoPage = "redirect:/list.tv";
	
	@Autowired
	private TravelDao travelDao;
	
	@RequestMapping(value = command, method=RequestMethod.GET)
	public String goAction(
							@RequestParam(value="num",required = true) int num,
							@RequestParam(value="pageNumber",required = true) int pageNumber,
							Model model) {
		
		TravelBean travel = travelDao.getTravel(num);
		
		model.addAttribute("travel", travel);
		model.addAttribute("pageNumber", pageNumber);
		
		return getPage;
	}
	
	@RequestMapping(value = command, method=RequestMethod.POST)
	public ModelAndView goAction(
							@RequestParam(value="pageNumber",required = true) int pageNumber,
							@ModelAttribute("travel") @Valid TravelBean travel,BindingResult result
											//commandName�� ����.
							) {
		System.out.println("�ʰ�������?");
		ModelAndView mav = new ModelAndView();
		
		
		if(result.hasErrors()) {
			mav.addObject("pageNumber",pageNumber);
			mav.setViewName(command);
			
			return mav;
		}
		
		int cnt = travelDao.Update(travel);
		if(cnt>0) {
			mav.addObject("pageNumber",pageNumber);
			mav.setViewName(gotoPage);
			// ?��������="��������" �̷������� �Ѱܵ� �ȴ�. �׷��� ���ٸ� �ᵵ�Ǵ� ������ �ֱ��ϴ�.
		}
		else {
			mav.addObject("pageNumber",pageNumber);
			mav.setViewName(getPage);
		}
		
		//model.addAttribute("travel", travel);
		
		return mav;
	}
	
	
}
