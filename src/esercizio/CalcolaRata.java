package esercizio;

class CalcoloRata extends Thread {
	
	private Buffer buffer;
	
    public CalcoloRata(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        double i = buffer.getInteresse() / 12;
        buffer.getRate()[buffer.getK()] = ((buffer.getCapitale() * i) / (1 - Math.pow(1 + i, -buffer.getN_mesi())));
    }
}