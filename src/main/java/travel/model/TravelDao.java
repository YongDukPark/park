package travel.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

//TravelDao myTravelDao = new TravelDao();
@Component("myTravelDao")	// 괄호에는 참조변수가 들어간다
public class TravelDao {
	private String namespace = "travel.TravelBean";
	
	@Autowired	//어디선가 만들어진 객체를 가져와서 넣어라
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	public int getTotalCount(Map<String,String> map) {	//레코드 갯수
		
		int count = sqlSessionTemplate.selectOne(namespace+".GetTotalCount",map);	//map 검색어를 조건으로 할수있도록 한다.	 찾을수 있도록 한다.
									//한줄만 가져와라 이런뜻이다.
		return count;
	}
	
	public List<TravelBean> getTravelList(Paging pageInfo, Map<String,String> map){
		List<TravelBean> lists = new ArrayList<TravelBean>();
		
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());	
											//몇개를 건너뛰고		,	몇개를 가져와라
		lists = sqlSessionTemplate.selectList(namespace+".GetTravelList",map,rowBounds);	//4개 건너뛰고 2개만 이런식으로 가져올수있다. 검색어에 해당하는것들
		
		return lists;
	}
	
	public int insertTravel(TravelBean travel) {
		int cnt = sqlSessionTemplate.insert(namespace+".InsertTravel",travel);
		
		return cnt;
		
	}

	public TravelBean getTravel(int num) {
		
		TravelBean travel = sqlSessionTemplate.selectOne(namespace+".GetTravel",num);
		
		return travel;
	}

	public int Update(TravelBean travel) {
		int cnt = sqlSessionTemplate.update(namespace+".Update",travel);
		return cnt;
	}

	public void getNyNumDelete(int num) {
		sqlSessionTemplate.delete(namespace+".Delete",num);
	}

	
}
