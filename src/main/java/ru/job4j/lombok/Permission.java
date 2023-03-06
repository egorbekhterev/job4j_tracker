package ru.job4j.lombok;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

import java.util.List;

/**
 * @author: Egor Bekhterev
 * @date: 06.03.2023
 * @project: job4j_tracker
 */

@Builder(builderMethodName = "of")
@ToString
@Getter
public class Permission {
    private int id;
    private String name;

    @Singular("accessBy")
    private List<String> rules;

    public static void main(String[] args) {
        var permission = Permission.of()
                .id(1)
                .name("POST")
                .accessBy("create")
                .accessBy("edit")
                .accessBy("read")
                .accessBy("delete")
                .build();
        System.out.println(permission);
    }
}
