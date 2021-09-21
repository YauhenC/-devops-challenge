terraform {

  backend "s3" {
    bucket = "devops-challenge-terra"
    key    = "lambda-challenge/terraform.tfstate"
    region = "us-east-1"
  }

}
