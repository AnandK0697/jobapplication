package com.project.firstjobapp.job;

import org.springframework.stereotype.Service;

import java.util.List;

public interface JobService {

    public List<Job> findAll();
    public void createJob(Job job);
    public Job getJob(Long id);
    public boolean deleteJob(Long id);
    public boolean updateJob(Long id, Job job);
}
