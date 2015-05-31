package xml.jaxp;
/**
 * JavaBean：是一个类
 *	* 至少包含一对getXxx()(isXxx())和setXxx()方法
 *	* 必须存在默认构造
 *
 *	* 对某些已经存在的对象进行描述：封装
 */
public class Book {
	
	private String id;
	private String title;
	private Integer price;
	private String year;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Book() {
	}
	public Book(String id, String title, Integer price, String year) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.year = year;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", price=" + price + ", title=" + title
				+ ", year=" + year + "]";
	}
	
	
	
	
	

	
	

}
