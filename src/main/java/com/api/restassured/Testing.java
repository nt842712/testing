package com.api.restassured;

import java.util.ArrayList;

public class Testing {

	public static void main(String[] args) {
		
		int[] arr= {0};
		
		// TODO Auto-generated method stub
		subarraySum(arr,1,0);
	}
	
	
	static ArrayList<Integer> subarraySum(int[] arr,int n,int s) {
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		int temp=0;
		for(int i=0;i<arr.length;i++) {
			temp=temp+arr[i];
			for(int j=i+1;j<arr.length;j++) {
				temp=temp+arr[j];
				if(temp==s) {
					arrayList.add(i+1);
					arrayList.add(j+1);
					break;
				}else if(temp>s) {
					break;
				}
			}
			if(temp==s) {
				break;
			}
			temp=0;
		}
		System.out.println(arrayList.get(0)+"  "+arrayList.get(1));
		return arrayList;
	}

}
