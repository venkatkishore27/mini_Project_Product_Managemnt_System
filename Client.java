package pms.pojo;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		
		boolean flag = true;

		Scanner scanner = new Scanner(System.in);

		IProductService service = new ProductServiceImp();

		while (flag) {

			System.out.println("WELCOME TO PMS");
			System.out.println("1. ADD Product");
			System.out.println("2. UPDATE Product");
			System.out.println("3. DELETE Product");
			System.out.println("4. SELECT Product");
			System.out.println("5. SELECT ALL");
			System.out.println("0. EXIT");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:

				System.out.println("Enter Product ID");
				int pid = scanner.nextInt();
				System.out.println("Enter Product Name");
				String pname = scanner.next();
				System.out.println("Enter Price");
				double price = scanner.nextDouble();
				System.out.println("Enter Date of Manufacture");
				Date dom = Date.valueOf(scanner.next());

				Product p1 = new Product();

				p1.setPid(pid);
				p1.setPname(pname);
				p1.setPrice(price);
				p1.setDom(dom);

				boolean isValid = ProductServiceImp.dataValidation(p1);

				if (isValid == true) {

					int count = service.addProduct(p1);

					System.out.println(count + " records inserted");
				} else {

		System.err.println("Invalid Inputs , Please Enter Correct Data");

				}

				break;
			case 2:

				System.out.println("Enter Dept No.");
				int pid1 = scanner.nextInt();
				System.out.println("Enter Dept Name");
				String pname1 = scanner.next();
				System.out.println("Enter Location");
				double price1 = scanner.nextDouble();
				System.out.println("Enter Date of Manufacture");
				Date dom1 = Date.valueOf(scanner.next());

				Product p2 = new Product();

				p2.setPid(pid1);
				p2.setPname(pname1);
				p2.setPrice(price1);
				p2.setDom(dom1);
				
				int count1 = service.updateProduct(p2);

				System.out.println(count1 + " records updated");

				break;
			case 3:

				System.out.println("Enter DeptNo to delete one record");

				int pid2 = scanner.nextInt();

				int count2 = service.deleteProduct(pid2);

				System.out.println(count2 + " record deleted");

				if(count2 == 0) {
					
					try {
					throw new ProductNotFoundException();
					}
					catch (Exception e) {

					System.err.println("Product Not Found , Cant delete record");
					}
				}
				
				
				break;
			case 4:

				System.out.println("Enter pid to select record");
				int pid3 = scanner.nextInt();

				Product pdObj = service.getProduct(pid3);

				System.out.println(pdObj);

					if(pdObj  == null) {
					
					try {
					throw new ProductNotFoundException();
					}
					catch (Exception e) {

	System.err.println("Product Not Found , Can't search record");
					}
				
					}
				break;

			case 5:

				List<Product> list = service.getAll();

				for (Product pd : list) {
					System.out.println(pd);

				}

				break;

			case 0:

				flag = false;
				
				DBUtil.closeConncetion();
				System.out.println("Thank you visit again..");

				break;

			default:
				System.err.println("Invalid input");
				break;
			}

		}
	}

}
