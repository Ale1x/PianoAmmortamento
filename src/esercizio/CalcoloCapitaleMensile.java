package esercizio;

class CalcoloCapitaleMensile extends Thread {
	
	private Buffer buffer;
	
    public CalcoloCapitaleMensile(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        double i = buffer.getInteresse() / 12;
        buffer.getCapitaleMensile()[buffer.getK()] = buffer.getRate()[buffer.getK()] * Math.pow(1 + i, -(buffer.getN_mesi() - buffer.getK() + 1));
    }
}