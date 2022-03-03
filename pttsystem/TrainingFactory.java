package pttsystem;

public class TrainingFactory implements ElemFactory<Training> {
	public Training create( String name ) {
		return new Training( name );
	}
}
 