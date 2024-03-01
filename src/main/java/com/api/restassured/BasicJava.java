package com.api.restassured;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;




class Parent {

    void show()

    {

        System.out.println("I am Parent");

    }

}

class Child extends Parent {

    void show()

    {

        System.out.println("I am Child");

    }

}

public class BasicJava {
	static int ttttt,tttttt,tetststs=3050;

	public BasicJava() {
		this("Test");
		// System.out.println("First");
	}

	public BasicJava(String test) {

		// System.out.println(test);
	}

	static void isAnagram(String str1, String str2) {

		String s1 = str1.replaceAll("\\s", "");

		String s2 = str2.replaceAll("\\s", "");

		System.out.println(s1);

		boolean status = true;

		if (s1.length() != s2.length()) {

			status = false;

		} else {

			char[] ArrayS1 = s1.toLowerCase().toCharArray();

			char[] ArrayS2 = s2.toLowerCase().toCharArray();

			// Arrays

			Arrays.sort(ArrayS1);

			Arrays.sort(ArrayS2);

			// System.out.println(Arrays.sort(ArrayS1));

			status = Arrays.equals(ArrayS1, ArrayS2);

		}

		if (status) {

			System.out.println(s1 + " and " + s2 + " are anagrams");

		} else {

			System.out.println(s1 + " and " + s2 + " are not anagrams");

		}

	}
	
	static {
		 tttttt=0330;
	}

	static public void main(String[] args) throws CloneNotSupportedException {
		
		
		 Scanner sc = new Scanner(System.in);
		 
	        // String input
	        String name = sc.nextLine();
	 
	        // Character input
	        char gender = sc.next().charAt(0);
	 
	        // Numerical data input
	        // byte, short and float can be read
	        // using similar-named functions.
	        int age = sc.nextInt();
	        long mobileNo = sc.nextLong();
	        double cgpa = sc.nextDouble();
	 
	        // Print the values to check if the input was
	        // correctly obtained.
	        System.out.println("Name: " + name);
	        System.out.println("Gender: " + gender);
	        System.out.println("Age: " + age);
	        System.out.println("Mobile Number: " + mobileNo);
	        System.out.println("CGPA: " + cgpa);
		
	    ttttt=30;
		
		int[] n1 = new int[0];

		boolean[] n2 = new boolean[200];

		//double[] n3 = new double[2241423798];

		//char[] ch = new char[20];
		
		    Parent obja = new Parent();

	        obja.show();

	        Parent objb = new Child();

	        objb.show();

	        int[] testyiii=new int[12];
	        
	        int[][] tetst= new int[3][2];
	        tetst[0][0]= 1;
	        tetst[0][1]= 2;
	        tetst[1][0]= 3;
	        tetst[1][1]= 4;
	        tetst[2][0]= 5;
	        tetst[2][1]= 6;
	        System.out.println("Original Matrix: \n");

			// loop for rows

			for (int i = 0; i < 3; i++)

			{

				// loop for columns

				for (int j = 0; j < 2; j++)

				{

					// prints the elements of the original matrix

					System.out.print(" " + tetst[i][j] + "\t");

				}

				System.out.println("\n");

			}


	        
	        System.out.println();
	        System.out.println(testyiii.length);
	        


		int arrayy[] = { 1, 2, 3, 4, 11, 12, 13, 14, 21, 22, 23, 24, 31, 32 };

		int high = 0;

		int nextHigh = 0;

		System.out.println("The given array is:");

		for (int i = 0; i < arrayy.length; i++)

		{

			System.out.print(arrayy[i] + "\t");

		}

		for (int i = 0; i < arrayy.length; i++)

		{

			if (arrayy[i] > high)

			{

				nextHigh = high;

				high = arrayy[i];

			}

			else if (arrayy[i] > nextHigh)

			{

				nextHigh = arrayy[i];

			}

		}

		System.out.println("Second Highest is:" + nextHigh);

		System.out.println("Highest Number is: " + high);

		String str = "Hello World, Welcome to Simplilearn";

		String[] split = str.split(" ");

		HashMap<String, Integer> mapp = new HashMap<String, Integer>();

		for (int i = 0; i < split.length; i++) {

			if (mapp.containsKey(split[i])) {

				int count = mapp.get(split[i]);

				mapp.put(split[i], count + 1);

			} else {

				mapp.put(split[i], 1);

			}

		}

		// System.out.println(map);

		StringBuilder string = new StringBuilder("Naresh");
		StringBuffer string_1 = new StringBuffer("Talesha");

		List<Integer> num = new ArrayList<Integer>();

		num.add(1);

		num.add(2);

		num.add(3);

		num.add(4);

		num.add(5);

		num.add(6);

		num.add(3);

		Set<Integer> primesWithoutDuplicates = new HashSet<Integer>(num);

		num.clear();

		num.addAll(primesWithoutDuplicates);

		System.out.println(num);

		String testing = "NareshTalesha";

		char[] array = testing.toCharArray();

		// ;

		System.out.println(Math.sqrt(25));

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (Character ch : array) {

			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}

		Set<Map.Entry<Character, Integer>> en = map.entrySet();

		for (Map.Entry<Character, Integer> mappp : en) {
			mappp.getKey();
			mappp.getValue();
		}

		// map.en
		System.out.println(map);

		Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();

		// System.out.printf("List of duplicate characters in String '%s' %n", word);

		for (Map.Entry<Character, Integer> entry : entrySet) {

			if (entry.getValue() > 1) {

				System.out.printf("%s: %d %n", entry.getKey(), entry.getValue());

			}

		}

		String val = "";
		for (int i = testing.length() - 1; i > 0; i--) {
			val = val + testing.charAt(i);
		}
		System.out.println(val);
		// string.reverse();

		System.out.println(string.reverse());
		System.out.println(string_1.reverse());

		isAnagram("Keep", "Peek");

		isAnagram("Mother In Law", "Hitler Woman");
		// TODO Auto-generated method stub
		// System.out.println("Inside First Main");

		// System.out.println(100+100+"Simplilearn");

		// System.out.println("E-Learning Company"+100+100);
		// BasicJava java=new BasicJava();

		// java.clone();

		String string1 = new String("TESTING");

		// String string1="TESTING";
		String string2 = "TESTING";

		System.out.println(string1 == string2);
		try {

			System.out.println(string1 == string2);
			// System.exit(0);
		} finally {
			System.out.println(string1 == string2);
		}

		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		System.out.println("Original Matrix: \n");

		// loop for rows

		for (int i = 0; i < 3; i++)

		{

			// loop for columns

			for (int j = 0; j < 3; j++)

			{

				// prints the elements of the original matrix

				System.out.print(" " + a[i][j] + "\t");

			}

			System.out.println("\n");

		}

		System.out.println("Rotate Matrix by 90 Degrees Clockwise: \n");

		for (int i = 0; i < 3; i++)

		{

			for (int j = 2; j >= 0; j--)

			{

				// prints the elements of the rotated matrix

				System.out.print("" + a[j][i] + "\t");

			}

			System.out.println("\n");
		}

	}

	static public void main(String[] args, String[] args1) throws CloneNotSupportedException {
		// TODO Auto-generated method stub

		System.out.println("Inside Second Main");

		System.out.println("E-Learning Company" + 100 + 100);
		BasicJava java = new BasicJava();

		// java.clone();

	}

}
