package pttsystem;

/**
 * This is the interface of factory that produce a pair of loader and saver for PTTSystem.
 */
public interface PTTSLFactory {
	public PTTLoader getLoader();
	public PTTSaver getSaver();
}
