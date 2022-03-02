package pttsystem;

import java.util.List;
import java.util.LinkedList;
/**
 * Generic list of somethings.
 */
class Lox<T extends ListElement >{
	private List<T> list = new LinkedList<>();
	private int cnt, max, it;
	Lox() {
		cnt = 0;
		it = 0;
	}
	void setMax( int max ) {
		this.max = max;
	}
	void add( T e ) {
		// check limit
		if( cnt >= max ) {
			throw new RuntimeException("Element count exceed list limit!");
		}
		// check duplication
		if( find( e ) != null ) {
			throw new RuntimeException("Try to add a duplicated element!");
		}
		list.add( e );
		cnt++;
	}
	T get_or_create( String name ) {
		T ret = find( e );
		if( ret == null )
			add( e );
		return ret;
	}
	void remove( T e ) {
		if( list.remove( e ) )
			cnt--;
	}
	T find( T e ) {
		for( T t : list ) {
			if( e.equals( t ) )
				return t;
		}
		return null;
	}
	/**
	 * Iteration functions
	 */
	public void reset() {
		it = 0;
	}
	public T next() {
		return (it == cnt) ? null : list.get( it++ );
	}
	public boolean hasNext() {
		return it < cnt;
	}
}
