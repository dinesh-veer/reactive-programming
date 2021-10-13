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
		observableFromCreateEmitter();
	}



	private static void observableFromJust() {
	
		Observable<Integer> observable = Observable.just(1,2,3,4,5,6);
		observable.subscribe(System.out::println);
	}

	private static void ObservableFromIterable() {
		Observable<String> observable = Observable.fromIterable(Arrays.asList("this" ," is", " rxjava"," example"));
		observable.subscribe(System.out::print);
	}

	private static void observableFromCreateEmitter() {
	
		Observable<Integer> observable = Observable.create(emit->{
			emit.onNext(1);
			emit.onNext(2);
			emit.onNext(3);
			emit.onNext(4);
			emit.onNext(5);
			//emit.onNext(null);//onError called when error happens on null value
			emit.onComplete();
		});
		
		observable.subscribe(result->System.out.println(result),
				error->System.out.println(error.getMessage()),
				()->System.out.println("Completed called"));
		
	}

}
