package java8;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class hackerrank {
	public static void main(String[] args) {
		int[][] a = { { 11, 2, 4 }, { 4, 5, 6 }, { 10, 8, -12 } };
		int[] result = new int[2];
		int l = 0, k = 0;
		for (int i = 0; i < 3; i++) {
			l = l + a[i][i];
		}
		for (int i = 2; i > -1; i--) {
			k = k + a[i][i];
		}
		System.out.println(Math.abs(l - k));
		// IntStream.range(0, 2).forEach(i -> {
		// int j = a[i];
		// int k = b[i];
		// if (j > k) {
		// result[0]++;
		// } else if (j < k) {
		// result[1]++;
		// }
		// });
		System.out.println(Arrays.toString(result));
	}
}
