package task1;

import java.util.Scanner;

public class ticketsbooking {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter available tickets");
		int availabletickets = sc.nextInt();
		System.out.println("Enter number of tickets");
		int numberoftickets = sc.nextInt();
		if (availabletickets > numberoftickets) {
			int remainingtickets = availabletickets - numberoftickets;
			System.out.println("Booking Sucessful");
			System.out.println("RemainingTickets = " + remainingtickets);

			
		}
		else {
			System.out.println("Tickets un available. only " + availabletickets + "available");
		}
		sc.close();
		// TODO Auto-generated method stub

	}

}
