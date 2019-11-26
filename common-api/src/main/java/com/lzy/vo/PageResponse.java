package com.lzy.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageResponse<T> {
    private Integer pages;
    private Long elements;
    private List<T> concent;

    public PageResponse() {
    }

    public PageResponse(Integer pages, Long elements, List<T> concent) {
        this.pages = pages;
        this.elements = elements;
        this.concent = concent;
    }
}
