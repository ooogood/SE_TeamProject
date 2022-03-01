package pttsystem;
/**
 * This class is the main part-time teacher system.
 * It uses singleton pattern so that only one system will exist.
 */
@SuppressWarnings("unchecked")
public class PTTSystem {
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
	public PTTSystem inst() {
		return ptt;
	}
	private Lox<Staff> lost;
	private Lox<Skill> losk;
	private Lox<Training> lotr;
	private Lox<Requirement> lorq;
}
