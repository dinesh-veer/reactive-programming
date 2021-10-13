package rxjava_samples.rxjava.observableCreation;

import java.util.Arrays;

import io.reactivex.Observable;

public class ObservableCreationExample {

	public static void main(String[] args) {
	
		System.out.println("Observable using Just method\n");
		observableFromJust();
		System.out.println("-------------------------------\n");
		System.out.println("Observable using fromIterable");
		ObservableFromIterable();
		System.out.println("\n-----------------------------");
		
	}

	
	private static void observableFromJust() {
	
		Observable<Integer> observable = Observable.just(1,2,3,4,5,6);
		observable.subscribe(System.out::println);
	}

	private static void ObservableFromIterable() {
		Observable<String> observable = Observable.fromIterable(Arrays.asList("this" ," is", " rxjava"," example"));
		observable.subscribe(System.out::print);
	}


}
