package pttsystem;

@SuppressWarnings("unchecked")
public class Staff extends ListElement{
	private Lox<Skill> skills;
	private Lox<Training> trainings;
	private Requirement job;
	public Staff( String name ) {
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
	// basic get & set methods 
	public Lox<Skill> getSkills() {
		return skills;
	}
	public Lox<Training> getTrainings() {
		return trainings;
	}
	public Requirement getJob() {
		return this.job;
	}
	public void setJob( Requirement job ) {
		this.job = job;
	}
	public boolean hasJob() {
		return ( job != null );
	}
	// add skill
	public void addSkill( String skName ) {
		skills.get_or_create( skName );
	}
	// add training
	public void addTraining( String trName ) {
		trainings.get_or_create( trName );
	}
	// Check if the staff has this skill.
	public boolean hasSkill( Skill sk ) {
		skills.reset();
		while( skills.hasNext() ) {
			if( skills.next().equals( sk ) )
				return true;
		}
		return false;
	}
}
