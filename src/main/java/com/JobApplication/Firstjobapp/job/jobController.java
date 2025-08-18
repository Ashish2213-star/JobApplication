package com.JobApplication.Firstjobapp.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/jobs")
public class jobController {
    private jobServices jobServices;

    public jobController(jobServices jobServices) {
        this.jobServices = jobServices;
    }

    @GetMapping
    public ResponseEntity<List<Job>>findAll(){
       List<Job> job=jobServices.findAll();
       if(job.isEmpty()) return new ResponseEntity<>(job,HttpStatus.NO_CONTENT);
       return new  ResponseEntity<>(job,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createJob( @RequestBody Job job){
        jobServices.createJob(job);
       return new ResponseEntity<>("Job added successfully",HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Job> getByID(@PathVariable Long id){
        Job job=jobServices.getByID(id);
        if(job!=null) return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteJobById(@PathVariable Long id){
        boolean remove=jobServices.deleteJobById(id);
        if(remove){
            return  new ResponseEntity<>("Job delete successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Job Not Found",HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String>updateJobById(@PathVariable Long id, @RequestBody Job job){
        boolean remove=jobServices.updateJob(id,job);
        if(remove)return new ResponseEntity<>("Job Update successfully ",HttpStatus.OK);
        return new ResponseEntity<>("Job not found",HttpStatus.NOT_FOUND);
    }
}
