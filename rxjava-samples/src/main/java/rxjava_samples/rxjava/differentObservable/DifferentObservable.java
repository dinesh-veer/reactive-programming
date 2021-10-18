package rxjava_samples.rxjava.differentObservable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

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
		
		//in this way it may or maynot emit value but it can subscribe and 
		//complete it
		Maybe<String> stringObservable = Maybe.empty();
		//Maybe<String> stringObservable = Maybe.just("test");
		stringObservable.subscribe(new MaybeObserver() {

			@Override
			public void onSubscribe(Disposable d) {
				System.out.println("onSubscribe "+d);
			}

			@Override
			public void onSuccess(Object t) {
				System.out.println("onSuccess "+t);
			}

			@Override
			public void onError(Throwable e) {
				System.out.println("OnError "+e);
				
			}

			@Override
			public void onComplete() {
				System.out.println("onComplete ");
			}
		});
	}
}
