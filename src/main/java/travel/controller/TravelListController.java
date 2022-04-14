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
	private final String command="/list.tv";	//2페이지 이후로 넘어갈때 /가 없으면 /를 인식못함
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
		map.put("whatColumn", whatColumn);	//넣을때 이거쓴다. put		지역 area or style
		map.put("keyword", "%"+keyword+"%");	//넣을때 이거쓴다.		keyword = %유% 이런식으로   or %패% 이런식으로
		
		int totalCount = travelDao.getTotalCount(map);	//전체 레코드 갯수		이런식으로 넣을수도 있다.
		
		//url 페이지지정
		String url = request.getContextPath() + command;	//ex/list.tv 	ex에 다양한 의미가 담겨있다.
					//프로젝트명에 패키지까지 가져온거
		Paging pageInfo = new Paging(pageNumber, null, totalCount, url, whatColumn,keyword);
									//만약 받는게 없을때는 null을 넘겨도 된다.	int면 0
		
		ModelAndView mav = new ModelAndView();
		List<TravelBean> travelLists = travelDao.getTravelList(pageInfo, map);
		
		mav.addObject("travelLists", travelLists);	//속성설정
		mav.addObject("totalCount", totalCount);	//전체 레코드 갯수
		mav.addObject("pageInfo", pageInfo);	//밑에 페이지설정
		
		mav.setViewName(getPage);	//바로 가게해주는 친구
		return mav;
		
		//request.setAttribute("pageInfo", pageInfo);
		
		//return getPage;
	}
	
	
	
	
	
	
}
