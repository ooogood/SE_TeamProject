package pttsystem;

/**
 * This class manage a list of Staffs and a list of Requirements.
 */

@SuppressWarnings("unchecked")
public class SRManagement {
	// Database
	protected Lox<Staff> lost;
	protected Lox<Requirement> lorq;

	public SRManagement() {
		ListBuilder lb = ListBuilder.inst();
		// build list of staff
		lb.reset();
		lb.setElement( Staff.class );
		lb.large();
		lost = (Lox<Staff>)lb.getResult();
		// build list of requirement
		lb.reset();
		lb.setElement( Requirement.class );
		lb.large();
		lorq = (Lox<Requirement>)lb.getResult();
	}
	// STORYCARD: Add a requirement and its skills and training
	public void addReq( String reqName, String[] skillNames, String[] trainingNames ) {
		Requirement req = lorq.get_or_create( reqName );
		// add all skills
		for( String s : skillNames ) {
			req.addSkill( s );
		}
		// add all training
		for( String t : trainingNames ) {
			req.addTraining( t );
		}
	}
	// add an existing requirement
	public void addReq( Requirement req ) {
		lorq.add( req );
	}
	// STORYCARD: Add a staff and its skills and training
	public void addStaff( String stName, String[] skillNames, String[] trainingNames ) {
		Staff st = lost.get_or_create( stName );
		// add all skills
		for( String s : skillNames ) {
			st.addSkill( s );
		}
		// add all training
		for( String t : trainingNames ) {
			st.addTraining( t );
		}
	}
	// add an existing staff
	public void addStaff( Staff st ) {
		lost.add( st );
	}
}
