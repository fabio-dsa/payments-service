package br.com.saborexpress.payments.presentation.api.v1.dto.page;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomPaginator {

    private boolean empty;

    private boolean firstPage;

    private boolean lastPage;

    private Long currentPage;

    private Long size;

    private Long totalElements;

    private Long totalPages;

    public static CustomPaginator create(Page<?> page) {
        return CustomPaginator.builder()
                .empty(page.isEmpty())
                .firstPage(page.isFirst())
                .lastPage(page.isLast())
                .currentPage(page.getNumber() + 1L)
                .size((long) page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages((long) page.getTotalPages())
                .build();
    }
}
