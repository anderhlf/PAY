package APAY.projeto.sistema.web.Service;

import APAY.projeto.sistema.web.model.DisciplinaModel;
import APAY.projeto.sistema.web.repository.DisciplinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public List<DisciplinaModel> listarTodas() {
        return disciplinaRepository.findAll();
    }

    public Optional<DisciplinaModel> buscarPorId(Long id) {
        return disciplinaRepository.findById(id);
    }

    public DisciplinaModel salvar(DisciplinaModel disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public DisciplinaModel update(Long disciplinaId, DisciplinaModel disciplina) {
        DisciplinaModel discipliExistente = disciplinaRepository.findById(disciplinaId)
                .orElseThrow(() -> new RuntimeException("Disciplina: não encontrada"));

        discipliExistente.setAlunos(disciplina.getAlunos());
        discipliExistente.setNome(disciplina.getNome());
        discipliExistente.setProfessor(disciplina.getProfessor());

        return disciplinaRepository.save(discipliExistente);
    }

    public void deleteById(Long id) {disciplinaRepository.deleteById(id);
    }
}
