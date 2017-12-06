import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String policy = scan.nextLine();
		Policy newPolicy = callTheRightPolicy(policy);
		int operationNum = scan.nextInt();
		switch (operationNum) {
		case 1:
			int desiredSize = scan.nextInt();
			MMS.allocate(newPolicy, desiredSize);
			break;
		case 2:
			int startedAddress = scan.nextInt();
			MMS.deallocate(startedAddress);
			break;
		case 3:
			int caseNumber = scan.nextInt();
			MMS.defragment(caseNumber);
			break;
		case 4:
			MMS.printStatus();
			break;
		default:
			System.out.println("Undefined Operation");
			break;

		}
		scan.close();
	}

	public static Policy callTheRightPolicy(String policy) {
		if (policy.equals("BEST-FIT")) {
			new BestFit();
		} else if (policy.equals("WORST-FIT")) {
			new WorstFit();
		} else {
			new FirstFit();
			;
		}
	}
}
