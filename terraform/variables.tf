variable "project" {
  description = "Name of the project"
}
variable "region" {
  description = "Specify AWS region"
}
variable "filename" {
  description = "Filename (full path if necessary) for lambda function"
}
variable "runtime" {
  description = "Specify runtime for lambda function"
}
variable "handler" {
  description = "Specify entrypoint function for Lambda"
}
variable "route_key" {
  description = "Specify route path for AWS API Gateway"
}
variable "memory_size" {
  description = "Specify Lambda memory limit. Default is 128 Mb"
}