package org.khasanof.examservice.config.router;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.khasanof.examservice.exam.dto.ExamCreateDTO;
import org.khasanof.examservice.exam.dto.ExamGetDTO;
import org.khasanof.examservice.exam.dto.ExamUpdateDTO;
import org.khasanof.examservice.exam.entity.Exam;
import org.khasanof.examservice.exam.handler.ExamHandler;
import org.khasanof.examservice.examResult.dto.ExamResultCreateDTO;
import org.khasanof.examservice.examResult.dto.ExamResultDetailDTO;
import org.khasanof.examservice.examResult.dto.ExamResultGetDTO;
import org.khasanof.examservice.examResult.dto.ExamResultUpdateDTO;
import org.khasanof.examservice.examResult.entity.ExamResult;
import org.khasanof.examservice.examResult.handler.ExamResultHandler;
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
public class RouterConfig {

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
                    path = "/exam_type/save",
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
                    path = "/exam_type/delete/{id}",
                    produces = {
                            MediaType.APPLICATION_JSON_VALUE
                    },
                    method = RequestMethod.DELETE,
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
            )
    })
    public RouterFunction<ServerResponse> examTypeRouter(ExamTypeHandler handler) {
        return RouterFunctions.route()
                .GET("/exam_type/{id}", handler::get)
                .GET("/exam_type", handler::getAll)
                .POST("/exam_type/save", handler::save)
                .DELETE("/exam_type/delete/{id}", handler::delete)
                .PUT("/exam_type/update/{id}", handler::update)
                .build();
    }

    @Bean
    @RouterOperations({
            @RouterOperation(
                    path = "/exam_result/detail/{id}",
                    produces = {
                            MediaType.APPLICATION_JSON_VALUE
                    },
                    method = RequestMethod.GET,
                    beanClass = ExamResultHandler.class,
                    beanMethod = "detail",
                    operation = @Operation(
                            operationId = "detail",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "success",
                                            content = @Content(schema = @Schema(
                                                    implementation = ExamResultDetailDTO.class
                                            ))
                                    ),
                                    @ApiResponse(responseCode = "404", description = "exam result not found with given id")
                            },
                            parameters = {
                                    @Parameter(in = ParameterIn.PATH, name = "id")
                            }
                    )
            ),
            @RouterOperation(
                    path = "/exam_result/{id}",
                    produces = {
                            MediaType.APPLICATION_JSON_VALUE
                    },
                    method = RequestMethod.GET,
                    beanClass = ExamResultHandler.class,
                    beanMethod = "get",
                    operation = @Operation(
                            operationId = "get",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "success",
                                            content = @Content(schema = @Schema(
                                                    implementation = ExamResultGetDTO.class
                                            ))
                                    ),
                                    @ApiResponse(responseCode = "404", description = "exam result not found with given id")
                            },
                            parameters = {
                                    @Parameter(in = ParameterIn.PATH, name = "id")
                            }
                    )
            ),
            @RouterOperation(
                    path = "/exam_result",
                    produces = {
                            MediaType.APPLICATION_JSON_VALUE
                    },
                    method = RequestMethod.GET,
                    beanClass = ExamResultHandler.class,
                    beanMethod = "getAll",
                    operation = @Operation(
                            operationId = "getAll",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "success",
                                            content = @Content(schema = @Schema(
                                                    implementation = ExamResultGetDTO.class
                                            ))
                                    ),
                                    @ApiResponse(responseCode = "404", description = "exam result not found with given id")
                            }
                    )
            ),
            @RouterOperation(
                    path = "/exam_result/save",
                    produces = {
                            MediaType.APPLICATION_JSON_VALUE
                    },
                    method = RequestMethod.POST,
                    beanClass = ExamResultHandler.class,
                    beanMethod = "save",
                    operation = @Operation(
                            operationId = "save",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "success",
                                            content = @Content(schema = @Schema(
                                                    implementation = ExamResult.class
                                            ))
                                    ),
                                    @ApiResponse(responseCode = "404", description = "exam result not found with given id")
                            },
                            requestBody = @RequestBody(
                                    content = @Content(schema = @Schema(
                                            implementation = ExamResultCreateDTO.class
                                    ))
                            )
                    )
            ),
            @RouterOperation(
                    path = "/exam_result/delete/{id}",
                    produces = {
                            MediaType.APPLICATION_JSON_VALUE
                    },
                    method = RequestMethod.DELETE,
                    beanClass = ExamResultHandler.class,
                    beanMethod = "delete",
                    operation = @Operation(
                            operationId = "delete",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "success",
                                            content = @Content(schema = @Schema(
                                                    implementation = ExamResult.class
                                            ))
                                    ),
                                    @ApiResponse(responseCode = "404", description = "exam result not found with given id")
                            },
                            parameters = {
                                    @Parameter(in = ParameterIn.PATH, name = "id")
                            }
                    )
            ),
            @RouterOperation(
                    path = "/exam_result/update/{id}",
                    produces = {
                            MediaType.APPLICATION_JSON_VALUE
                    },
                    method = RequestMethod.PUT,
                    beanClass = ExamResultHandler.class,
                    beanMethod = "update",
                    operation = @Operation(
                            operationId = "update",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "success",
                                            content = @Content(schema = @Schema(
                                                    implementation = ExamResult.class
                                            ))
                                    ),
                                    @ApiResponse(responseCode = "404", description = "exam result not found with given id")
                            },
                            parameters = {
                                    @Parameter(in = ParameterIn.PATH, name = "id")
                            },
                            requestBody = @RequestBody(
                                    content = @Content(schema = @Schema(
                                            implementation = ExamResultUpdateDTO.class
                                    ))
                            )
                    )
            )
    })
    public RouterFunction<ServerResponse> examResultRouter(ExamResultHandler handler) {
        return RouterFunctions.route()
                .GET("/exam_result/detail/{id}", handler::detail)
                .GET("/exam_result/{id}", handler::get)
                .GET("/exam_result", handler::getAll)
                .POST("/exam_result/save", handler::save)
                .DELETE("/exam_result/delete/{id}", handler::delete)
                .PUT("/exam_result/update/{id}", handler::update)
                .build();
    }

    @Bean
    @RouterOperations({
            @RouterOperation(
                    path = "/exam/{id}",
                    produces = {
                            MediaType.APPLICATION_JSON_VALUE
                    },
                    method = RequestMethod.GET,
                    beanClass = ExamHandler.class,
                    beanMethod = "get",
                    operation = @Operation(
                            operationId = "get",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "success",
                                            content = @Content(schema = @Schema(
                                                    implementation = ExamGetDTO.class
                                            ))
                                    ),
                                    @ApiResponse(responseCode = "404", description = "exam not found with given id")
                            },
                            parameters = {
                                    @Parameter(in = ParameterIn.PATH, name = "id")
                            }
                    )
            ),
            @RouterOperation(
                    path = "/exam",
                    produces = {
                            MediaType.APPLICATION_JSON_VALUE
                    },
                    method = RequestMethod.GET,
                    beanClass = ExamHandler.class,
                    beanMethod = "getAll",
                    operation = @Operation(
                            operationId = "getAll",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "success",
                                            content = @Content(schema = @Schema(
                                                    implementation = ExamGetDTO.class
                                            ))
                                    ),
                                    @ApiResponse(responseCode = "404", description = "exam not found with given id")
                            }
                    )
            ),
            @RouterOperation(
                    path = "/exam/save",
                    produces = {
                            MediaType.APPLICATION_JSON_VALUE
                    },
                    method = RequestMethod.POST,
                    beanClass = ExamHandler.class,
                    beanMethod = "save",
                    operation = @Operation(
                            operationId = "save",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "success",
                                            content = @Content(schema = @Schema(
                                                    implementation = Exam.class
                                            ))
                                    ),
                                    @ApiResponse(responseCode = "404", description = "exam not found with given id")
                            },
                            requestBody = @RequestBody(
                                    content = @Content(schema = @Schema(
                                            implementation = ExamCreateDTO.class
                                    ))
                            )
                    )
            ),
            @RouterOperation(
                    path = "/exam/delete/{id}",
                    produces = {
                            MediaType.APPLICATION_JSON_VALUE
                    },
                    method = RequestMethod.DELETE,
                    beanClass = ExamHandler.class,
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
                                    ),
                                    @ApiResponse(responseCode = "404", description = "exam not found with given id")
                            },
                            parameters = {
                                    @Parameter(in = ParameterIn.PATH, name = "id")
                            }

                    )
            ),
            @RouterOperation(
                    path = "/exam/update/{id}",
                    produces = {
                            MediaType.APPLICATION_JSON_VALUE
                    },
                    method = RequestMethod.PUT,
                    beanClass = ExamHandler.class,
                    beanMethod = "update",
                    operation = @Operation(
                            operationId = "update",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "success",
                                            content = @Content(schema = @Schema(
                                                    implementation = Exam.class
                                            ))
                                    ),
                                    @ApiResponse(responseCode = "404", description = "exam not found with given id")
                            },
                            parameters = {
                                    @Parameter(in = ParameterIn.PATH, name = "id")
                            },
                            requestBody = @RequestBody(
                                    content = @Content(schema = @Schema(
                                            implementation = ExamUpdateDTO.class
                                    ))
                            )

                    )
            )
    })
    public RouterFunction<ServerResponse> examRouter(ExamHandler handler) {
        return RouterFunctions.route()
                .GET("/exam/{id}", handler::get)
                .GET("/exam", handler::getAll)
                .POST("/exam/save", handler::save)
                .DELETE("/exam/delete/{id}", handler::delete)
                .PUT("/exam/update/{id}", handler::update)
                .build();
    }
}
