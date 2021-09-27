terraform {

  backend "s3" {
    bucket = "nm-devops-challenge-tfstate"
    key    = "lambda-challenge/terraform.tfstate"
    region = "eu-central-1"
  }

}
