package rxjava_samples.rxjava.observerMethodExamples;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ObserverMethodExample {

	public static void main(String[] args) {
	
		observerMethodExample();
	}

	//calling different methods from Observer
	private static void observerMethodExample() {
	
		Observable<Integer> observable = Observable.just(1, 2, 4, 6, 8, 9, 10);

		System.out.println("----------------------------");
		
		Observer<Integer> observer = new Observer<Integer>() {

			@Override
			public void onSubscribe(Disposable d) {
			
				System.out.println("Calling onSubscribe method -"+d.toString());
			}

			@Override
			public void onNext(Integer receivedValue) {

				System.out.println("received value by onNext method --"+ receivedValue);
			}

			@Override
			public void onError(Throwable e) {

				System.out.println("onError method called exception happened- "+e.getMessage());
			}

			@Override
			public void onComplete() {
				System.out.println("onComplete method called");
			}
		};
		
		observable.subscribe(observer);
		

		System.out.println("----------------------------");
		
	}

}
