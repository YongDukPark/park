package travel.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class TravelBean {
	
	
	private int num;
	@NotBlank(message="�̸��� �ʼ��Դϴ�.")	//�տ� ���� �Ⱥ��δ�.
	private String name;
	
	//@Min(value= 10, message = "10��~100��") 
	//@Max(value= 100, message = "10��~100��") 
	@Range(min = 10, max = 100, message = "10~100����")	//�ԷµǴ� ���� 10~100�� �����ϴٴ� �Ŵ�
	private int age;
	
	@NotNull(message = "�������� 1�� �̻� �����ؾ� �մϴ�.")
	private String area;	//check
	
	@NotNull(message = "����Ÿ���� �����ؾ� �մϴ�.")
	private String style;	//radio
	
	@NotEmpty(message = "���ϴ� ���ݴ븦 �����ؾ� �մϴ�.")
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
	public void setArea(String area) {	// ����,������, �̷������� �˾Ƽ� ����ȴ�.	�׷����� �����Ͱ� ������ �ʾҴµ� �˾Ƽ� ���δ�.
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
