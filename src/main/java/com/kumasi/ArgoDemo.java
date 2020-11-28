package com.kumasi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ArgoDemo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Integer> numbers = getUserInput(scan);
		writeToConsole(numbers);
	}

	private static List<Integer> getUserInput(Scanner scan) {
		System.out.println("Enter a list of integer values on a single line followed by the number \"99\" to stop ");
		
		boolean canContinue = true;
		List<Integer> numbers = new ArrayList<>();

		while (canContinue) {
			int val = scan.nextInt();
			if (val == 99) {
				canContinue = false;
			} else {
				numbers.add(val);
			}
		}

		return numbers;
	}

	private static void writeToConsole(List<Integer> numbers) {
		Collections.sort(numbers);
		Integer max = numbers.get(numbers.size() - 1);
		System.out.println("Highest number entered: " + max);
	}
}
