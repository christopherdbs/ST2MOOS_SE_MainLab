package altn72.TpFilRouge.controller;

import altn72.TpFilRouge.model.Programmer;
import altn72.TpFilRouge.model.ProgrammerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProgrammerService {

    private final ProgrammerRepository programmerRepository;

    public ProgrammerService(ProgrammerRepository programmerRepository) {
        this.programmerRepository = programmerRepository;
    }

    public List<Programmer> getProgrammers( ){
        return programmerRepository.findAll();
    }

    public Programmer getProgrammer(int id) {
        return programmerRepository.findById(id)
                .orElseGet(() -> {
                    System.out.println("This programmer does not exist");
                    return null;
                });
    }

    public Programmer getLastProgrammer() {
        List<Programmer> programmers = getProgrammers();
        return programmers.isEmpty() ? null : programmers.get(programmers.size() - 1);
    }

    @Transactional
    public boolean deleteProgrammer(int id) {
        if (programmerRepository.existsById(id)) {
            programmerRepository.deleteById(id);
            System.out.println("Programmer with ID " + id + " has been deleted.");
            return true;
        } else {
            System.out.println("Delete failed: Programmer with ID " + id + " does not exist.");
            return false;
        }
    }

    @Transactional
    public Programmer addProgrammer(Programmer programmer) {
        return programmerRepository.save(programmer);
    }

    @Transactional
    public Programmer updateProgrammer(int id, Programmer updatedProgrammer) {
         Programmer programmerToUpdate = programmerRepository.findById(id)
                .orElseGet(() -> {
                    System.out.println("Update failed: Programmer " + id + " not found.");
                    return null;
                });
        if (programmerToUpdate != null) {
            BeanUtils.copyProperties(updatedProgrammer, programmerToUpdate, "id");
            return programmerRepository.save(programmerToUpdate);
        }
        return null;
    }

}
