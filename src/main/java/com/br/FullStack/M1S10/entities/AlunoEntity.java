package com.br.FullStack.M1S10.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "alunos")
public class AlunoEntity {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "tutor_id", nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false, length = 10)
    private String status;

    @Column(nullable = false, length = 200)
    private String tema;

    private String descricao;
}
