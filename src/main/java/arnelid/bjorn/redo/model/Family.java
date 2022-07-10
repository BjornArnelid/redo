package arnelid.bjorn.redo.model;

import java.util.Collection;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Family {


	@Id
	public String id;
	  
	private final String name;
	private Collection<Member> members;

	public Family(String name, Collection<Member> members) {
		this.name = name;
		this.members = members;
	}

	public Collection<Member> getMembers() {
		return List.copyOf(members);
	}

	public String getName() {
		return this.name;
	}

	public void addMember(Member member) {
		members.add(member);
	}

}
