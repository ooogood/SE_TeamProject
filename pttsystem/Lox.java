package pttsystem;

import java.util.List;
import java.util.LinkedList;
/**
 * Generic list of somethings.
 * Invariant: Elements in this list should have a primary key "name(String)"
 */
class Lox<T extends ListElement>{
	public class Iterator {
		int it = 0;
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
	private ElemFactory<T> factory;
	private List<T> list = new LinkedList<>();
	private int cnt, max;
	Lox( Class<T> clz ) {
		cnt = 0;
	}
	void setFactory( ElemFactory<T> fact ) {
		factory = fact;
	}
	void setMax( int max ) {
		this.max = max;
	}
	int getMax() {
		return this.max;
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
		T ret = find( name );
		if( ret == null ) {
			ret = factory.create( name );
			add( ret );
		}
		return ret;
	}
	// T get( int idx ) {
	// 	return list.get( idx );
	// }
	void remove( T e ) {
		if( list.remove( e ) )
			cnt--;
	}
	T find( T e ) {
		return find( e.getName() );
	}
	T find( String name ) {
		for( T t : list ) {
			if( name.equals( t.getName() ) )
				return t;
		}
		return null;
	}
	Iterator getIter() {
		return new Iterator();
	}

	public String print( char delimiter ){
		String out = "";
		Iterator it = this.getIter();
		while( it.hasNext() ) {
			out += it.next().print() + delimiter;
		}
		return out;
	}
}
