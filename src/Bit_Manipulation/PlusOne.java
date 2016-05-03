package Bit_Manipulation;

public class PlusOne {

	public static int[] plusOne(int[] digits) {
		
		
		int len = digits.length;
		int resArray[] = new int[len+1];
		int times = len;
		int carryBit = 0;

		for (int i = len - 1; i >= 0; --i) {
			if (i == len - 1) {
				int res = digits[i] + carryBit + 1;
				if (res > 9) {
					carryBit += 1;
					digits[i] = res - 10;
				}
				else {
					digits[i] = res;
				}
				continue;
			}

			int res = 0;
			if (carryBit != 0) {
				res = digits[i] + carryBit;
				carryBit = 0;
			}
			else {
				res = digits[i];
			}
			if (res > 9) {
				carryBit += 1;
				digits[i] = res - 10;
			} else {
				digits[i] = res;
				carryBit = 0;
			}
		}
		
		if (carryBit != 0) {
			resArray[0] = 1;
			for (int i = 1; i < resArray.length; i++) {
				resArray[i] = digits[i-1];
			}
			return resArray;
		}
		else{
			int res[] = new int[len];
			for (int i = 0; i < digits.length; i++) {
				res[i] = digits[i];
			}
			return res;
		}
	}

	public static void main(String[] args) {
		int[] digits = {3,6,4};
		int[] res = plusOne(digits);
		for (int i = 0; i < res.length ; i++) {
			System.out.println(res[i]);
		}
	}
}
