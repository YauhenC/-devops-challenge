# Common variables
project = "devops-challenge"
region  = "us-east-1"
#lambda variables
filename = "*.zip"
handler  = "io.micronaut.function.aws.proxy.MicronautLambdaHandler"
runtime  = "java11"

route_key = "ANY /api"
