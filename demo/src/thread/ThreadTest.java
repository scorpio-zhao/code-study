package thread;

public class ThreadTest {

	 
	public static void main(String[] args) {
		
		Data data = new Data();
		Add add = new Add(data);
		Dec dec = new Dec(data);
		for (int i = 0; i < 2; ++i) {
			new Thread(add, "线程A").start();
			new Thread(dec, "线程B").start();
		}
	}
}
class Data {
	
    private int j = 0;
    
    public synchronized void add(){  
 
        System.out.println(Thread.currentThread().getName() + "对j加1，当前j=" + (++j));  
    } 
    
    public synchronized void dec(){  
    	
    	System.out.println(Thread.currentThread().getName() + "对j减1，当前j=" + (--j));  
    }  
}  
class Add implements Runnable{ 
	
    private Data data;  
    
    Add(Data data){ 
    	
        this.data= data;  
    }  
       
    public void run() {  
  
        data.add();      
    }  
}  
class Dec implements Runnable{ 
	
	private Data data;  
    
    Dec(Data data){ 
    	
        this.data= data;  
    }  
       
    public void run() {  
  
        data.dec();      
    }  
}


