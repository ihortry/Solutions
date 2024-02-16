package interview;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SolutionRunner {

	public static void main(String[] args) throws IOException {
		ArrayList<Integer> numbers = new ArrayList<>(); 
		long count = 0l;
		File file =new File("10m.txt");
		Scanner scanner = new Scanner(file);
		 while (scanner.hasNextInt()) {
             count++;           
             int element = scanner.nextInt();
             numbers.add(element);
             //System.out.println(element+", ");
         }
		 
         // Close the scanner
         scanner.close();
         
         System.out.println(count);
         
         System.out.println("min value " + findMinValue(numbers));
         System.out.println("max value " + findMaxValue(numbers));
         System.out.println("median "+ median(numbers));
         System.out.println("avg " + avg(numbers));
         System.out.println("max ascending order "  + maxAscendingSequence(numbers));
         System.out.println("max descending order " + maxDescendingSequence(numbers));
 		//int maxValue = findMaxValue(arr);
// 		System.out.println("max value " + maxValue);
// 		
// 		System.out.println("median value " + median(arr));
// 		
// 		System.out.println("average value " + avg(arr));
	}

	public static int findMinValue(ArrayList<Integer> numbers) {
		int minValue = numbers.get(0);
		
		for(int i=1; i<numbers.size(); i++) {
			if(minValue >  numbers.get(i)) { 
				minValue = numbers.get(i);
			}
		}
//		for(int i=1; i<numbers.length(); i++) {
//			if(minValue > numbers[i]) {
//				minValue = numbers[i];
//			}
//		}
		
		return minValue;
	}
	
	public static int findMaxValue(ArrayList<Integer> numbers) {
		int maxValue = numbers.get(0);
		for(int i=1; i<numbers.size();i++) {
			if(maxValue < numbers.get(i)) {
				maxValue = numbers.get(i);
			}
		}
		
		return maxValue;
	}
//	public static int findMaxValue(int arr[]) {
//		int maxValue = arr[0];
//		for(int i=1; i<arr.length;i++) {
//			if(maxValue < arr[i]) {
//				maxValue = arr[i];
//			}
//		}
//		
//		return maxValue;
//	}
	
	public static double median(ArrayList<Integer> arr1) {
		ArrayList<Integer> arr = new ArrayList<>(arr1);
		Collections.sort(arr);
		//Arrays.sort(arr);
		int arrLength = arr.size();
		double median;
		if(arrLength%2 == 0) {
			median = (double)((arr.get(arrLength-1)/2) + arr.get(arrLength/2))/2;
		}else {
			median =arr.get(arrLength/2);
		}
		
		return median;
	}
//	public static double median(int[] arr) {
//		Arrays.sort(arr);
//		int arrLength = arr.length;
//		double median;
//		if(arrLength%2 == 0) {
//			median = (double)(arr[(arr.length-1)/2] + arr[(arr.length)/2])/2;
//		}else {
//			System.out.println(arr.length  + " here weadsfadsfa are");
//			median =arr[arrLength/2];
//		}
//		
//		return median;
//	}
	
	public static double avg(ArrayList<Integer> arr) {
		int sum =0;
		for(int i=0; i< arr.size(); i++) {
			sum = sum + arr.get(i);
		}
		
		double avg= (double)sum/arr.size();
		
		return avg;
	}
	
//	public static double avg(int[] arr) {
//		int sum =0;
//		for(int i=0; i< arr.length; i++) {
//			sum =+ arr[i];
//		}
//		
//		double avg= (double)sum/arr.length;
//		
//		return avg;
//	}
	
	public static int maxAscendingSequence(ArrayList<Integer> arr) {
		if(arr.size() <= 0) {
			return arr.size();
		} 
		int value = arr.get(0);		
		int count = 1;
		int maxCount = 1;
		int start = 0;
		int end = 0;
		for(int i=1; i<arr.size(); i++) {
			if(value < arr.get(i) ) {
				count++;
				if(maxCount < count)
				end = i;
			}else {
				maxCount = Math.max(maxCount, count);
				count = 1;				 
			}
			
			value = arr.get(i);
		}
		maxCount = Math.max(maxCount, count);
		start = end - maxCount +1;
		ArrayList<Integer> result = new ArrayList<>();
		for(int i=start; i <=end; i++) {
			result.add(arr.get(i));
		}
		System.out.println(result);
		return maxCount;
	}
	
	public static int maxDescendingSequence(ArrayList<Integer> arr) {
		if(arr.size() <= 0) {
			return arr.size();
		} 
		//System.out.println( arr);
		int value = arr.get(0);		
		int count = 1;
		int maxCount = 0;
		int end = 0;
		for(int i=1; i<arr.size(); i++) {
			if(value > arr.get(i) ) {
				count++;
				if(maxCount < count)
					end = i;
			}else {
				maxCount = Math.max(maxCount, count);
				count = 1;
			}
			value = arr.get(i);
		}
		maxCount = Math.max(maxCount, count);
		int start = end - maxCount +1;
		ArrayList<Integer> result = new ArrayList<>();
		for(int i=start; i <=end; i++) {
			result.add(arr.get(i));
		}
		System.out.println("start: "+ start + "/ end: "+ end);
		System.out.println(result);
		return maxCount;
	}
}
