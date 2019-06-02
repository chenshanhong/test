package Thread;

public class Test {
	public static void main(String[] args) {
		Test1 p=new Test1();
		
		Thread t1=new Thread(new Test1(p));
		Thread t2=new Thread(new test2(p));
		t1.start();
		t2.start();
		
	}
}
//class print{
//	boolean flag=false;
//}
class Test1 implements Runnable{
	//print t;
	Test1 t;
	boolean flag=false;
	int i=1;
	public Test1(Test1 t) {
		this.t=t;
	}
	public Test1() {
	
	}
	@Override
	public  void run() {
		while(i<=100) {
			synchronized(t) {
				if(t.flag) {
					try{wait();}catch(Exception e) {}
				}else {
					System.out.println(Thread.currentThread().getName()+",,"+i);
					i+=2;
					t.flag=true;
					t.notify();
				}
			}
		}
	}

}
class test2 implements Runnable{
	//print t;
	Test1 t;
	int i=2;
	public test2(Test1 t) {
		this.t=t;
	}
	@Override
	public void run() {
		while(i<=100) {
			synchronized(t) {
				if(!t.flag) {
					try {wait();}catch(Exception e) {}
				}else {
					System.out.println(Thread.currentThread().getName()+",,"+i);
					i+=2;
					t.flag=false;
					t.notify();
				}
			}
		}
		
	}
	
}