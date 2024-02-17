/**
 * 	@author Ihor Tryndey
 *  @version 1.0
 *  @since 2024
 */
package interview;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 
 * @author Ihor Tryndey
 *
 * Class SolutionRunner in which I run solutions to the problems
 */
public class SolutionRunner {

	/**
	 * main method
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		/*
		 * creation of container for all integers in file
		 */
		ArrayList<Integer> numbers = new ArrayList<>(); 
		
		/*
		 * Initialisation of file in a variable and declaration of Scanner
		 */
		File file =new File("10m.txt");
		Scanner scanner = new Scanner(file);
		
		/*
		 * Here i read all numbers into array
		 */
		 while (scanner.hasNextInt()) {           
             int element = scanner.nextInt();
             numbers.add(element);
         }
		 
         // Close the scanner
         scanner.close();
         
         //print out min value using method findMinValue()
         System.out.println("min value " + findMinValue(numbers));
         
         //print out max value using method findMinValue()
         System.out.println("max value " + findMaxValue(numbers));
         
         //print out median value using method findMinValue()
         System.out.println("median "+ median(numbers));
         
         //print out average value using method findMinValue()
         System.out.println("avg " + avg(numbers));
         
         //print out max number of ascending numbers in sequence value using method findMinValue(), also I print out this sequence
         System.out.println("max ascending order "  + maxAscendingSequence(numbers));
         
         //print out max number of descending numbers in sequence value using method findMinValue(), also I print out this sequence
         System.out.println("max descending order " + maxDescendingSequence(numbers));

	}

	/**
	 * Method findMinVAlue which find min value in the given ArrayList
	 * @param numbers an ArrayList<Integer>
	 * @return int minValue 
	 */
	public static int findMinValue(ArrayList<Integer> numbers) {
		//in the line below I take the first number as the lowest
		int minValue = numbers.get(0);
		
		//this loop is goes through all elements in ArrayList
		for(int i=1; i<numbers.size(); i++) {
			//if value in index i lowest than minValue -> perform swamping 
			if(minValue >  numbers.get(i)) { 
				minValue = numbers.get(i);
			}
		}
		
		return minValue;
	}
	
	/**
	 * Method findMinVAlue which find max value in the given ArrayList
	 * @param numbers an ArrayList<Integer>
	 * @return int maxValue
	 */
	public static int findMaxValue(ArrayList<Integer> numbers) {
		//in the line below I take the first number as the largest
		int maxValue = numbers.get(0);
		
		//this loop is goes through all elements in ArrayList
		for(int i=1; i<numbers.size();i++) {
			//if value in index i larger than maxValue -> perform swamping 
			if(maxValue < numbers.get(i)) {
				maxValue = numbers.get(i);
			}
		}
		
		return maxValue;
	}
	
	/**
	 * Method median which find the median of the given ArrayList 
	 * @param arr1 an ArrayList<Integer>
	 * @return int median
	 */
	public static double median(ArrayList<Integer> arr1) {
		//Creation an new ArrayList to sort it and not change data in original one
		ArrayList<Integer> arr = new ArrayList<>(arr1);
		//Sort this array, because first we should order the data to find median
		Collections.sort(arr);
		int arrLength = arr.size();
		double median;
		
		//algorithm for list of integers which have even number of elements
		if(arrLength%2 == 0) {
			/*
			 * for even number of elements, we should find two centre elements
			 */
			median = (double)((arr.get(arrLength-1)/2) + arr.get(arrLength/2))/2;
		//algorithm for list of integers which have odd number of elements
		}else {
			median =arr.get(arrLength/2);
		}
		
		return median;
	}
	
	public static double avg(ArrayList<Integer> arr) {
		int sum =0;
		for(int i=0; i< arr.size(); i++) {
			sum = sum + arr.get(i);
		}
		
		double avg= (double)sum/arr.size();
		
		return avg;
	}
	
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
		System.out.println(result);
		return maxCount;
	}
}
