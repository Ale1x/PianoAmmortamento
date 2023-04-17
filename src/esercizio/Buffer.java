package esercizio;

class Buffer {
    private double capitale;
    private double interesse;
    private int n_anni;
    private int n_mesi;
    protected int k = 0;

    public Buffer(double c, double i, int n) {
        this.capitale = c;
        this.interesse = i / 100;
        this.n_anni = n;
        this.n_mesi = (n * 12);
        
        
        rate = new double[n_mesi];
        capitaleMensile = new double[n_mesi];
        interesseMensile = new double[n_mesi];
        interesseResiduo = new double[n_mesi];
        capitaleResiduo = new double[n_mesi];
    }
    
    private double[] rate;
    private double[] capitaleMensile;
    private double[] interesseMensile;
    private double[] interesseResiduo;
    private double[] capitaleResiduo;

	public double getCapitale() {
		return capitale;
	}
	
	public void setCapitale(double capitale) {
		this.capitale = capitale;
	}
	
	public double getInteresse() {
		return interesse;
	}
	
	public void setInteresse(double interesse) {
		this.interesse = interesse;
	}
	
	public int getN_anni() {
		return n_anni;
	}
	
	public void setN_anni(int n_anni) {
		this.n_anni = n_anni;
	}
	
	public int getN_mesi() {
		return n_mesi;
	}
	
	public void setN_mesi(int n_mesi) {
		this.n_mesi = n_mesi;
	}
	
	public double[] getRate() {
		return rate;
	}
	
	public void setRate(double[] rate) {
		this.rate = rate;
	}
	
	public double[] getCapitaleMensile() {
		return capitaleMensile;
	}
	
	public void setCapitaleMensile(double[] capitaleMensile) {
		this.capitaleMensile = capitaleMensile;
	}
	
	public double[] getInteresseMensile() {
		return interesseMensile;
	}
	
	public void setInteresseMensile(double[] interesseMensile) {
		this.interesseMensile = interesseMensile;
	}
	
	public double[] getInteresseResiduo() {
		return interesseResiduo;
	}
	
	public void setInteresseResiduo(double[] interesseResiduo) {
		this.interesseResiduo = interesseResiduo;
	}
	
	public double[] getCapitaleResiduo() {
		return capitaleResiduo;
	}
	
	public void setCapitaleResiduo(double[] capitaleResiduo) {
		this.capitaleResiduo = capitaleResiduo;
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}
	

    
    
}