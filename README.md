# DevOps Engineer Challenge

1. Here is used *Java* for this app. Source code is located in `src` directory, where: 
- `AppDemoApplication.java ` - simple lambda application,
- `AppDemoApplicationTests.java` - simple unit tests for methods declared in `AppDemoApplication.java `.

2. Terraform code based on `terraform` directory. This `tf` manifests contain:
- AWS Lambda and iAM role for Lambda
- HTTP API Gateway with Stage, Integration **(Payload version: 2.0)**, Route and Permissions for invoke Lambda function.

>*To run this code you need to create S3 bucket for storing tf state, IAM user with approptiate permissions and specify backend settings in `main.tf`. Also need to add values Secrets to GitHub repository **AWS_ACCESS_KEY_ID** and **AWS_SECRET_ACCESS_KEY***

3. CI/CD with GitHub Action (`.github/workflows/Java CI with Maven`) with following jobs:
- indicate (indicate java version and system for build),
- build (build jar file),

3.1 build docker-image.yml 
- build docker image,


4. To test the results you need to deploy this application and send request to an API endpoint. (when run locally to get URL endpoint you can use `$(terraform output -raw base_url)/api`)

Examples:

![alt Examples](images/examples.png)
