package com.example.spring.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

@Accessors(chain = true)
@Data
public class StatusException extends RuntimeException {
    private HttpStatus status;
    private String message;
    private Object data;

    public StatusException(HttpStatus status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    /**
     * 性能优化
     *
     * @return
     */
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
