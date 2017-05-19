package programacionIII.TPE.arreglo;

public class simuladorQS {

	public static void main(String[] args) {
		String[] arr = new String[5];
		arr[0] = "4";
		arr[1] = "2";
		arr[2] = "5";
		arr[3] = "1";
		arr[4] = "3";
		
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		new Quicksort(arr);
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}

}
