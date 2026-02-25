provider "aws" {
  region = "us-east-1"
}

resource "aws_security_group" "open_sg" {
  name = "open_sg"

  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"] # Open to world
  }
}

resource "aws_db_instance" "default" {
  identifier         = "ecommerce-db"
  engine             = "postgres"
  instance_class     = "db.t3.micro"
  allocated_storage  = 20
  publicly_accessible = true # Vulnerable
}
