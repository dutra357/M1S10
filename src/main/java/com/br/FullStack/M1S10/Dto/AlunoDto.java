package com.br.FullStack.M1S10.Dto;

import com.br.FullStack.M1S10.entities.AlunoEntity;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class AlunoDto {
    private String name;
    private Long id;


    public AlunoDto(Long id, String name) {
        this.name = name;
        this.id = id;
    }

    public AlunoDto() {}


    //Dto object
    public AlunoDto(AlunoEntity aluno) {
        this.name = aluno.getName();
        this.id = aluno.getId();
    }
}
