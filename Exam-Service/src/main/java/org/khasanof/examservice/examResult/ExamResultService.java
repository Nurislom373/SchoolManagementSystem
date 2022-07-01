package org.khasanof.examservice.examResult;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamResultService {

    private final ExamResultMapper mapper;
    private final ExamResultRepository repository;

}
