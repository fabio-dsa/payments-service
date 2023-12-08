package br.com.saborexpress.payments.presentation.api.v1.dto.disassembler;

public interface Disassembler<D, E> {

    E toEntity(D dto);

}
