import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class AuctionClient {

	public static void main(String[] args) {
		BiddingInterface bidObj;
		MemberInterface memObj;
		ProductInterface productObj;

		String lookup_Bidding = "rmi://localhost/biddingObj";
		String lookup_Member = "rmi://localhost/memberObj";
		String lookup_Product = "rmi://localhost/productObj";

		try {
			bidObj = (BiddingInterface) Naming.lookup(lookup_Bidding);
			memObj = (MemberInterface) Naming.lookup(lookup_Member);
			productObj = (ProductInterface) Naming.lookup(lookup_Product);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Welcome to Auction");
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		try {

			System.out.println("Please enter Member ID:");

			int memberId = input.read();
			
			System.out.println("Hello Member:"+memberId);


			while(input.read()!=00){

				
				System.out.println("Please enter Desired Option");
				System.out.println("1.Add Product");
				System.out.println("2.View a prduct's Description");
				System.out.println("3.View All Products");
				System.out.println("4.Remove Product");
				System.out.println("5.View current Bid of a Product");
				System.out.println("6.Increase Bid of A product");

				int option = input.read();

				switch (option) {
				case 1:
					productObj.addProduct();
					break;
				case 2:
					System.out.println("Please enter Product Id");
					productObj.findProduct(input.read());
					break;
				case 3:
					productObj.listAllPriducts();
					break;
				case 4:
					System.out.println("Please enter Product Id");
					productObj.removeProduct(input.read());
					break;
				case 5:
					System.out.println("Please enter Product Id");
					bidObj.viewCurrentBid(input.read());
					break;
				case 6:
					System.out.println("Please enter Product Id");
					bidObj.increaseBid(input.read(), memberId);
					break;
					
				default:
					System.out.println("No Option entered please try again.");
					
					break;
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
