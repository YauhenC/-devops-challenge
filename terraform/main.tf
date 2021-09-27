terraform {

  backend "s3" {
    bucket = "devops-challenge-tfstate"
    key    = "lambda-challenge/terraform.tfstate"
    region = "us-east-1"
  }

}
