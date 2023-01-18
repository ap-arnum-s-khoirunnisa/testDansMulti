package com.dansmulti.test.test2dan3;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Arnum Sari Khoirunnisa
 * @date 07/01/23
 */
@RestController
@RequiredArgsConstructor
public class JobController {
    private final DansRestClient dansRestClient;
    private final GeneratedJwt generatedJwt;

//    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/jobs")
    public ResponseEntity<Object> getJobs(@RequestHeader("Authorization") String authorization) {
            // Validate the JWT
            if (!generatedJwt.validateToken(authorization)) {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }

            // Fetch the jobs from the external API
            Object jobs = dansRestClient.getJobs();


            return new ResponseEntity<>(jobs, HttpStatus.OK);
        }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Object> getJobDetail(@RequestHeader("Authorization") String authorization,
                                                  @PathVariable("id") Long id) {

//        String jwt = authorization.substring(7);

        // Validate the JWT
        if (!generatedJwt.validateToken(authorization)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        // Fetch the job detail from the external API
        Object job = dansRestClient.getJobDetail(id);

        return new ResponseEntity<>(job, HttpStatus.OK);
    }
    }
