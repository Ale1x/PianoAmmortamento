package esercizio;

class CalcoloCapitaleResiduo extends Thread {

    private Buffer buffer;

    public CalcoloCapitaleResiduo(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        buffer.getCapitaleResiduo()[buffer.getK()] = buffer.getCapitaleMensile() * (buffer.getN_mesi() - buffer.getK());
    }
}
