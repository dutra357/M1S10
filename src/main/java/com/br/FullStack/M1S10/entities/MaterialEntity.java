package com.br.FullStack.M1S10.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "materiais")
public class MaterialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "agenda_id", nullable = false)
    private AgendaEntity agenda;


    @Column(nullable = false)
    private String caminho;

    @Column
    private String descricao;
}
