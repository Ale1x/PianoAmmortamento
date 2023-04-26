package esercizio;

import java.util.Formatter;
import java.text.NumberFormat;

public class Stampa extends Thread{

    private Buffer buffer;

    public Stampa(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run(){

        try {
            stampa();
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public void stampa() throws Exception {

        for (int k = 0; k < buffer.getN_mesi(); k++) {
            buffer.setK(k);

            Thread t1 = new CalcolaRata(buffer);
            Thread t3 = new CalcoloInteresseMensile(buffer);
            Thread t5 = new CalcoloCapitaleResiduo(buffer);

            t5.start();
            t5.join();
            t3.start();
            t3.join();
            t1.start();
            t1.join();

            buffer.setCapitale(buffer.getCapitale() - buffer.getCapitaleMensile());
        }


        for (int k = 0; k < buffer.getN_mesi(); k++) {
            buffer.setK(k);

            Thread t4 = new CalcoloInteresseResiduo(buffer);
            t4.start();
            t4.join();
        }

        Formatter formatter = new Formatter();

        formatter.format("%-15s %-10s %-16s %-16s %-20s %-18s\n", "Mese", "Rata", "Quota Interessi", "Quota Capitale", "Interessi Residui", "Capitale Residuo");
        
        double tot = 0;
        double tot_qta_interessi = 0;
        double tot_qta_cap = 0;

        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);

        for (int k = 0; k < buffer.getN_mesi(); k++) {
            formatter.format("rata n. %-3d %-2s € %-11s %-1s € %-11s %-3s € %-11s %-4s € %-11s %-8s € %-11s\n",
                    k + 1,
                    "",
                    nf.format(buffer.getRate()[k]),
                    "",
                    nf.format(buffer.getInteresseMensile()[k]),
                    "",
                    nf.format(buffer.getCapitaleMensile()),
                    "",
                    nf.format(buffer.getInteresseResiduo()[k]),
                    "",
                    nf.format(k == (buffer.getN_mesi() - 1) ? buffer.getCapitaleResiduo()[k] : buffer.getCapitaleResiduo()[k + 1]));

            tot += buffer.getRate()[k];
            tot_qta_interessi += buffer.getInteresseMensile()[k];
            tot_qta_cap += buffer.getCapitaleMensile();
            
            int anni = k / 12; 
            if ((k+1) % 12 == 0) {
                formatter.format("Tot %-1d° anno: %-1s € %-9.2f %-1s € %-9.2f %-3s € %-9.2f\n\n",
                        (anni+1),
                        "",
                        tot,
                        "",
                        tot_qta_interessi,
                        "",
                        tot_qta_cap
                );
            tot = 0;
            tot_qta_interessi = 0;
            tot_qta_cap = 0;
            }
        }

        System.out.println(formatter);
        formatter.close();
    }

}
