package esercizio;


public class CalcoloPrestito {
    public static void main(String[] args) throws InterruptedException {
        
    	Thread t6 = new Stampa(new Buffer(80000, 2, 10));
    	
    	t6.start();
    	
    	try {
    		t6.join();
    	}catch(Exception e) {
    		
    	}
    }
}
