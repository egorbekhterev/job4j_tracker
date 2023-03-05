package ru.job4j.lombok;

import lombok.*;

/**
 * @author: Egor Bekhterev
 * @date: 05.03.2023
 * @project: job4j_tracker
 */
@EqualsAndHashCode
@RequiredArgsConstructor
public class Category {
    @NonNull
    @EqualsAndHashCode.Include
    @Getter
    private int id;
    @Getter
    @Setter
    private String name;
}
