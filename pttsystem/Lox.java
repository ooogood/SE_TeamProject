package pttsystem;

import java.util.List;
import java.util.LinkedList;
/**
 * Generic list of somethings.
 */
class Lox<T>{
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
		if( cnt >= max ) {
			throw new RuntimeException("Element count exceed list limit!");
		}
		list.add( e );
		cnt++;
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
