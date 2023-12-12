package com.cts.authorization.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class ExceptionDetailsTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ExceptionDetails#ExceptionDetails(LocalDateTime, String)}
     *   <li>{@link ExceptionDetails#setMessage(String)}
     *   <li>{@link ExceptionDetails#setTimeStamp(LocalDateTime)}
     * </ul>
     */
    @Test
    void testConstructor() {
        ExceptionDetails actualExceptionDetails = new ExceptionDetails(LocalDateTime.of(1, 1, 1, 1, 1),
                "An error occurred");
        actualExceptionDetails.setMessage("An error occurred");
        LocalDateTime ofResult = LocalDateTime.of(1, 1, 1, 1, 1);
        actualExceptionDetails.setTimeStamp(ofResult);
        assertEquals("An error occurred", actualExceptionDetails.getMessage());
        assertSame(ofResult, actualExceptionDetails.getTimeStamp());
    }
}

