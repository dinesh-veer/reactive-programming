package rxjava_samples.rxjava.observableDefer;

import io.reactivex.Observable;

public class ObservableDeferExample {

	private static int startDefer=0, countDefer=3;
	
	public static void main(String[] args) {
		
		int start =0, count =3;
		System.out.println("----Using first Observable----");
		Observable<Integer> observable = Observable.range(start, count);//range(0,3)
		observable.subscribe(System.out::println);//prints 0 1 2
		count=5;		
		System.out.println("----Using Second Observable----");
		observable.subscribe(System.out::println);//prints 0 1 2
		System.out.println("-----------------------");
		
		System.out.println("----Using Defer method----");
		Observable<Integer> observabledefer = Observable.defer(()->{System.out.println("Start :"+startDefer +" Count :"+countDefer);
																return Observable.range(startDefer, countDefer);//range(0,3)
																});
		System.out.println("----Using first Observable----");
		observabledefer.subscribe(System.out::println);//prints 0 1 2
		System.out.println("----Using Second Observable----");
		startDefer=5;
		observabledefer.subscribe(System.out::println);//prints 5 6 7
		
		
		
	}
}
