package pttsystem;

/**
 * This is a list object builder.
 * It uses singleton pattern and builder pattern.
 */

@SuppressWarnings("rawtypes")
public class ListBuilder {
	// singleton components
	private static ListBuilder builder = new ListBuilder();
	private ListBuilder() {}
	public static ListBuilder inst() {
		return builder;
	}
	// builder components
	Lox result;
	public void reset() {
		result = null;
	}
	public <T> void setElement() {
		result = new Lox<T>();
	}
	// just a demonstration that we can control the result properties in builder class.
	public void small() {
		result.setMax( 10 );
	}
	public void medium() {
		result.setMax( 50 );
	}
	public void large() {
		result.setMax( 100 );
	}
	public Lox getResult() {
		return result;
	}
}
