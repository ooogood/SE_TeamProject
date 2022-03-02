package pttsystem;

@SuppressWarnings("unchecked")
public class Requirement {
	private String name;
	private Lox<Skill> skills;
	private Lox<Training> trainings;
	private Staff teacher;
	public Requirement( String name ) {
		ListBuilder lb = ListBuilder.inst();
		// create list of skills
		lb.reset();
		lb.<Skill>setElement();
		lb.small();
		skills = lb.getResult();
		// create list of training
		lb.reset();
		lb.<Training>setElement();
		lb.small();
		trainings = lb.getResult();
	}
	// add skill
	public void addSkill( Skill sk ) {
		PTTSystem ptt = PTTSystem.inst();
		// save the skill instance inside the pttsystem list
		Skill s = ptt.losk.get_or_create( sk );
		skills.add( s );
	}
	// add training
	public void addTraining( Training tr ) {
		PTTSystem ptt = PTTSystem.inst();
		// save the skill instance inside the pttsystem list
		Training t = ptt.lotr.get_or_create( tr );
		trainings.add( t );
	}
	// set staff to this requirement
	// STORYCARD: Assign staff into a requirement
	public void setStaff( Staff st ) {
		// check if the staff has already had a job
		if( st.hasJob() ) {
			throw new RuntimeException( "Try to give the job to a staff that has already had a job!" );
		}

		teacher = st;
		st.setHasJob( true );
		// put all required training of this requirement into the staff
		trainings.reset();
		while( trainings.hasNext() ) {
			st.addTraining( trainings.next() );
		}
	}
	// check if a staff is suitable for the requirement 
	// STORYCARD: Check if a staff is suitable for the requirement
	public boolean isSuitable( Staff st ) {
		skills.reset();
		while( skills.hasNext() ) {
			if( !st.hasSkill( skills.next() ) )
				return false;
		}
		return true;
	}
	@Override
	public boolean equals( Object st ) {
		if( !( st instanceof Requirement ) ) return false;
		if( this.name.equals( ((Requirement)st).name ) )
			return true;
		return false;
	}
}
