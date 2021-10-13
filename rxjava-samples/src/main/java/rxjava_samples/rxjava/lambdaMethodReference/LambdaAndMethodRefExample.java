package rxjava_samples.rxjava.lambdaMethodReference;

public class LambdaAndMethodRefExample {
	
	public static void main(String[] args) {
		
		LambdaAndMethodRefExample example = new LambdaAndMethodRefExample();
	//older style to call methods without method ref
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
			
				callStaticMethod();
				example.callInstanceMethod();
			}
		});
		thread.run();
	
		System.out.println("---------------------");
		
		//call using lambda expression
		Thread thread1= new Thread(()->{
				callStaticMethod();
				new LambdaAndMethodRefExample().callInstanceMethod();
				});

		thread1.run();
		
		System.out.println("---------------------");
		
		//call using lambda expression & method refernce
		Thread thread2= new Thread(LambdaAndMethodRefExample::callStaticMethod);
		thread2.run();
		
	}
	
	
	
	protected static void callStaticMethod() {
		System.out.println("call from static method");
	}

	protected  void callInstanceMethod() {
		System.out.println("call from instance method");
	}
}
