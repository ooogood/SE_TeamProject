package pttsystem;

/**
 * This class implements the abstract save, load factory.
 */
public class PTT2TxtKit implements PTTSLFactory { 
	private final String dataFile = "data.txt";
	public PTTLoader getLoader() {
		PTT2TxtLoader pttl = new PTT2TxtLoader();
		pttl.setDataFile( dataFile );
		return pttl;
	}
	public PTTSaver getSaver() {
		PTT2TxtSaver ptts = new PTT2TxtSaver();
		ptts.setDataFile( dataFile );
		return ptts;
	}
}
