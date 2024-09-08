package in.lalit;

import java.util.Scanner;

public class App {

	public void sayHello(String name) {
		System.out.println("DemoApp.sayHello()");
		for (int i = 1; i <= 10; i++)
		System.out.println(name + " "); 
		System.out.println("End of sayHello()");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the message:: ");
		String msg = scanner.next();
		displayMsg(msg);
		}
		public void displayMsg(String msg) {
		System.out.println("DemoApp.displayMsg() :: "+msg);
		System.out.println("DemoApp.displayMsg() :: "+msg);
		printNumber(10);
		}
		public void printNumber(int n) {
		System.out.println("DemoApp.printNumber()");
		for(int i = 1;i<=n;i++)
		System.out.println(i);
		System.out.println("end");
		}
		public int add(int a, int b) {
		System.out.println("DemoApp.add()");
		return a + b;
}				
		public int sub(int a, int b) {
		System.out.println("DemoApp.sub()");
		return a - b;
		}
	
  public static void main(String[] args) {
	  App app = new App();
	  app.sayHello("sachin");
	  app.add(10, 20);
	  app.add(30, 20);
  	}
}
