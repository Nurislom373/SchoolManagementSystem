package org.khasanof.classroomservice.repository.classroom;

import org.khasanof.classroomservice.domain.classroom.Classroom;
import org.khasanof.classroomservice.repository.BaseRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ClassroomRepository extends MongoRepository<Classroom, String>, BaseRepository {
    @Query("{ :#{#key} : :#{#value} }")
    List<Classroom> findAll(String key, String value);

    @Query("{ :#{#key} : :#{#value} }")
    List<Classroom> findAll(String key, Integer value);

    @Query("{ 'year' : {$gt: ?1, $lt: ?2} }")
    List<Classroom> findAll(String key, Integer min, Integer max);

    @Transactional
    Void deleteAllByTeacherIdEquals(String teacherId);

    List<Classroom> findAllByTeacherIdEquals(String teacherId);

    List<Classroom> findAllByGradeIdEquals(String id);
}
