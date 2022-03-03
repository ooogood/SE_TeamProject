package pttsystem;

/**
 * Interface for pttsystem data saver
 */

public interface PTTLoader {
	public void startLoading();
	public Staff loadStaff();
	public boolean hasNextStaff();
	public Requirement loadRequirement();
	public boolean hasNextRequirement();
	public void endLoading();
}
