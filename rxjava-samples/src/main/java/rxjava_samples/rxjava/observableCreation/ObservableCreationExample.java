package rxjava_samples.rxjava.observableCreation;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class ObservableCreationExample {

	public static void main(String[] args) {

		System.out.println("Observable using Just method\n");
		observableFromJust();
		System.out.println("-------------------------------\n");
		System.out.println("Observable using fromIterable");
		ObservableFromIterable();
		System.out.println("\n-----------------------------\n");
		System.out.println("Observable using Emmiter");
		observableFromCreateEmitter();
		System.out.println("\n-----------------------------\n");
		System.out.println("Observable using range");
		observableUsingRange();
		System.out.println("\n-----------------------------\n");
		System.out.println("Observable using inerval");
		observableUsingInterval();
		
	}
	
	// creating observable from just method
	private static void observableFromJust() {

		Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5, 6);
		observable.subscribe(System.out::println);
	}

	// creating ovbservable from iterable useful for collections
	private static void ObservableFromIterable() {
		Observable<String> observable = Observable.fromIterable(Arrays.asList("this", " is", " rxjava", " example"));
		observable.subscribe(System.out::print);
	}

	// creating obsevable from emitter
	private static void observableFromCreateEmitter() {

		Observable<Integer> observable = Observable.create(emit -> {
			emit.onNext(1);
			emit.onNext(2);
			emit.onNext(3);
			emit.onNext(4);
			emit.onNext(5);
			// emit.onNext(null);//onError called when error happens on null value
			emit.onComplete();
		});

		observable.subscribe(result -> System.out.println(result), error -> System.out.println(error.getMessage()),
				() -> System.out.println("Completed called"));

	}

	//Creating observable from range 
		private static void observableUsingRange() {
			Observable.range(10, 10)
			.blockingSubscribe(System.out::print);
		}
	
	// Blocking subscriber for printing values prints 0-9 each after 2 seconds
	private static void observableUsingInterval() {

		Observable.interval(2, TimeUnit.SECONDS).take(10).blockingSubscribe(System.out::print);
	}
}
