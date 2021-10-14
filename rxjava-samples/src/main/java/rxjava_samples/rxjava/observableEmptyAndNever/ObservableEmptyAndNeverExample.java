package rxjava_samples.rxjava.observableEmptyAndNever;

import io.reactivex.Observable;

public class ObservableEmptyAndNeverExample {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("----------------------");
		System.out.println("Observable with Empty");
		observablewithEmptyExample();
		System.out.println("----------------------");
		System.out.println("----------------------");
		System.out.println("Observable with Never");
		observableWithNeverExample();
		System.out.println("----------------------");
	}

	/**
	 * Doesn't emit any item onNext() & only completes immediatly
	 * to get callback on onComplete method
	 */
	private static void observablewithEmptyExample() {
		Observable<Object> observable = Observable.empty();
		observable.subscribe(System.out::println,System.out::println,()->System.out.println("Completed callback method called"));
	}
	
	/**
	 * Doesnt emit any item and never completes 
	 * waiting until thread is running
	 * @throws InterruptedException 
	 */
	private static void observableWithNeverExample() throws InterruptedException {
		Observable<Object> observable = Observable.never();
		observable.subscribe(System.out::println,System.out::println,()->System.out.println("Completed callback method called"));
		Thread.sleep(4000);
	}
}
