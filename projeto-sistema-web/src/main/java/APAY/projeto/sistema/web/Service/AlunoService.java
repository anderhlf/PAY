package APAY.projeto.sistema.web.Service;

import APAY.projeto.sistema.web.model.AlunoModel;
import APAY.projeto.sistema.web.model.DisciplinaModel;
import APAY.projeto.sistema.web.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<AlunoModel> listarTodos() {
        return alunoRepository.findAll();
    }

    public Optional<AlunoModel> buscarPorId(Long id) {
        return alunoRepository.findById(id);
    }

    public AlunoModel salvar(AlunoModel aluno) {
        return alunoRepository.save(aluno);
    }

    public AlunoModel update(Long alunoId, AlunoModel aluno) {
        AlunoModel alunoExistente = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new IllegalArgumentException("Aluno: não encontrada"));

        alunoExistente.setDisciplinas(aluno.getDisciplinas());
        alunoExistente.setNome(aluno.getNome());
        alunoExistente.setEmail(aluno.getEmail());

        return alunoRepository.save(alunoExistente);
    }

    public void deleteById(Long id) {
        alunoRepository.deleteById(id);
    }
}

