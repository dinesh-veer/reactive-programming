package com.dinesh.simpleObervable;
import rx.Observable;

//import rx.Observable;

public class ObservableSample {

	public static void main(String[] args) {
	Observable.just("Testing java reactive programming")
				.subscribe(System.out::println);

	//extended version of above implementation ---need to uncomment rxjs2 dependancy
	//Observable.just(1,2,4,5,7,8)
	//		.subscribe(new Consumer<Integer>() {
	//			@Override
	//			public void accept(Integer t) throws Exception {
	//			System.out.println(t);	
	//			}
	//		});
	}
}
