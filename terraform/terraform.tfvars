# Common variables
project = "devops-challenge"
region  = "eu-central-1"
#lambda variables
filename    = "./micronautguide-0.1-all.jar"
handler     = "io.micronaut.function.aws.proxy.MicronautLambdaHandler"
runtime     = "java11"
memory_size = "512"

route_key = "ANY /api"
