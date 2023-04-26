package esercizio;

class CalcolaRata extends Thread {

    private Buffer buffer;

    public CalcolaRata(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        buffer.getRate()[buffer.getK()] = buffer.getCapitaleMensile() + buffer.getInteresseMensile()[buffer.getK()];
    }
}
