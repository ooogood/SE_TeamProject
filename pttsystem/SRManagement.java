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
	public Requirement addReq( String reqName, String[] skillNames, String[] trainingNames ) {
		Requirement req = lorq.get_or_create( reqName );
		// add all skills
		for( String s : skillNames ) {
			req.addSkill( s );
		}
		// add all training
		for( String t : trainingNames ) {
			req.addTraining( t );
		}
		return req;
	}
	// add an existing requirement
	public Requirement addReq( Requirement req ) {
		lorq.add( req );
		return req;
	}
	// STORYCARD: Add a staff and its skills and training
	public Staff addStaff( String stName, String[] skillNames, String[] trainingNames ) {
		Staff st = lost.get_or_create( stName );
		// add all skills
		for( String s : skillNames ) {
			st.addSkill( s );
		}
		// add all training
		for( String t : trainingNames ) {
			st.addTraining( t );
		}
		return st;
	}
	// add an existing staff
	public Staff addStaff( Staff st ) {
		lost.add( st );
		return st;
	}

	@Override
	public String toString(){
				// print staff header
		return "[ Staff ]:\n" + 
				String.format( "| %-16s |", "Staff Name" ) +
				String.format( " %-16s |", "Job Name" ) +
				String.format( " %-16s |","Skills" ) +
				String.format( " %-16s |\n","Pending Training" ) +
				String.format( "-----------------------------------------------------------------------------\n" ) +
				lost.print('\n') +
				// print requirement header
				"\n[ Requirement ]:\n" +
				String.format( "| %-16s |", "Requirement Name" ) +
				String.format( " %-16s |","Teacher Name" ) +
				String.format( " %-16s |","Skills Needed" ) +
				String.format( " %-16s |\n","Trainging Needed" ) +
				String.format( "-----------------------------------------------------------------------------\n" ) +
				lorq.print('\n');
	}
}
