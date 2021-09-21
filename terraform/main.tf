terraform {

  backend "s3" {
    bucket = "devops-challenge-terraform0"
    key    = "lambda-challenge/terraform.tfstate"
    region = "us-east-2"
  }

}
