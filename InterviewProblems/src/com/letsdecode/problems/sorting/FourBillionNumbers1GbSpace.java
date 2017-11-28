package com.letsdecode.problems.sorting;

import java.util.Scanner;

public class FourBillionNumbers1GbSpace {
	private Scanner sc;
	int radix = 8;
	private byte[] bitfield = new byte[0xffffffff / radix];

	public FourBillionNumbers1GbSpace(Scanner sc) {
		this.sc = sc;
	}

	public void call() {

		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			bitfield[n / radix] |= (1 << (n % radix));
		}

		for (int i = 0; i < bitfield.length; i++) {
			for (int j = 0; j < radix; j++) {
				if ((bitfield[i] & (1 << j)) == 0)
					System.out.print(i * radix + j);
			}
		}
	}
}
