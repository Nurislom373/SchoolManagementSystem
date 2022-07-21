package org.khasanof.classroomservice.repository.course;

import org.khasanof.classroomservice.domain.course.Course;
import org.khasanof.classroomservice.repository.BaseRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends MongoRepository<Course, String>, BaseRepository {
    List<Course> findAllByGradeIdEquals(String gradeId);
}
