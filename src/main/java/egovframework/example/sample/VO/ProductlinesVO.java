package egovframework.example.sample.VO;

public class ProductlinesVO extends ShopDefaultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String productline;
	
	private String textDescription;
	
	private String htmlDescription;
	
	private String image;
	
	public String getProductline() {
		return productline;
	}
	
	public void setProductline(String productline) {
		this.productline = productline;
	}
	
	public String getTextDescription() {
		return textDescription;
	}
	
	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}
	
	public String getHtmlDescription() {
		return htmlDescription;
	}
	
	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
}
