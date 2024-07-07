package org.ducanh.domain.errors;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class DomainExceptions extends RuntimeException {
    Errors errors;
    String message;
}
