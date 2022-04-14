package travel.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class TravelBean {
	
	
	private int num;
	@NotBlank(message="이름은 필수입니다.")	//앞에 공백 안붙인다.
	private String name;
	
	//@Min(value= 10, message = "10세~100세") 
	//@Max(value= 100, message = "10세~100세") 
	@Range(min = 10, max = 100, message = "10~100사이")	//입력되는 값이 10~100중 가능하다는 거다
	private int age;
	
	@NotNull(message = "관심지역 1개 이상 선택해야 합니다.")
	private String area;	//check
	
	@NotNull(message = "여행타입을 선택해야 합니다.")
	private String style;	//radio
	
	@NotEmpty(message = "원하는 가격대를 선택해야 합니다.")
	private String price;	//select~ option
	
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {	// 유럽,동남아, 이런식으로 알아서 연결된다.	그러고보니 데이터가 쌓지도 않았는데 알아서 쌓인다.
		this.area = area;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public TravelBean(int num, String name, int age, String area, String style, String price) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
		this.area = area;
		this.style = style;
		this.price = price;
	}
	public TravelBean() {
		super();
	}
	
	
	
	
}
