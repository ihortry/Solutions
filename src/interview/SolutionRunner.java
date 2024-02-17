/**
 * 	@author Ihor Tryndey
 *  @version 1.0
 *  @since 2024
 */
package interview;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
	 * Method findMinVAlue() which find min value in the given ArrayList
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
	 * Method findMinVAlue() which find max value in the given ArrayList
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
	 * Method median() which find the median of the given ArrayList 
	 * @param arr1 an ArrayList
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
	
	/**
	 * Method avg() that find average value of the given ArrayList
	 * @param arr ArrayList
	 * @return int avg
	 */
	public static double avg(ArrayList<Integer> arr) {
		//Initialisation of variable in which stored sum of all element.
		long sum =0l;

		//add all elements in sum
		for(int i=0; i< arr.size(); i++) {
			sum = sum + arr.get(i);
		}
		//find average value
		double avg= (double)sum/arr.size();
		
		return avg;
	}
	
	/**
	 * Method maxAscendingSequence() which find value of max ascending elements in sequence and print this values
	 * @param arr an ArrayList
	 * @return int maxCount
	 */
	public static int maxAscendingSequence(ArrayList<Integer> arr) {
		//if number of elements in ArrayList equals 1 of 0 return arr.size as sequence
		if(arr.size() <= 1) {
			return arr.size();
		} 
		int value = arr.get(0);		
		int count = 1;
		int maxCount = 1;
		
		/*
		 * two variables which help find the start and the end of the set of max elements in ascending sequence
		 */
		int start = 0;
		int end = 0;
		
		//find the maxCount of ascending order of elements in a sequence in ArrayList
		for(int i=1; i<arr.size(); i++) {
			//addition of count by 1 if next is larger than previous 
			if(value < arr.get(i) ) {
				count++;
				//updating of end if condition is true
				if(maxCount < count)
				end = i;
			//updating the maxCount and restart variable count
			}else {
				maxCount = Math.max(maxCount, count);
				count = 1;				 
			}
			//change value to next one
			value = arr.get(i);
		}
		//check the last one sequence if it the largest sequence
		maxCount = Math.max(maxCount, count);
		
		//find the start of the sequence
		start = end - maxCount +1;
		
		//creating the container for result set
		ArrayList<Integer> result = new ArrayList<>();
		//fill this ArrayList with elements
		for(int i=start; i <=end; i++) {
			result.add(arr.get(i));
		}
		//print this result
		System.out.println(result);
		return maxCount;
	}
	
	/**
	 * Method maxDescendingSequence() which find value of max descending elements in sequence and print out this values
	 * @param arr an ArrayList
	 * @return int maxCount
	 */
	public static int maxDescendingSequence(ArrayList<Integer> arr) {
		//if number of elements in ArrayList equals 1 of 0 return arr.size as sequence
		if(arr.size() <= 0) {
			return arr.size();
		} 
		int value = arr.get(0);		
		int count = 1;
		int maxCount = 0;
		
		/*
		 * two variables which help find the start and the end of the set of max elements in descending sequence
		 */
		int end = 0;
		int start =0;
		
		//find the maxCount of descending order of elements in a sequence in ArrayList
		for(int i=1; i<arr.size(); i++) {
			//addition of count by 1 if next is lower than previous
			if(value > arr.get(i) ) {
				count++;
				//updating of end if condition is true
				if(maxCount < count)
					end = i;
			//updating the maxCount and restart variable count
			}else {
				maxCount = Math.max(maxCount, count);
				count = 1;
			}
			//change value to next one
			value = arr.get(i);
		}
		//check the last one sequence if it the largest sequence
		maxCount = Math.max(maxCount, count);
		//find the start of the sequence
		start = end - maxCount +1;
		//creating the container for result set
		ArrayList<Integer> result = new ArrayList<>();
		//fill this ArrayList with elements
		for(int i=start; i <=end; i++) {
			result.add(arr.get(i));
		}
		//print this result
		System.out.println(result);
		return maxCount;
	}
}
