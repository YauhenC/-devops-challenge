package com.example.appdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
public class DemoController {

    private final ObjectMapper mapper;

    public DemoController(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @RequestMapping(value = "/api", method = {GET, POST})
    public String multiMethodEndpoint(HttpServletRequest request,
                                      @RequestHeader Map<String, String> headers,
                                      @Validated @RequestBody DemoRequestBody body) throws JsonProcessingException {

        return MessageFormat
                .format("Welcome to our demo API, here are the details of your request:\nHeaders: {0}\nMethod: {1}\nBody: {2}",
                        headers,
                        request.getMethod(),
                        mapper.writeValueAsString(body));
    }

}
