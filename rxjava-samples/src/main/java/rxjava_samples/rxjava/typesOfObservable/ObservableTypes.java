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
		System.out.println("---------------------");
		System.out.println("Connectable Observable ");
		System.out.println("---------------------");
		connectableObservable();
		System.out.println("---------------------");
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

	/**
	 * Convert cold observable to Hot using pulish method
	 * @throws InterruptedException
	 */
	private static void hotObservableExample() throws InterruptedException {
		//A Cold Observale can be converted to a Hot Observable with a simple publish.
		ConnectableObservable<Long> hot = Observable.interval(500, TimeUnit.MILLISECONDS)
                									.publish(); // returns ConnectableObservable
		hot.connect(); // connect to subscribe
		hot.subscribe(item -> System.out.println("Subscriber 1-- " + item));
		Thread.sleep(1000);
		hot.subscribe(item2 -> System.out.println("Subscriber 2-- " + item2));
	}

	/**
	 * To convert an observable to a connectable one, you can use the publish
	 * operator. Publishing the observable will make it hot and will not replay the
	 * items for observers after activation.
	 * 
	 */
	private static void connectableObservable() throws InterruptedException {

		Observable<Long> myObservable = Observable.interval(1, TimeUnit.SECONDS);
		ConnectableObservable<Long> connectableObservable = myObservable.publish();//convert cold observable to hot
		connectableObservable.subscribe(item -> System.out.println("First Observer : " + item));
		connectableObservable.connect();// running the code will not emit anything. That is because a connectable
										// observer requires the connect method to be invoked to begin emission
		 Thread.sleep(1000);//if code commented then call to subscribe simultensously
		 					// if uncommented then some values are missed by second subscriber
		connectableObservable.subscribe(item -> System.out.println("Second Observer : " + item));
		Thread.sleep(5000);

	}

}
