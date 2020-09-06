package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Loops {
	public static void main(String[] args) {

		List<Integer> sourceList = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 });
		// XXX Anonymous classes replaced by lambda
		// XXX create a stream for further operation ,removes loops
		// sourceList.stream().filter(new Predicate<Integer>() {
		//
		// @Override
		// public boolean test(Integer t) {
		// // TODO Auto-generated method stub
		// return false;
		// }
		// });

		// XXX create stream, filter stream,apply function on each element of
		// stream
		// XXX no need to tell how to iterate, focus on the actual piece of code
		// containing logic
		// XXX ------------STREAM--PREDICATE ----------.CONSUMER-- METHOD AS
		// ARGUMENT;
		// XXX sourceList.stream().filter(t ->
		// t%2==0).forEach(System.out::println);
		System.out.println("Sequential Stream");
		IntStream.range(1, 10).filter(t -> t % 2 == 0).forEach(System.out::println);
		System.out.println("Sequential Stream modify and return");
		IntStream.range(1, 10).filter(t -> t % 2 == 0).forEach(t -> System.out.println(t * 2));
		// IntStream.range(1, 10).filter(t -> t % 2 == 0)
		System.out.println("Sequential Stream modify and collect to a map");
		sourceList.stream().filter(t -> t % 2 == 0).collect(Collectors.toMap(t -> t, t -> t * 10)).forEach((k, v) -> {
			System.out.print(k);
			System.out.print("-->");
			System.out.println(v);
		});
		// reduce == Performs a reduction on the elements of this stream, using
		// the provided identity, accumulation and combining functions.
		System.out.println(sourceList.stream().reduce(10, (a, b) -> a + b, (a, b) -> {
			return a + b;
		}));
		System.out.println(sourceList.parallelStream().reduce(10, (a, b) -> a + b, (a, b) -> {
			return a + b;
		}));
		System.out.println("Parallel Stream");
		sourceList.parallelStream().filter(t -> t % 2 == 0).forEach(System.out::println);
	}
}
