import java.util.Scanner;

class test {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {

			String[] input = new String[6];
			for (int i = 0; i < input.length; i++) {
				input[i] = in.next();
			}
			
			String[][] arrays = new String[6][6];
			char[] c = new char[6];
			
			for (int i = 0; i < 6; i++) {
				c = input[i].toCharArray();
				for (int j = 0; j < 6; j++) {
					arrays[i][j] = String.valueOf(c[i]);
				}
			}
		//	isVolid?
			if (!isValid(arrays)) {
				System.out.println("0");
				return ;
			}
//	---------------process valid ------------------------
	}
}

	public static boolean isValid(String[][] array) {
		int times = 0;
		// row by row
		for (int i = 0; i < 6; i++) {

			for (int j = 0; j < 6; j++) {
				if (array[i][j].equals("o")) {
					times++;
				}
			}
			if (times > 3) {
				return false;
			} else {
				times = 0;
			}
		}
		// col by col
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (array[j][i].equals("o")) {
					times++;
				}
			}
			if (times > 3) {
				return false;
			} else {
				times = 0;
			}
		}

		return true;
	}
}