package pttsystem;
/**
 * Generic facotry interface that can produce ListElement
 */
public interface ElemFactory<T extends ListElement> {
	public T create( String name );
}
