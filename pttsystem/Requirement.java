package pttsystem;

@SuppressWarnings("unchecked")
public class Requirement extends ListElement{
	private Staff teacher;
	private Lox<Skill> skills;
	private Lox<Training> trainings;
	public Requirement( String name ) {
		super( name );
		ListBuilder lb = ListBuilder.inst();

		// create list of skills
		lb.reset();
		lb.setElement( Skill.class );
		lb.small();
		skills = lb.getResult();
		// create list of training
		lb.reset();
		lb.setElement( Training.class );
		lb.small();
		trainings = lb.getResult();
	}
	// basic get and set
	public Lox<Skill> getSkills() {
		return skills;
	}
	public Lox<Training> getTrainings() {
		return trainings;
	}
	public Staff getTeacher() {
		return teacher;
	}
	public boolean hasFilled() {
		return ( teacher != null );
	}
	// add skill
	public void addSkill( String skName ) {
		skills.get_or_create( skName );
	}
	// add training
	public void addTraining( String trName ) {
		trainings.get_or_create( trName );
	}
	// set staff to this requirement
	// STORYCARD: Assign staff into a requirement
	public void setTeacher( Staff st ) {
		// check if the staff has already had a job
		if( st.hasJob() ) {
			throw new RuntimeException( "Try to give the job to a staff that has already had a job!" );
		}

		teacher = st;
		st.setJob( this );
		// put all required training of this requirement into the staff
		Lox<Training>.Iterator it = trainings.getIter();
		while( it.hasNext() ) {
			st.addTraining( it.next().getName() );
		}
	}
	// check if a staff is suitable for the requirement 
	// STORYCARD: Check if a staff is suitable for the requirement
	public boolean isSuitable( Staff st ) {
		Lox<Skill>.Iterator it = skills.getIter();
		while( it.hasNext() ) {
			if( !st.hasSkill( it.next() ) )
				return false;
		}
		return true;
	}
	//TODO: @override toString
	public String toString(){

		String t = teacher==null? "null" : teacher.getName(); 
		String out = String.format("| %-16s |", this.name )
		+ String.format(" %-16s |", t )
		+ String.format(" %-16s |", skills )
		+ String.format(" %-16s |\n", trainings );

		return out;
	}
}
