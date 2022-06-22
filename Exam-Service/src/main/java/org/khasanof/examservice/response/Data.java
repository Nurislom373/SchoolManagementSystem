package org.khasanof.examservice.response;

import lombok.Getter;
import lombok.Setter;
import reactor.core.publisher.Mono;

@Getter
@Setter
public class Data<T> {
    protected T data;
    protected long totalCount;
    protected boolean isSuccess;
    protected ApplicationError error;

    public Data(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Data(T data) {
        this.data = data;
        this.isSuccess = true;
    }

    public Data(ApplicationError error) {
        this.error = error;
        this.isSuccess = false;
    }

    public Data(T data, long totalCount) {
        this.data = data;
        this.isSuccess = true;
        this.totalCount = totalCount;
    }
}