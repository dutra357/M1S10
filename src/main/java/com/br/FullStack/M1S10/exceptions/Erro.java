package com.br.FullStack.M1S10.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Erro {

    private String codigo;
    private String mensagem;

}
