package pttsystem;
/**
 * This class is the main part-time teacher system.
 * It uses singleton pattern so that only one system will exist.
 * All lists are accessible for pttsystem packages for class clustering.
 */
@SuppressWarnings("unchecked")
public class PTTSystem {
	protected Lox<Staff> lost;
	protected Lox<Skill> losk;
	protected Lox<Training> lotr;
	protected Lox<Requirement> lorq;
	// singleton components
	private static PTTSystem ptt = new PTTSystem();
	private PTTSystem() {
		ListBuilder lb = ListBuilder.inst();
		// build list of staff
		lb.reset();
		lb.<Staff>setElement();
		lb.large();
		lost = (Lox<Staff>)lb.getResult();
		// build list of skill
		lb.reset();
		lb.<Skill>setElement();
		lb.medium();
		losk = (Lox<Skill>)lb.getResult();
		// build list of training
		lb.reset();
		lb.<Training>setElement();
		lb.medium();
		lotr = (Lox<Training>)lb.getResult();
		// build list of requirement
		lb.reset();
		lb.<Requirement>setElement();
		lb.large();
		lorq = (Lox<Requirement>)lb.getResult();
	}
	public static PTTSystem inst() {
		return ptt;
	}
	// STORYCARD: Add requirement and its skills and training
	public void addReq( String reqName, String[] skillNames, String[] trainingNames ) {
		Requirement req = new Requirement( reqName );
		// add all skills
		for( String s : skillNames ) {
			Skill sk = losk.get_or_create( new Skill( s ) );
			
		}
	}
}
