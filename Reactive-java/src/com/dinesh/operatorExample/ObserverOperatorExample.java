package com.dinesh.operatorExample;

import rx.Observable;
import rx.functions.Func1;

public class ObserverOperatorExample {

	public static void main(String[] args) {
		
		//odd number function
		Func1<Integer, Boolean> oddNumers = x->x%2==1;
		
		//square function
		Func1<Integer, Integer> squareFunction = x->x*x;
		
		//get square of odd number from 10 to 40 range(Start,count)
		Observable<Integer> observable = Observable.range(10, 30)
									.filter(oddNumers)
									.map(squareFunction);
		
		observable.subscribe(System.out::println);

	}
}
