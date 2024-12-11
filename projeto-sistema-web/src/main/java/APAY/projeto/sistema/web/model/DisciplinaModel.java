package APAY.projeto.sistema.web.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name="Disciplina")
@Data
public class DisciplinaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @ManyToOne
    @JoinColumn(name="professor_id")
    private ProfessorModel professor;

    @Column(nullable = false, length = 100)
    public String cargo_horaria;

    @ManyToMany(mappedBy = "disciplinas")
    private Set<AlunoModel> alunos;

}