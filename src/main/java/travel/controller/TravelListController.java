package travel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import travel.model.TravelBean;
import travel.model.TravelDao;
import utility.Paging;

@Controller
public class TravelListController {
	private final String command="/list.tv";	//2������ ���ķ� �Ѿ�� /�� ������ /�� �νĸ���
	private String getPage = "travelList";
	
	@Autowired
	private TravelDao travelDao;
	
	@RequestMapping(value=command)
	public ModelAndView doAction(
									@RequestParam(value="whatColumn", required = false) String whatColumn,
									@RequestParam(value="keyword", required = false) String keyword,
									@RequestParam(value="pageNumber", required = false) String pageNumber,
									HttpServletRequest request) {
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("whatColumn", whatColumn);	//������ �̰ž���. put		���� area or style
		map.put("keyword", "%"+keyword+"%");	//������ �̰ž���.		keyword = %��% �̷�������   or %��% �̷�������
		
		int totalCount = travelDao.getTotalCount(map);	//��ü ���ڵ� ����		�̷������� �������� �ִ�.
		
		//url ����������
		String url = request.getContextPath() + command;	//ex/list.tv 	ex�� �پ��� �ǹ̰� ����ִ�.
					//������Ʈ�� ��Ű������ �����°�
		Paging pageInfo = new Paging(pageNumber, null, totalCount, url, whatColumn,keyword);
									//���� �޴°� �������� null�� �Ѱܵ� �ȴ�.	int�� 0
		
		ModelAndView mav = new ModelAndView();
		List<TravelBean> travelLists = travelDao.getTravelList(pageInfo, map);
		
		mav.addObject("travelLists", travelLists);	//�Ӽ�����
		mav.addObject("totalCount", totalCount);	//��ü ���ڵ� ����
		mav.addObject("pageInfo", pageInfo);	//�ؿ� ����������
		
		mav.setViewName(getPage);	//�ٷ� �������ִ� ģ��
		return mav;
		
		//request.setAttribute("pageInfo", pageInfo);
		
		//return getPage;
	}
	
	
	
	
	
	
}
