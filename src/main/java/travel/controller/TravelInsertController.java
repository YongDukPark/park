package travel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelInsertController {	//controller 가 새로 생기면 다시 실행시켜줘야한다.
	
	private final String command="insert.tv";
	private String getPage = "travelInsertForm";
	private String gotoPage = "redirect:/list.tv";
	
	@Autowired
	private TravelDao travelDao;
	
	// travelList.jsp 추가하기 버튼 클릭
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction() {
		
		return getPage;
	}
	
	// travelInsertForm.jsp submit 버튼 클릭
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doAction(@ModelAttribute("travel") @Valid TravelBean travel, BindingResult result) {	//BindingResult 유효성검사시 오류잡기용
		
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {	//문제가 있을경우
			mav.setViewName(getPage);
			return mav;	//올때도 바로 컨트롤이 아닌 web.xml에서 설정한 dispatch 서블릿을 먼저 들리듯이 보낼때도 dispatch 서블릿을 들렸다간다.
		}				//거기서 어느 패키지로 갈지도 대충 정해준다. 이게맞나?
		
		int cnt = travelDao.insertTravel(travel);
		
		mav.setViewName(gotoPage);
		
		return mav;
	}
	
}
