package org.khasanof.classroomservice.criteria.classroom;

import lombok.Getter;
import lombok.Setter;
import org.khasanof.classroomservice.criteria.GenericCriteria;
import org.khasanof.classroomservice.enums.classroom.ClassroomFieldsEnum;
import org.springdoc.api.annotations.ParameterObject;

@Getter
@Setter
@ParameterObject
public class ClassroomCriteria extends GenericCriteria {
    private ClassroomFieldsEnum fieldsEnum;
}
