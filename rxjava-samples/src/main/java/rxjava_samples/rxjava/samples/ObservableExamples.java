package rxjava_samples.rxjava.samples;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class ObservableExamples {

    public static void main(String[] args) {
    	//Normal way to create observable & subscriber
		 Observable.just("Another way to create sample")
		 		.subscribe(System.out::println);
		 
		 //in detail way how lambda expression is converted
		 Observable.just("Detailed way to create Observable and subscribe it")
		 			.subscribe(new Consumer<String>() {

						@Override
						public void accept(String string) throws Exception {
							System.out.println(" THis string is passed to consumer---->>"+string);
						}
					});
				
	}
}
