package com.project.firstjobapp.job.impl;

import com.project.firstjobapp.job.Job;
import com.project.firstjobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    private final List<Job> jobList = new ArrayList<>();
    private Long nextId = 101L;

    @Override
    public List<Job> findAll() {
        return jobList.stream().sorted(Comparator.comparingLong(Job::getId)).collect(Collectors.toList());
    }

    @Override
    public void createJob(Job job) {

        job.setId(nextId++);
        jobList.add(job);
    }

    @Override
    public Job getJob(Long id) {
        return jobList.stream().filter(job1 -> id.equals(job1.getId())).findFirst().orElse(null);
    }

    @Override
    public boolean deleteJob(Long id) {
        Iterator<Job> itr = jobList.iterator();
        boolean isDeleted = false;

        while(itr.hasNext()){
            Job job = itr.next();
            if(id.equals(job.getId())){
                itr.remove();
                isDeleted=true;
            }
        }
        return isDeleted;
    }

    @Override
    public boolean updateJob(Long id, Job job) {

        for(Job j:jobList){
            if(id.equals(j.getId())){
                j.setTitle(job.getTitle());
                j.setDescription(job.getDescription());
                j.setMinSalary(job.getMinSalary());
                j.setMaxSalary(job.getMaxSalary());
                j.setLocation(job.getLocation());
                return true;
            }
        }

        return false;
    }
}
