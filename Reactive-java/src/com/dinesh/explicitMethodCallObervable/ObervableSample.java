package com.dinesh.explicitMethodCallObervable;

import rx.Observable;
import rx.functions.Action1;

public class ObervableSample {

	public static void main(String[] args) {
	
		onNextCall();
		
		onErrorCall();
		
		
	}

	//onNext and onError call
	private static void onErrorCall() {
		Observable<String> observable = Observable.just("Sample Observable with onNext and onError");
	//	Observable<String> observable = Observable.just("Sample Observabl".substring(0, 100));
		Action1<String> onNextCall = msgToDisplay ->System.out.println(msgToDisplay);
		Action1<Throwable> onErrorCall = Exception::new;
		observable.subscribe(onNextCall,onErrorCall);//cold obsevable--not invoke until subscribe
		
	}

	//onNext call 
	private static void onNextCall() {
		Observable<String> observable = Observable.just("Sample Observable with onNext");
		Action1<String> onNextCall = msgToDisplay ->System.out.println(msgToDisplay);
		observable.subscribe(onNextCall);//cold obsevable--not invoke until subscribe
	}

}
