package org.khasanof.classroomservice.controller;

import lombok.RequiredArgsConstructor;
import org.khasanof.classroomservice.service.BaseService;

@RequiredArgsConstructor
public abstract class AbstractController<S extends BaseService> {
    protected final S service;
}
