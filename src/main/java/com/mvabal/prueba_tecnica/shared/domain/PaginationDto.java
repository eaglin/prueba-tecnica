package com.mvabal.prueba_tecnica.shared.domain;

import java.util.Optional;

public class PaginationDto {

    Integer page;
    Integer limit;

    public PaginationDto() {
        this.page = 0;
        this.limit = 10;
    }

    public PaginationDto(Optional<Integer> page, Optional<Integer> limit) {
        this.page = page.orElse(0);
        this.limit = limit.orElse(10);
    }

    public Integer getPage() {
        return page;
    }

    public Integer getLimit() {
        return limit;
    }

}
