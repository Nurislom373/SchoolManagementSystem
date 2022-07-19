package org.khasanof.classroomservice.repository.classroom;

import org.khasanof.classroomservice.domain.classroom.Classroom;
import org.khasanof.classroomservice.repository.BaseRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomRepository extends MongoRepository<Classroom, String>, PagingAndSortingRepository<Classroom, String>, BaseRepository {
    List<Classroom> findAllByGradeIdEquals(String gradeId);
}
