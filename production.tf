provider "aws" {
  region = var.region
}

resource "null_resource" "docker_packaging" {

  provisioner "local-exec" {
    command = <<EOF
	    aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 372431383879.dkr.ecr.us-east-1.amazonaws.com/fast-food-app
	    docker build -t fast-food-app:latest .
        docker tag fast-food-app:latest 372431383879.dkr.ecr.us-east-1.amazonaws.com/fast-food-app:latest
	    docker push 372431383879.dkr.ecr.us-east-1.amazonaws.com/fast-food-app:latest
	    EOF
  }

  triggers = {
    "run_at" = timestamp()
  }
}