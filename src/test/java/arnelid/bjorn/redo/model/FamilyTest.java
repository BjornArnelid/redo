package arnelid.bjorn.redo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class FamilyTest {
	@Test
	void testFamilyHaveName() {
		Family testFamily = new Family("theName", Collections.emptyList());
		assertEquals(testFamily.getName(), "theName");
	}
	
	@Test
	void testNoUsersInEmptyFamily() {
		Family testFamily = new Family("TheName", Collections.emptyList());
		assertTrue(testFamily.getMembers().isEmpty(), "Family members not empty for newly created family");
	}
	
	@Test
	void testFamyHaveMemebers() {
		Family testFamily = new Family("TheName", new ArrayList<>());
		testFamily.addMember(new Member("Test Member"));
		assertEquals(testFamily.getMembers().size(),1);
	}
	
	@Test
	void testFamilyConstructorWithMembers() {
		Family testFamily = new Family("TheName", List.of(new Member("Test Member")));
		assertEquals(testFamily.getMembers().size(),1);
	}
}
