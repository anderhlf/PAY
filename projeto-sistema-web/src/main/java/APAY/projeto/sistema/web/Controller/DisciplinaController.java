package APAY.projeto.sistema.web.Controller;

import APAY.projeto.sistema.web.Service.DisciplinaService;
import APAY.projeto.sistema.web.model.DisciplinaModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @PostMapping("/create")
    public ResponseEntity<DisciplinaModel> create(@RequestBody DisciplinaModel disciplina) {
        return ResponseEntity.ok(disciplinaService.salvar(disciplina));
    }

    @GetMapping
    public ResponseEntity<List<DisciplinaModel>> findAll() {
        return ResponseEntity.ok(disciplinaService.listarTodas());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<DisciplinaModel>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(disciplinaService.buscarPorId(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DisciplinaModel> update(@PathVariable Long id, @RequestBody DisciplinaModel disciplina) {
        return ResponseEntity.ok(disciplinaService.update(id, disciplina));
    }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<Void> delete (@PathVariable Long id){
            disciplinaService.deleteById(id);
            return ResponseEntity.noContent().build();


        }
    }
