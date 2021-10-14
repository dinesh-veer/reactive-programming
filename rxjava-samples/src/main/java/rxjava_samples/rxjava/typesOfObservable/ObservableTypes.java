package rxjava_samples.rxjava.typesOfObservable;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class ObservableTypes {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("---------------------");
		System.out.println("Cold Observable ");
		System.out.println("---------------------");
		coldObservableExample();
		System.out.println("---------------------");
		System.out.println("Hot Observable ");
		System.out.println("---------------------");

		hotObservableExample();
		connectableObservable();
	}

	/**
	 * Creates Cold Observable using Observable.just() each and every onNext() gets
	 * their separate emission
	 * 
	 * @throws InterruptedException
	 */
	private static void coldObservableExample() throws InterruptedException {
		Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);

		observable.subscribe(item -> System.out.println("First Observer: " + item));
		System.out.println("-------------------");
		Thread.sleep(2000);
		observable.subscribe(item -> System.out.println("Second Observer: " + item));
	}

	private static void hotObservableExample() {
		// TODO Auto-generated method stub

	}

	/*
	 * To convert an observable to a connectable one, you can use the publish
	 * operator. Publishing the observable will make it hot and will not replay the
	 * items for observers after activation.
	 * 
	 */
	private static void connectableObservable() throws InterruptedException {

		Observable<Long> myObservable = Observable.interval(1, TimeUnit.SECONDS);
		ConnectableObservable<Long> connectableObservable = myObservable.publish();
		connectableObservable.subscribe(item -> System.out.println("First Observer : " + item));
		connectableObservable.connect();// running the code will not emit anything. That is because a connectable
										// observer requires the connect method to be invoked to begin emission
		 Thread.sleep(1000);//if code commented then call to subscribe simultensously
		 					// if uncommented then some values are missed by second subscriber
		connectableObservable.subscribe(item -> System.out.println("Second Observer : " + item));
		Thread.sleep(5000);

	}

}
