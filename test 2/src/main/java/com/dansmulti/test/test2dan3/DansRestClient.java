package com.dansmulti.test.test2dan3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Objects;

/**
 * @author Arnum Sari Khoirunnisa
 * @date 07/01/23
 */
@Service
public class DansRestClient {
    @Autowired
    @Qualifier("ServiceRestTemplate")
    private RestTemplate restTemplate;

    @Autowired
    DansMultiUrl dansMultiUrl;

    public List<Job> getJobs() {
        String urlTemplate = UriComponentsBuilder.fromHttpUrl(dansMultiUrl.getList())
                .encode()
                .toUriString();
        return Objects.requireNonNull(restTemplate.getForObject(
                urlTemplate,
                JobList.class)).getJobs();
    }

    public Job getJobDetail(Long id) {
        String urlTemplate = UriComponentsBuilder.fromHttpUrl(dansMultiUrl.getDetail())
                .encode()
                .toUriString();
        return Objects.requireNonNull(restTemplate.getForObject(
                urlTemplate,
                Job.class, id));
    }


}
