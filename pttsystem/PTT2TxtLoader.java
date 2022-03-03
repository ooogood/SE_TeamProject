package pttsystem;

/**
 * This is the loader in PTT2Txt kit.
 * It extends SRManagement so that it can read txt at once and use itself as a buffer.
 */

public class PTT2TxtLoader extends SRManagement implements PTTLoader {

	public void startLoading() {
		// TODO
		// read txt file and store all staffs and requirements in this method
		// store them in lost and lorq in SRManagement!
	}
	public Staff loadStaff() {
		// TODO
		return null;
	}
	public boolean hasNextStaff() {
		// TODO
		return false;
	}
	public Requirement loadRequirement() {
		// TODO
		return null;
	}
	public boolean hasNextRequirement() {
		// TODO
		return false;
	}
	public void endLoading() {
		// TODO
	}
}
