# Common variables
project = "devops-challenge"
region  = "us-east-2"
#lambda variables
filename = "./micronautguide-0.1-all.jar"
handler  = "io.micronaut.function.aws.proxy.MicronautLambdaHandler"
runtime  = "java11"

route_key = "ANY /api"
