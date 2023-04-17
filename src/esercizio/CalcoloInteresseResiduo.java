package esercizio;

class CalcoloInteresseResiduo extends Thread {
	
	private Buffer buffer;
	
    public CalcoloInteresseResiduo(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = buffer.getK() + 1; i < buffer.getN_mesi(); i++) {
            buffer.getInteresseResiduo()[buffer.getK()] += buffer.getInteresseMensile()[i];
        }
    }
}