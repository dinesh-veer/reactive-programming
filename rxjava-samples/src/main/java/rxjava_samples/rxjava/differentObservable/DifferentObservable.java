package rxjava_samples.rxjava.differentObservable;

import io.reactivex.Single;

public class DifferentObservable {

	public static void main(String[] args) {
		singleObservable();
		mayBeObservable();
	}


	private static void singleObservable() {
		// it can only emit either a single successful value or an error (there is no
		// "onComplete" notification as there is for an Observable)
		Single<String> single = Single.just("Single");
		single.subscribe(System.out::println);
	}
	
	private static void mayBeObservable() {
		// TODO Auto-generated method stub
		
	}
}
