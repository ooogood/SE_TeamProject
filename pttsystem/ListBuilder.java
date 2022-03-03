package pttsystem;

import java.util.Map;
import java.util.HashMap;

/**
 * This is a list object builder.
 * It uses singleton pattern and builder pattern.
 * It assigns ListElement factory to the lists.
 */

@SuppressWarnings({"rawtypes","unchecked"})
public class ListBuilder {
	// singleton components
	private static ListBuilder builder = new ListBuilder();
	private ListBuilder() {}
	public static ListBuilder inst() {
		return builder;
	}
	// Element factories.
	// We can also just call clazz.getDeclaredConstructor(String.class).newInstance(name) in Lox.
	// But that way we would have to handle a lot of exception.
	private static Map<Class<? extends ListElement>, ElemFactory<? extends ListElement>> factoryMap = new HashMap<>();
	static {
		factoryMap.put( Staff.class, new StaffFactory() );
		factoryMap.put( Skill.class, new SkillFactory() );
		factoryMap.put( Training.class, new TrainingFactory() );
		factoryMap.put( Requirement.class, new RequirementFactory() );
	}
	// builder components
	Lox result;
	public void reset() {
		result = null;
	}
	public <T extends ListElement> void setElement( Class<T> clazz ) {
		result = new Lox<T>( clazz );
		ElemFactory<? extends ListElement> fact = factoryMap.get( clazz );
		if( fact == null ) {
			throw new RuntimeException("Did not specify the element's factory!");
		}
		result.setFactory( fact );
	}
	// Just a demonstration that we can control the result properties in builder class.
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
