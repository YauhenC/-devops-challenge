terraform {

  backend "s3" {
    bucket = "devops-challenge-terrafor"
    key    = "lambda-challenge/terraform.tfstate"
    region = "us-east-1"
  }

}
