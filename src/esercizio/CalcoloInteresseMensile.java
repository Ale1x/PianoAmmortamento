package esercizio;

class CalcoloInteresseMensile extends Thread {
	
	private Buffer buffer;
	
    public CalcoloInteresseMensile(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        buffer.getInteresseMensile()[buffer.getK()] = buffer.getRate()[buffer.getK()] - buffer.getCapitaleMensile()[buffer.getK()];
    }
}