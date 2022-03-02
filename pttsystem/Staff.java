package pttsystem;

@SuppressWarnings("unchecked")
public class Staff {
	private String name;
	private Lox<Skill> skills;
	private Lox<Training> trainings;
	private boolean hasJob = false;
	public Staff( String name ) {
		this( name, false );
	}
	public Staff( String name, boolean hasJob ) {
		this.name = name;
		this.hasJob = hasJob;

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
	// get & set hasJob
	public boolean hasJob() {
		return hasJob;
	}
	public void setHasJob( boolean h ) {
		this.hasJob = h;
	}
	// check if the staff has this skill
	public boolean hasSkill( Skill sk ) {
		skills.reset();
		while( skills.hasNext() ) {
			if( skills.next().equals( sk ) )
				return true;
		}
		return false;
	}
	@Override
	public boolean equals( Object st ) {
		if( !( st instanceof Staff ) ) return false;
		if( this.name.equals( ((Staff)st).name ) )
			return true;
		return false;
	}
}
