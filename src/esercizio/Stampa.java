package esercizio;

import java.util.Formatter;

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

            Thread t1 = new CalcoloRata(buffer);
            Thread t2 = new CalcoloCapitaleMensile(buffer);
            Thread t3 = new CalcoloInteresseMensile(buffer);
            Thread t5 = new CalcoloCapitaleResiduo(buffer);

            t1.start();
            t1.join();
            t2.start();
            t3.start();
            t2.join();
            t3.join();
            t5.start();
            t5.join();
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
        
        for (int k = 0; k < buffer.getN_mesi(); k++) {
            formatter.format("rata n. %-3d %-2s € %-9.2f %-1s € %-9.2f %-3s € %-9.2f %-4s € %-9.2f %-8s € %-9.2f\n",
                    k + 1,
                    "",
                    buffer.getRate()[k],
                    "",
                    buffer.getInteresseMensile()[k],
                    "",
                    buffer.getCapitaleMensile()[k],
                    "",
                    buffer.getInteresseResiduo()[k],
                    "",
                    buffer.getCapitaleResiduo()[k]);
            
            tot += buffer.getRate()[k];
            tot_qta_interessi += buffer.getInteresseMensile()[k];
            tot_qta_cap += buffer.getCapitaleMensile()[k];
            
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
