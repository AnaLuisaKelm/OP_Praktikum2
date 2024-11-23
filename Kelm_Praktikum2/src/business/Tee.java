package business;

public class Tee {
	
	// Name des Tees
    private int artikelnummer;
    // Oeffnungszeiten
    private String bezeichnung;
    private String kategorie;
    // Strasse und Hausnummer des Tees
    private String mitKoffein;
    // EnthalteneKraeuter des Tees
    private String[] enthalteneKraeuter;

    public Tee(int artikelnummer, String bezeichnung, String kategorie,
    	String mitKoffein, String[] enthalteneKraeuter){
   		this.artikelnummer = artikelnummer;
  	    this.bezeichnung = bezeichnung;
   	    this.kategorie = kategorie;
   	    this.mitKoffein = mitKoffein;
   	    this.enthalteneKraeuter = enthalteneKraeuter;
    }
    
	public int getArtikelnummer() {
		return artikelnummer;
	}

	public void setArtikelnummer(int artikelnummer) {
		this.artikelnummer = artikelnummer;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String getKategorie() {
		return kategorie;
	}

	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}

	public String getMitKoffein() {
		return mitKoffein;
	}

	public void setMitKoffein(String mitKoffein) {
		this.mitKoffein = mitKoffein;
	}

	public String[] getEnthalteneKraeuter() {
		return enthalteneKraeuter;
	}

	public void setEnthalteneKraeuter(String[] enthalteneKraeuter) {
		this.enthalteneKraeuter = enthalteneKraeuter;
	}
	
	public String getEnthalteneKraeuterAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getEnthalteneKraeuter().length - 1; i++) {
			ergebnis = ergebnis + this.getEnthalteneKraeuter()[i] + trenner; 
		}
		return ergebnis	+ this.getEnthalteneKraeuter()[i];
	}
	
	public String gibTeeZurueck(char trenner){
  		return "" + this.getArtikelnummer() + trenner 
  			+ this.getBezeichnung() + trenner
  		    + this.getKategorie() + trenner
  		    + this.getMitKoffein() + trenner
  		    + this.getEnthalteneKraeuterAlsString(trenner) + "\n";
  	}
}

