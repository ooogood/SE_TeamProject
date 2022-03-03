package pttsystem;

public class RequirementFactory implements ElemFactory<Requirement> {
	public Requirement create( String name ) {
		return new Requirement( name );
	}
}
