package altn72.TpFilRouge.controller;

import altn72.TpFilRouge.model.Programmer;
import altn72.TpFilRouge.model.ProgrammerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProgrammerService {
    @Autowired
    private ProgrammerRepository programmerRepository;

    @Transactional
    public List<Programmer> getProgrammers( ){
        return programmerRepository.findAll();
    }

    @Transactional
    public Programmer getProgrammer(int id) {
        return programmerRepository.findById(id)
                .orElseGet(() -> {
                    System.out.println("This programmer does not exist");
                    return null;
                });
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
    public Programmer updateProgrammer(int id, Programmer updatedData) {
        return programmerRepository.findById(id)
                .map(p -> {
                    if (updatedData.getName() != null) p.setName(updatedData.getName());
                    if (updatedData.getFirstName() != null) p.setFirstName(updatedData.getFirstName());
                    if (updatedData.getAddress() != null) p.setAddress(updatedData.getAddress());
                    if (updatedData.getFavoriteLanguage() != null) p.setFavoriteLanguage(updatedData.getFavoriteLanguage());
                    if (updatedData.getFavoriteBook() != null) p.setFavoriteBook(updatedData.getFavoriteBook());
                    if (updatedData.getSalary() != null) p.setSalary(updatedData.getSalary());

                    return programmerRepository.save(p);
                })
                .orElseGet(() -> {
                    System.out.println("Update failed: Programmer " + id + " not found.");
                    return null;
                });
    }

}
