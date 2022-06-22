package org.khasanof.authservice.controller;

import lombok.RequiredArgsConstructor;
import org.khasanof.authservice.service.BaseService;

@RequiredArgsConstructor
public abstract class AbstractController<S extends BaseService> {
    protected final S service;
}
