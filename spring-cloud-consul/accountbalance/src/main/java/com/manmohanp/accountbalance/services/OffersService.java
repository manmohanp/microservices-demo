package com.manmohanp.accountbalance.services;


import com.manmohanp.accountbalance.models.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Component
@EnableDiscoveryClient
public class OffersService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    public List<Offer> getOffers(String accountId) {
        String reqURL = "/offers/" + accountId;

        URI uri = discoveryClient.getInstances("offers").stream().map(si -> si.getUri()).findFirst()
                .map(s -> s.resolve(reqURL)).get();

        ResponseEntity<List<Offer>> responseEntity = restTemplate.exchange(uri, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Offer>>() {
                });

        return responseEntity.getBody();
    }

    @Bean
    public RestTemplate template() {
        return new RestTemplate(getClientHttpRequestFactory());
    }

    private HttpComponentsClientHttpRequestFactory getClientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory =
                new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(10_000);
        clientHttpRequestFactory.setReadTimeout(10_000);
        return clientHttpRequestFactory;
    }

}
