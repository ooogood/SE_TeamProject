package pttsystem;

/**
 * Interface for pttsystem data saver
 */

public interface PTTSaver {
	public void startSaving();
	public void saveStaff( Staff st );
	public void saveRequirement( Requirement req );
	public void endSaving();
}
