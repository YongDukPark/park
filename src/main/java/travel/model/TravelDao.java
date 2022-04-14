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
@Component("myTravelDao")	// ��ȣ���� ���������� ����
public class TravelDao {
	private String namespace = "travel.TravelBean";
	
	@Autowired	//��𼱰� ������� ��ü�� �����ͼ� �־��
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	public int getTotalCount(Map<String,String> map) {	//���ڵ� ����
		
		int count = sqlSessionTemplate.selectOne(namespace+".GetTotalCount",map);	//map �˻�� �������� �Ҽ��ֵ��� �Ѵ�.	 ã���� �ֵ��� �Ѵ�.
									//���ٸ� �����Ͷ� �̷����̴�.
		return count;
	}
	
	public List<TravelBean> getTravelList(Paging pageInfo, Map<String,String> map){
		List<TravelBean> lists = new ArrayList<TravelBean>();
		
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());	
											//��� �ǳʶٰ�		,	��� �����Ͷ�
		lists = sqlSessionTemplate.selectList(namespace+".GetTravelList",map,rowBounds);	//4�� �ǳʶٰ� 2���� �̷������� �����ü��ִ�. �˻�� �ش��ϴ°͵�
		
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
