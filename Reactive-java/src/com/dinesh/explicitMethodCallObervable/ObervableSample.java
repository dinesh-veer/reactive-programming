package com.dinesh.explicitMethodCallObervable;

import rx.Observable;
import rx.Observer;
import rx.functions.Action1;

public class ObervableSample {

	public static void main(String[] args) {
	
		onNextCall();
		System.out.println("\n---------------");
		onErrorCall();
		System.out.println("\n---------------");
		observerMethodCall();
		
		
	}

	//onNext call 
		private static void onNextCall() {
			Observable<String> observable = Observable.just("Sample Observable with onNext");
			Action1<String> onNextCall = msgToDisplay ->System.out.println(msgToDisplay);
			observable.subscribe(onNextCall);//cold obsevable--not invoke until subscribe
		}

	
	//onNext and onError call
	private static void onErrorCall() {
		Observable<String> observable = Observable.just("Sample Observable with onNext and onError");
	//	Observable<String> observable = Observable.just("Sample Observabl".substring(0, 100));
		Action1<String> onNextCall = msgToDisplay ->System.out.println(msgToDisplay);
		Action1<Throwable> onErrorCall = Exception::new;
		observable.subscribe(onNextCall,onErrorCall);//cold obsevable--not invoke until subscribe
		
	}

	
	//observer method call
	public static void observerMethodCall() {
		  Observable<String> myObservable = Observable.just("Testing rxjava example");
		  Observer<String> myObserver = new Observer<String>() {
		    @Override 
		    public void onCompleted() { System.out.println("onCompleted called!"); }
		    @Override
		    public void onError(Throwable e) { System.out.println("onError called!"); }
		    @Override
		    public void onNext(String msg) { System.out.println("onNext called Message received: " + msg); }            
		  };
		  myObservable.subscribe(myObserver);
		}
}
