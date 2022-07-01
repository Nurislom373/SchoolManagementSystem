package org.khasanof.examservice.examType.router;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.khasanof.examservice.examType.dto.ExamTypeCreateDTO;
import org.khasanof.examservice.examType.dto.ExamTypeUpdateDTO;
import org.khasanof.examservice.examType.entity.ExamType;
import org.khasanof.examservice.examType.handler.ExamTypeHandler;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@RequiredArgsConstructor
public class ExamTypeRouter {

    private final ExamTypeHandler handler;

    @Bean
    @RouterOperations({
            @RouterOperation(
                    path = "/exam_type/{id}",
                    produces = {
                            MediaType.APPLICATION_JSON_VALUE
                    },
                    method = RequestMethod.GET,
                    beanClass = ExamTypeHandler.class,
                    beanMethod = "get",
                    operation = @Operation(
                            operationId = "get",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "success",
                                            content = @Content(schema = @Schema(
                                                    implementation = ExamType.class
                                            ))
                                    ),
                                    @ApiResponse(responseCode = "404", description = "customer not found with given id")
                            },
                            parameters = {
                                    @Parameter(in = ParameterIn.PATH, name = "id")
                            }
                    )
            ),
            @RouterOperation(
                    path = "/exam_type",
                    produces = {
                            MediaType.APPLICATION_JSON_VALUE
                    },
                    method = RequestMethod.GET,
                    beanClass = ExamTypeHandler.class,
                    beanMethod = "getAll",
                    operation = @Operation(
                            operationId = "getAll",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "success",
                                            content = @Content(schema = @Schema(
                                                    implementation = ExamType.class
                                            ))
                                    )
                            }
                    )
            ),
            @RouterOperation(
                    path = "/exam_type/create",
                    produces = {
                            MediaType.APPLICATION_JSON_VALUE
                    },
                    method = RequestMethod.POST,
                    beanClass = ExamTypeHandler.class,
                    beanMethod = "save",
                    operation = @Operation(
                            operationId = "save",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "success",
                                            content = @Content(schema = @Schema(
                                                    implementation = ExamType.class
                                            ))
                                    )
                            },
                            requestBody = @RequestBody(
                                    content = @Content(schema = @Schema(
                                            implementation = ExamTypeCreateDTO.class
                                    ))
                            )
                    )
            ),
            @RouterOperation(
                    path = "/exam_type/update/{id}",
                    produces = {
                            MediaType.APPLICATION_JSON_VALUE
                    },
                    method = RequestMethod.PUT,
                    beanClass = ExamTypeHandler.class,
                    beanMethod = "update",
                    operation = @Operation(
                            operationId = "update",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "success",
                                            content = @Content(schema = @Schema(
                                                    implementation = ExamType.class
                                            ))
                                    )
                            },
                            parameters = {
                                    @Parameter(in = ParameterIn.PATH, name = "id")
                            },
                            requestBody = @RequestBody(
                                    content = @Content(schema = @Schema(
                                            implementation = ExamTypeUpdateDTO.class
                                    ))
                            )
                    )
            ),
            @RouterOperation(
                    path = "/exam_type/delete/{id}",
                    produces = {
                            MediaType.APPLICATION_JSON_VALUE
                    },
                    method = RequestMethod.PUT,
                    beanClass = ExamTypeHandler.class,
                    beanMethod = "delete",
                    operation = @Operation(
                            operationId = "delete",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "success",
                                            content = @Content(schema = @Schema(
                                                    implementation = Void.class
                                            ))
                                    )
                            },
                            parameters = {
                                    @Parameter(in = ParameterIn.PATH, name = "id")
                            }
                    )
            )
    })
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route()
                .GET("/exam_type/{id}", handler::get)
                .GET("/exam_type", handler::getAll)
                .POST("/exam_type/create", handler::save)
                .PUT("/exam_type/update/{id}", handler::update)
                .DELETE("/exam_type/delete/{id}", handler::delete)
                .build();
    }
}
