package br.com.saborexpress.payments.presentation.api.v1.dto.assembler;

import br.com.saborexpress.payments.presentation.api.v1.dto.page.CustomPage;
import org.springframework.data.domain.Page;

import java.util.List;

public interface Assembler<E, D> {
    D toDTO(E entity);

    default List<D> toDTOList(List<E> entities) {
        return entities.stream()
                .map(this::toDTO)
                .toList();
    }

    default CustomPage<D> toDTOPage(Page<E> page) {
        return CustomPage.create(this.toDTOList(page.getContent()), page);
    }
}
