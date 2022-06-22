package org.khasanof.authservice.controller.parent;

import org.khasanof.authservice.controller.AbstractController;
import org.khasanof.authservice.service.parent.ParentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/parent/*")
public class ParentController extends AbstractController<ParentService> {

    public ParentController(ParentService service) {
        super(service);
    }
}
