package com.dinesh.singleEvent;

import rx.Single;

public class ObservableSingle {

	public static void main(String[] args) {
		Single<String> observable = Single.just("Snigle value observable..");
		observable.subscribe(System.out::println,Exception::new);
	}
}
