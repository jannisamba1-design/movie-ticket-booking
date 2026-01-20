pipeline {
    agent any

    tools {
        jdk 'jdk-17'
        maven 'maven-3'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build Booking Service') {
            steps {
                dir('booking-service') {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Docker Build') {
            steps {
                dir('booking-service') {
                    sh 'docker build -t booking-service:${BUILD_NUMBER} .'
                }
            }
        }
    }

    post {
        success {
            echo 'CI build successful'
        }
        failure {
            echo 'CI build failed'
        }
    }
}
