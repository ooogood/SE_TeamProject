package pttsystem;

public class SkillFactory implements ElemFactory<Skill> {
	public Skill create( String name ) {
		return new Skill( name );
	}
}
 