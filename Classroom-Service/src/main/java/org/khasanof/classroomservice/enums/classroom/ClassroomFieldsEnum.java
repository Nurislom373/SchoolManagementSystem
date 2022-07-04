package org.khasanof.classroomservice.enums.classroom;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ClassroomFieldsEnum {
    SECTION("section");
    private final String value;
}
