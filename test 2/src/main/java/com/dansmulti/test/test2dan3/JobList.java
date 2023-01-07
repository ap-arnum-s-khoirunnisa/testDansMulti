package com.dansmulti.test.test2dan3;

import lombok.Data;

import java.util.List;

/**
 * @author Arnum Sari Khoirunnisa
 * @date 07/01/23
 */
@Data
public class JobList {
    private List<Job> jobs;

    public List<Job> getJobs() {
        return jobs;
    }
}
