package br.com.saborexpress.payments.presentation.api.v1.dto.page;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomPage<T> {

    private List<T> content;

    private CustomPaginator paginator;

    public static <T> CustomPage<T> create(List<T> content, Page<?> page) {
        return CustomPage.<T>builder()
                .content(content)
                .paginator(CustomPaginator.create(page))
                .build();
    }
}
