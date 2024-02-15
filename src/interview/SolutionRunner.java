package interview;

import java.util.Arrays;

public class SolutionRunner {

	public static void main(String[] args) {
		int[] arr = {-3453, -180, -134, -123,-90,-80,-70,-40,-80, -9, 1, 1,2,3,4,5,6};
		System.out.println(arr.length);
		int minValue = findMinValue(arr); 
		System.out.println("min value " + minValue);
		int maxValue = findMaxValue(arr);
		System.out.println("max value " + maxValue);
		
		System.out.println("median value " + median(arr));
		
		System.out.println("average value " + avg(arr));
		
		//System.out.println("Maxcount " + maxAscendingSequence(arr));
		
		
	}

	public static int findMinValue(int arr[]) {
		int minValue = arr[0];
		for(int i=1; i<arr.length; i++) {
			if(minValue > arr[i]) {
				minValue = arr[i];
			}
		}
		
		return minValue;
	}
	
	public static int findMaxValue(int arr[]) {
		int maxValue = arr[0];
		for(int i=1; i<arr.length;i++) {
			if(maxValue < arr[i]) {
				maxValue = arr[i];
			}
		}
		
		return maxValue;
	}
	
	public static double median(int[] arr) {
		Arrays.sort(arr);
		int arrLength = arr.length;
		double median;
		if(arrLength%2 == 0) {
			median = (double)(arr[(arr.length-1)/2] + arr[(arr.length)/2])/2;
		}else {
			System.out.println(arr.length  + " here weadsfadsfa are");
			median =arr[arrLength/2];
		}
		
		return median;
	}
	
	public static double avg(int[] arr) {
		int sum =0;
		for(int i=0; i< arr.length; i++) {
			sum =+ arr[i];
		}
		
		double avg= (double)sum/arr.length;
		
		return avg;
	}
	
	public static int maxAscendingSequence(int[] arr) {

		int value = arr[0];
		
		int count = 1;
		int maxCount = 0;
		for(int i=1; i<arr.length; i++) {
			if(value < arr[i]) {				
				count++;
			}else {
				System.out.println("max count "+ maxCount);
				System.out.println("  count "+ count);
				maxCount = Math.max(maxCount, count);			
				count = 1;
				
			}
			value = arr[i];
		}
		maxCount = Math.max(maxCount, count);
		return maxCount;
	}
}
