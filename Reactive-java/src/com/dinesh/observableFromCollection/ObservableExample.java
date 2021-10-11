package com.dinesh.observableFromCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

import rx.Observable;

public class ObservableExample {

	public static void main(String[] args) {
		listAsObservable();
		System.out.println("\n-------------------------\n");
		callableAsObservable();
		System.out.println("\n-------------------------\n");
		futureAsObservable();
	}

	//observable from list
	private static void listAsObservable() {
		List<String> list = new ArrayList<>();
		list.add("java");
		list.add(" reactive");
		list.add(" programming\n");
		
		Observable.from(list)
					.subscribe(System.out::print);
		
		System.out.println("------------\n");
		
		List<Integer> listInteger = IntStream.range(1, 10)
											.mapToObj(Integer::new)
											.toList();
		
		Observable.from(listInteger)
					.subscribe(System.out::print);
	}
	

	//observable from callable
	private static void callableAsObservable() {
	
		Callable<String> callable =()->"sample from callable ";
		Observable.fromCallable(callable)
					.subscribe(System.out::print);
	}
	
	//Observable from Future
		private static void futureAsObservable() {
			CompletableFuture<String> future = CompletableFuture.supplyAsync(()->"from future as obserable");
			Observable.from(future).subscribe(System.out::println);
		}

		
}
