package pttsystem;

public class PTT2TxtKit implements PTTSLFactory { 
	public PTTLoader getLoader() {
		return new PTT2TxtLoader();
	}
	public PTTSaver getSaver() {
		return new PTT2TxtSaver();
	}
}
