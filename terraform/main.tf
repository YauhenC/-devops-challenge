terraform {

  backend "s3" {
    bucket = "devops-challenge-terraform"
    key    = "lambda-challenge/terraform.tfstate"
    region = "us-east-1"
  }

}
