package pms.pojo;

import java.util.List;

public interface IProductService {
	
	public int addProduct(Product pdt);
	public int updateProduct(Product pdt);
	public int deleteProduct(int pdID);
	public Product getProduct(int pdID );
	public List<Product>  getAll();
	
}
