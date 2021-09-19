package example.micronaut;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

import javax.validation.Valid;
import java.text.MessageFormat;

@Controller("/api")
public class DemoController {

    @Inject
    private ObjectMapper mapper;

    @Post
    public String postInfo(@Valid @Body DemoRequestBody demoRequestBody, HttpRequest<?> request) throws JsonProcessingException {
        return buildMessage(mapper.writeValueAsString(demoRequestBody), request);
    }

    @Get
    public String getInfo(@Body String body, HttpRequest<?> request) {
        return buildMessage(body, request);
    }

    private String buildMessage(String body, HttpRequest<?> request) {
        String result = MessageFormat
                .format("Welcome to our demo API, here are the details of your request:\nHeaders: {0}\nMethod: {1}\nBody: {2}",
                        request.getHeaders().asMap(),
                        request.getMethod(),
                        body);
        System.out.println("RESULT:" + result);
        return result;
    }
}
