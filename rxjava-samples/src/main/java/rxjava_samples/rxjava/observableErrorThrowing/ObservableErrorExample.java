package rxjava_samples.rxjava.observableErrorThrowing;

import io.reactivex.Observable;

public class ObservableErrorExample {

	public static void main(String[] args) {
	
		System.out.println("----------------------");
		System.out.println("Observable with error return same exception instance");
		observableSameExceptioninstanceExample();
		System.out.println("----------------------");
		System.out.println("----------------------");
		System.out.println("Observable with error returns new exception instance using callable instance");
		observableNewExceptioninstanceExample();
		System.out.println("----------------------");

	}
	
	/**
	 *  observers gets the same exception instance 
	 */
	private static void observableSameExceptioninstanceExample() {
	
		Observable observable = Observable.error(new Exception("Manual exception is thrown"));
		
		observable.subscribe(System.out::println,exception->{System.out.println("first subscription hashcode value  =" +exception.hashCode());});
		observable.subscribe(System.out::println,exception->{System.out.println("second subscription hashcode value  =" +exception.hashCode());});
 		
	}

	private static void observableNewExceptioninstanceExample() {
		//callable functional interface creates new object everytime
		Observable observable = Observable.error(()-> {	System.out.println("new instance creating");
														return new Exception("Manual exception is thrown");});
		
		observable.subscribe(System.out::println,exception->{System.out.println("first subscription hashcode value  =" +exception.hashCode());});
		observable.subscribe(System.out::println,exception->{System.out.println("second subscription hashcode value  =" +exception.hashCode());});
 
	}

}
