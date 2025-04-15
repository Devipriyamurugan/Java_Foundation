package Task3;

import java.util.Scanner;

public class loops {
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("Ticket Category");
			System.out.println("1.Gold - 4000");
			System.out.println("2 .Diamond- 2000");
			System.out.println("3.silver - 1000");
			System.out.println("Enter the type");
			String category = sc.nextLine().trim().toLowerCase();
			if(category.equals("exit")) {
				System.out.println("Thankyou for visiting");
				break;
			}
			System.out.println("Enter the number of tickets");
			int numtickets = sc.nextInt();
		
		try {
			numtickets = Integer.parseInt(sc.nextLine());
		}catch (NumberFormatException e) {
			System.out.println("Invalid number...try again..");
			continue;
		}
		double ticketprice=0;
		if(numtickets>0) {
			if(category.equals("gold")) {
				ticketprice=4000;
			}
			else if(category.equals("diamond")) {
				ticketprice=2000;
			}
			else if(category.equals("silver")) {
				ticketprice=1000;
			}
			else {
				System.out.println("Invalid type");
				sc.close();
				continue;
			}
			double totalcost = ticketprice * numtickets;
			System.out.println("totalcost of tickets is " + totalcost);
			}else {
				System.out.println("Invalid tickets");
			}
			sc.close();
	}
	}

}
