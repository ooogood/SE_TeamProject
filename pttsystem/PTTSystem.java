package pttsystem;
/**
 * This class is the main part-time teacher system.
 * It extends SRManagemenet so that it has lists of Staffs and Requirements.
 * It uses singleton pattern so that only one system will exist.
 * To load or save this system, we use abstract factory to produce loader and saver,
 *  and use adapter pattern for switching to database in the future.
 */
public class PTTSystem extends SRManagement {
	// saver, loader service factory
	PTTSLFactory slfactory;
	// singleton components
	private static PTTSystem ptt = new PTTSystem();
	private PTTSystem() {
	}
	public static PTTSystem inst() {
		return ptt;
	}
	// STORYCARD: fill all requirements with existing staffs
	public void tryFillAllReq() {
		lorq.reset();
		while( lorq.hasNext() ) {
			Requirement req = lorq.next();
			if( req.hasFilled() ) continue;

			// try to find a staff to fill the requirement
			lost.reset();
			while( lost.hasNext() ) {
				Staff st = lost.next();
				if( st.hasJob() ) continue;
				if( req.isSuitable( st ) ) {
					// found a suitable staff
					req.setTeacher( st );
					break;
				}
			}
		}
	}
	// STORYCARD: Have a load, save mechanism to store perminent data.
	public void setSLFactory( PTTSLFactory slfactory ) {
		this.slfactory = slfactory;
	}
	// save data
	public void saveSystem() {
		PTTSaver sv = slfactory.getSaver();
		sv.startSaving();
		// saving all staffs
		lost.reset();
		while( lost.hasNext() ) {
			sv.saveStaff( lost.next() );
		}
		// saving all requirements
		lorq.reset();
		while( lorq.hasNext() ) {
			sv.saveRequirement( lorq.next() );
		}
		sv.endSaving();
	}
	// load data
	public void loadSystem() {
		PTTLoader ld = slfactory.getLoader();
		ld.startLoading();
		// loading all staffs
		while( ld.hasNextStaff() ) {
			addStaff( ld.loadStaff() );
		}
		// loading all requirements
		while( ld.hasNextRequirement() ) {
			addReq( ld.loadRequirement() );
		}
		ld.endLoading();
	}
}
