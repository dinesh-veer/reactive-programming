package rxjava_samples.rxjava.observableFromCallable;

import io.reactivex.Observable;

public class ObservableFromCallableExample {

	public static void main(String[] args) {
	
		//Delegates the item generation 
		 // So that it  throw exception
	//	 Observable<Integer> observable1 = Observable.just(1/0);
		
		//Redirects the item generation just before it reaches to the onNext()
		 // So that it doesn't throw exception
		 // And instead you can get a callback on your onError() lazy loaded
		   Observable<Integer> observable1 = Observable.fromCallable(() -> {
	            System.out.println("Calling Observable");
	            return 1/0;
	        });
	        observable1.subscribe(System.out::println,
	                error -> System.out.println(" Exception :" + error.getMessage()));
	    
		
	}

}
