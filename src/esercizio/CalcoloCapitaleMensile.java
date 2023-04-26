package esercizio;

class CalcoloCapitaleMensile extends Thread {

    private Buffer buffer;

    public CalcoloCapitaleMensile(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        buffer.setCapitaleMensile(buffer.getCapitale() / buffer.getN_mesi());
    }
}
