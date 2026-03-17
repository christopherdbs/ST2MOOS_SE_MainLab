package altn72.TpFilRouge.controller;

import altn72.TpFilRouge.model.Programmer;
import altn72.TpFilRouge.model.ProgrammerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//@RestController
@Controller
public class ProgrammerController {

    private final ProgrammerService programmerService;

    public ProgrammerController(ProgrammerService programmerService) {
        this.programmerService = programmerService;
    }

    @GetMapping("/programmers")
    public String displayProgrammerInfo(Model model) {

        List<Programmer> programmers;
        programmers = programmerService.getProgrammers();

        programmers.forEach(System.out::println);
        model.addAttribute("programmers", programmers);
        return "listeProgrammeurs";
    }

    @GetMapping("/programmers/{id}")
    public Programmer getOne(@PathVariable("id") int id) {
        return programmerService.getProgrammer(id);
    }

    @GetMapping("/programmers/last")
    public String getLast(Model model){
        Programmer last = programmerService.getLastProgrammer();
        model.addAttribute("programmer", last);
        return "detailsProgrammeur";
    }

    @DeleteMapping("/programmers/{id}")
    public String delete(@PathVariable("id") int id) {
        boolean deleted = programmerService.deleteProgrammer(id);
        if (deleted) {
           // return ResponseEntity.ok(Map.of("message", "Deleted successfully", "status", "success"));
            return "redirect:/programmers";
        } else {
            return "Delete has failed";
        }
    }

    @GetMapping("/programmers/add")
    public String showAddForm(Model model) {
        model.addAttribute("programmer", new Programmer());

        return "nouveauProgrammeur";
    }

    @PostMapping("/programmers")
    public String create(@ModelAttribute("programmer") Programmer programmer) {
        programmerService.addProgrammer(programmer);
        return "redirect:/programmers";
    }


    @GetMapping("/programmers/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Programmer programmer = getOne(id);
        model.addAttribute("programmer", programmer);
        return "nouveauProgrammeur";
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
