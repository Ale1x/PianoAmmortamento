package esercizio;

class CalcoloInteresseMensile extends Thread {
    private Buffer buffer;

    public CalcoloInteresseMensile(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        double capResiduo = buffer.getCapitaleResiduo()[buffer.getK()];
        double i = buffer.getInteresse() / 12;
        buffer.getInteresseMensile()[buffer.getK()] = capResiduo * i;
    }
}

