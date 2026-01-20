pipeline {
    agent any

    environment {
        AWS_REGION = 'ap-south-1'
        AWS_ACCOUNT_ID = '334228653606'
        ECR_REPO = "${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_REGION}.amazonaws.com/booking-service"
        IMAGE_TAG = "${BUILD_NUMBER}"
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build Application') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                sh "docker build -t booking-service:${IMAGE_TAG} ."
            }
        }

        stage('Login to ECR') {
            steps {
                sh """
                aws ecr get-login-password --region ${AWS_REGION} |
                docker login --username AWS --password-stdin ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_REGION}.amazonaws.com
                """
            }
        }

        stage('Docker Tag') {
            steps {
                sh """
                docker tag booking-service:${IMAGE_TAG} \
                ${ECR_REPO}:${IMAGE_TAG}
                """
            }
        }

        stage('Docker Push') {
            steps {
                sh "docker push ${ECR_REPO}:${IMAGE_TAG}"
            }
        }
    }

    post {
        success {
            echo 'Image successfully pushed to ECR'
        }
        failure {
            echo 'CI build failed'
        }
    }
}
