package arnelid.bjorn.redo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import arnelid.bjorn.redo.model.Family;
import arnelid.bjorn.redo.repository.FamilyRepository;


@RestController
public class FamilyController {
	@Autowired
	FamilyRepository familyRepository;
	
	
	@GetMapping("/{name}")
	Family getFamily(@PathVariable String name) {
		return familyRepository.findByName(name);
	}
	
	@PostMapping(path = "/Family", consumes = MediaType.APPLICATION_JSON_VALUE)
	void postFamily(@RequestBody Family newFamily) {
		familyRepository.save(newFamily);
	}
}
