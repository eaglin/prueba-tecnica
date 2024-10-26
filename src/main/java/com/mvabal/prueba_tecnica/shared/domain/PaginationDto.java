package com.mvabal.prueba_tecnica.shared.domain;

import java.util.Optional;

public class PaginationDto {

    Optional<Integer> page;
    Optional<Integer> limit;

    public PaginationDto(Optional<Integer> page, Optional<Integer> limit) {
        this.page = page;
        this.limit = limit;
    }

    public Optional<Integer> getPage() {
        return page;
    }

    public Optional<Integer> getLimit() {
        return limit;
    }

}
