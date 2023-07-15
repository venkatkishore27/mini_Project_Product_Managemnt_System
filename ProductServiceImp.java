package pms.pojo;

import java.util.List;

public class ProductServiceImp implements IProductService {
	
	
	private	ProductDAO  dao = new ProductDAO();
	
	@Override
	public int addProduct(Product pdt) {
		// TODO Auto-generated method stub
		return dao.addProduct(pdt);
	}
	
	@Override
	public int updateProduct(Product pdt) {
		// TODO Auto-generated method stub
		return dao.updateProduct(pdt);
	}
	
	@Override
	public Product getProduct(int pdID) {
		// TODO Auto-generated method stub
		return dao.getProduct(pdID);
	}
	
	@Override
	public int deleteProduct(int pdID) {
		// TODO Auto-generated method stub
		return dao.deleteProduct(pdID);
	}
	
	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}
	
	public static boolean  dataValidation(Product pdID) {
		
		boolean flag = false;
		
		if(pdID.getPid() > 99 
		&& pdID.getPname().length() >= 4 
		&& pdID.getPrice() < 10000) {
			
				flag = true;
		}
		
		return flag;
	}
	
}
