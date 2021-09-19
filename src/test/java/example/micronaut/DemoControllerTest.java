package example.micronaut;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.internal.testutils.AwsProxyRequestBuilder;
import com.amazonaws.serverless.proxy.internal.testutils.MockLambdaContext;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.services.lambda.runtime.Context;
import io.micronaut.function.aws.proxy.MicronautLambdaHandler;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpMethod;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DemoControllerTest {

    private static MicronautLambdaHandler handler;
    private static Context lambdaContext = new MockLambdaContext();

    private static final String CONTENT = "{\"username\":\"xyz\",\"password\":\"xyz\"}";
    private static final String CONTENT_BAD = "{\"username\":\"xyz\"}";

    @BeforeAll
    public static void setupSpec() {
        try {
            handler = new MicronautLambdaHandler();

        } catch (ContainerInitializationException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    public static void cleanupSpec() {
        handler.getApplicationContext().close();
    }

    @Test
    void testPostOk() {
        AwsProxyRequest request = new AwsProxyRequestBuilder("/api", HttpMethod.POST.toString())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .body(CONTENT)
                .build();
        AwsProxyResponse response = handler.handleRequest(request, lambdaContext);
        Assertions.assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
        String result = response.getBody();
        Assertions.assertTrue(result.contains(CONTENT));
    }

    @Test
    void testGetOk() {
        AwsProxyRequest request = new AwsProxyRequestBuilder("/api", HttpMethod.GET.toString())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .body(CONTENT)
                .build();
        AwsProxyResponse response = handler.handleRequest(request, lambdaContext);
        Assertions.assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
        String result = response.getBody();
        Assertions.assertTrue(result.contains(CONTENT));
    }

    @Test
    void testPost400() {
        AwsProxyRequest request = new AwsProxyRequestBuilder("/api", HttpMethod.POST.toString())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .body(CONTENT_BAD)
                .build();
        AwsProxyResponse response = handler.handleRequest(request, lambdaContext);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST.getCode(), response.getStatusCode());
    }

    @Test
    void testPut405() {
        AwsProxyRequest request = new AwsProxyRequestBuilder("/api", HttpMethod.PUT.toString())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .body(CONTENT_BAD)
                .build();
        AwsProxyResponse response = handler.handleRequest(request, lambdaContext);
        Assertions.assertEquals(HttpStatus.METHOD_NOT_ALLOWED.getCode(), response.getStatusCode());
    }
}
