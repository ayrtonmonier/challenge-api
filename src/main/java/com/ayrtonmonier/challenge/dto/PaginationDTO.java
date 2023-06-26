package com.ayrtonmonier.challenge.dto;

import java.util.List;

public class PaginationDTO<T> {
    private int pageNumber;
    private int pageSize;
    private long totalCount;
    private List<T> users;

    public PaginationDTO() {}
    
    public PaginationDTO(int pageNumber, int pageSize, long totalCount, List<T> users) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.users = users;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getUsers() {
        return users;
    }

    public void setUsers(List<T> users) {
        this.users = users;
    }
}
