package ank.phito.erp.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LogRequest {
    private final String title;
    private final String description;
}