package com.rs.ecommerce.shop.controller;

import com.rs.ecommerce.shop.model.Customer;
import com.rs.ecommerce.shop.model.Test;
import com.rs.ecommerce.shop.repository.CustomerRepository;
import com.rs.ecommerce.shop.repository.TestRepository;
import org.apache.catalina.util.URLEncoder;
import org.apache.hc.core5.net.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.mvc.method.annotation.UriComponentsBuilderMethodArgumentResolver;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriTemplate;

import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private TestRepository testRepository;

//    String url = "curl -i -X POST -H 'Content-Type: application/json' -d '{\"id\": 103, \"name\": \"abc\"}' http://localhost:8080/test";

//    String url = "http://localhost:8080/test/{id}/name/{name}";

    @GetMapping(("/customers"))
    public List<Customer> getCustomers() throws FileNotFoundException, URISyntaxException {

//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        Map<String, String> personJsonObject = new HashMap<>();
//        personJsonObject.put("id", "1");
//        personJsonObject.put("name", "John");

//        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(headers);
//
//        restTemplate.postForEntity(url, requestEntity, Customer.class);
//        Post post = responseEntity.getBody();



//        WebClient.Builder builder = WebClient.builder();
//        builder.build()
//                .post()
//                .uri(url);
//                .retrieve()
//                .bodyToMono(String.class);
//                .block();
//        System.out.println(res);

//        URI uri = new URIBuilder("").addParameter("", "").addParameter("", "").build();
        URI uri = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost").port(8080)
                .path("/test/{id}/name/{name}")
                .buildAndExpand(108, "Sourav") // value for {id1} in the path
                .toUri();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type", "application/json")
//                .POST(HttpRequest.BodyPublishers.ofFile(Paths.get("file.json")))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();


        HttpClient client = HttpClient.newBuilder().build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString());


//                .thenApply(response -> { System.out.println(response.statusCode());
//                    return response; } )
//                .thenApply(HttpResponse::body)
//                .thenAccept(System.out::println);





        return customerRepository.findAll();
    }

    @GetMapping(("/customers/{cusId}"))
    public Optional<Customer> getCustomersById(@PathVariable("cusId") int id)
    {
        return customerRepository.findById(id);
    }

    @PostMapping("/customers")
    public Customer addCustomersById(@RequestBody Customer customer)
    {
        customerRepository.save(customer);
        return customer;
    }

//    @PostMapping("/test")
//    public void add(@RequestBody Test test)
//    {
//        testRepository.save(test);
//    }

    @PostMapping("/test/{id}/name/{name}")
    public void add(@PathVariable int id, @PathVariable String name)
    {
        System.out.println("test");
        Test test = new Test();
        test.setId(id);
        test.setName(name);
        testRepository.save(test);
    }
}
