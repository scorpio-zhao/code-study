package thread;

public class AlternatelyPrint {

	public static void main(String[] args) {
		new AlternatelyPrint().run1();
	}

	public void run1() {
		final Object o = new Object();// 资源 1
		final char[] X = "1234567".toCharArray();
		final char[] Y = "ABCDEFG".toCharArray();
		new Thread(() -> {
			synchronized (o) {
				for (char c : X) {
					try {
						o.wait();
						o.notify();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(c);
				}
			}
		} , "线程 1").start();
		new Thread(() -> {
			synchronized (o) {
				for (char c : Y) {
					try {
						o.notify();
						o.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(c);
				}
			}
		} , "线程 2").start();
	}
}
