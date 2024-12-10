package APAY.projeto.sistema.web.Controller;

import APAY.projeto.sistema.web.Service.ProfessorService;
import APAY.projeto.sistema.web.model.ProfessorModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping("/create")
    public ResponseEntity<ProfessorModel> create(@RequestBody ProfessorModel professor) {
        return ResponseEntity.ok(professorService.salvar(professor));
    }

    @GetMapping
    public ResponseEntity<List<ProfessorModel>> findAll() {
        return ResponseEntity.ok(professorService.listarTodos());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<ProfessorModel>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(professorService.buscarPorId(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProfessorModel> update(@PathVariable Long id, @RequestBody ProfessorModel professor) {
        return ResponseEntity.ok(professorService.update(professor,id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        professorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
