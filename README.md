# DevOps Engineer Challenge

1. Here is used *Python* for this app. Source code is located in `src` directory, where: 
- `app.py` - simple lambda application,
- `test.py` - simple unit tests for methods declared in `app.py`.

2. Terraform code based on `terraform` directory. This `tf` manifests contain:
- AWS Lambda and iAM role for Lambda
- HTTP API Gateway with Stage, Integration **(Payload version: 2.0)**, Route and Permissions for invoke Lambda function.

>*To run this code you need to create S3 bucket for storing tf state, IAM user with approptiate permissions and specify backend settings in `main.tf`. Also need to add values Secrets to GitHub repository **AWS_ACCESS_KEY_ID** and **AWS_SECRET_ACCESS_KEY***

3. CI/CD with GitHub Action (`.github/workflows/python-app.yml`) with following jobs:
- check (run simple flake8 linter and unit tests),
- build (in my case, it's creation of `.zip` file),
- deploy (configure AWS credentials and deploy TF code),
- test (Send "GET", "POST", "PUT" requsts for test results),
- destroy (destroy tf code)

4. To test the results you need to deploy this application and send request to an API endpoint. (when run locally to get URL endpoint you can use `$(terraform output -raw base_url)/api`)

Examples:

![alt Examples](images/examples.png)
