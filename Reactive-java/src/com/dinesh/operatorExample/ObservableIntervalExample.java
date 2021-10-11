package com.dinesh.operatorExample;

import java.util.concurrent.TimeUnit;


import rx.Observable;
import rx.observables.BlockingObservable;

public class ObservableIntervalExample {

	public static void main(String[] args) {
		BlockingObservable<Long> observable = Observable.interval(5, TimeUnit.SECONDS)//emit events at every 5 sec
													.take(10)//take first 10 elements
													.toBlocking();//for sequential execution
		observable.subscribe(System.out::println);
		
	}
}
