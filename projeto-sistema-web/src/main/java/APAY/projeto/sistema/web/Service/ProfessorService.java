package APAY.projeto.sistema.web.Service;

import APAY.projeto.sistema.web.model.ProfessorModel;
import APAY.projeto.sistema.web.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;


    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }


    public List<ProfessorModel> listarTodos() {
        return professorRepository.findAll();
    }


    public Optional<ProfessorModel> buscarPorId(Long id) {
        return professorRepository.findById(id);
    }


    public ProfessorModel salvar(ProfessorModel professor) {
        return professorRepository.save(professor);
    }


    public ProfessorModel atualizar(Long professorId, ProfessorModel professor) {

        ProfessorModel professorExistente = professorRepository.findById(professorId)
                .orElseThrow(() -> new IllegalArgumentException("não encontrado"));

        professorExistente.setNome(professor.getNome());
        professorExistente.setEmail(professor.getEmail());
        professorExistente.setDisciplinas(professor.getDisciplinas());

        return professorRepository.save(professorExistente);
    }

    public void deleteById(Long id) {
        professorRepository.deleteById(id);
    }

}