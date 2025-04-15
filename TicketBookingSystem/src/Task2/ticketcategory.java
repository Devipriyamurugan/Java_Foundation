package Task2;

import java.util.Scanner;

public class ticketcategory {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ticket Category");
		System.out.println("1.Gold - 4000");
		System.out.println("2 .Diamond- 2000");
		System.out.println("3.silver - 1000");
		System.out.println("Enter the type");
		String category = sc.nextLine().trim().toLowerCase();
		System.out.println("Enter the number of tickets");
		int numtickets=sc.nextInt();
		double ticketprice =0;
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
				return;
			}
		double totalcost = ticketprice * numtickets;
		System.out.println("totalcost of tickets is " + totalcost);
		}else {
			System.out.println("Invalid tickets");
		}
		sc.close();
		
		
	}

}
