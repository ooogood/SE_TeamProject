package pttsystem;

/**
 * Interface for pttsystem data saver
 */

public interface PTTLoader {
	public void startLoading();
	public Lox<Staff> getStaffs();
	public Lox<Requirement> getRequirements();
	public void endLoading();
}
