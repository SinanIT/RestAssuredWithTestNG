package dataShare;

public class ThreadLocalExample {

	public static void main(String[] args) {
		
		ThreadLocal counter1 = new ThreadLocal<>();
		counter1.set("Sinan");
		
		String nameString = (String) counter1.get();
		System.out.println(nameString);
		counter1.remove();
		System.out.println((String)counter1.get());
		
		ThreadLocal counter2 = ThreadLocal.withInitial(() -> "Degerli");
		System.out.println((String) counter2.get());
		
		ThreadLocal<String> counter3 = new ThreadLocal<>();
		counter3.set("Zehra");
		System.out.println(counter3.get());

	}

}
