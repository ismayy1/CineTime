package com.project.entity.enums;

public enum MovieStatus {
    COMING_SOON("Coming Soon"),
    IN_THEATERS("In theaters"),
    PRESALE("Presale");

    public final String status;

    MovieStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
