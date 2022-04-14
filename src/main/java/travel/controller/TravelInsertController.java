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
public class TravelInsertController {	//controller �� ���� ����� �ٽ� �����������Ѵ�.
	
	private final String command="insert.tv";
	private String getPage = "travelInsertForm";
	private String gotoPage = "redirect:/list.tv";
	
	@Autowired
	private TravelDao travelDao;
	
	// travelList.jsp �߰��ϱ� ��ư Ŭ��
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction() {
		
		return getPage;
	}
	
	// travelInsertForm.jsp submit ��ư Ŭ��
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doAction(@ModelAttribute("travel") @Valid TravelBean travel, BindingResult result) {	//BindingResult ��ȿ���˻�� ��������
		
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {	//������ �������
			mav.setViewName(getPage);
			return mav;	//�ö��� �ٷ� ��Ʈ���� �ƴ� web.xml���� ������ dispatch ������ ���� �鸮���� �������� dispatch ������ ��ȴٰ���.
		}				//�ű⼭ ��� ��Ű���� ������ ���� �����ش�. �̰Ը³�?
		
		int cnt = travelDao.insertTravel(travel);
		
		mav.setViewName(gotoPage);
		
		return mav;
	}
	
}
