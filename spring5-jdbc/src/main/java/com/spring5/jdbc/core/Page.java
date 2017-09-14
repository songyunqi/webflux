/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring5.jdbc.core;

import java.util.List;

/**
 *
 * @author Yang
 */
public class Page {

    private static final int PAGE_SIZE = 10;

    private List<?> content;

    private long totalPages;

    private long page = 1;

    public long getTotalPages() {
        return totalPages;
    }
}
