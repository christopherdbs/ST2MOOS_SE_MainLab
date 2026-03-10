package altn72.TpFilRouge.controller;

import altn72.TpFilRouge.model.Programmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ProgrammerController {

    @Autowired
    ProgrammerService programmerService;

    @GetMapping("/programmers")
    public List<Programmer> displayProgrammerInfo() {

        List<Programmer> programmers;
        programmers = programmerService.getProgrammers();

        programmers.forEach(System.out::println);

        return programmers;
    }

    @GetMapping("/programmers/{id}")
    public Programmer getOne(@PathVariable("id") int id) {
        return programmerService.getProgrammer(id);
    }

    @DeleteMapping("/programmers/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable("id") int id) {
        boolean deleted = programmerService.deleteProgrammer(id);
        if (deleted) {
            return ResponseEntity.ok(Map.of("message", "Deleted successfully", "status", "success"));
        } else {
            return ResponseEntity.status(404).body(Map.of("message", "Programmer not found", "status", "error"));
        }
    }

    @PostMapping("/programmers")
    public Programmer create(@RequestBody Programmer programmer) {
        Programmer newProgrammer = programmerService.addProgrammer(programmer);
        return newProgrammer;
    }

    @PutMapping("/programmers/{id}")
    public Programmer update(@PathVariable("id") int id, @RequestBody Programmer programmer) {
        Programmer updatedProgrammer = programmerService.updateProgrammer(id, programmer);
        return updatedProgrammer;
    }


    /* LAB 1
    * @GetMapping("/programmers")
    public List<Programmer> displayProgrammerInfo() {

        List<Programmer> programmers = new ArrayList<>();

        Programmer p1 = new Programmer(1,"John", "Doe", "123 Main Street", 60000, "Clean Code", "Java");
        Programmer p2 = new Programmer(2, "Jane", "Smith","456 Oak Street", 65000, "The Pragmatic Programmer", "Python");
        Programmer p3 = new Programmer(3, "Charlie", "Brown","789 Pine Street", 55000, "You Don't Know JS", "JavaScript");

        programmers.add(p1);
        programmers.add(p2);
        programmers.add(p3);

        programmers.forEach(System.out::println);

        return programmers;
    }*/
}
