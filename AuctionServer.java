import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class AuctionServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			try {
				
				System.out.println("Welcome to Auction Server\n Server is binding the objects to rmi registry.");
				
				Naming.rebind("rmi://localhost/biddingObj", new BiddingClass());
				Naming.rebind("rmi://localhost/memberObj", new Member());
				Naming.rebind("rmi://localhost/productObj", new ProductClass());
				
				System.out.println("Auction Server is Ready.");
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
