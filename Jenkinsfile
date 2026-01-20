pipeline {
    agent any

    tools {
        jdk 'jdk-17'
        maven 'maven-3'
    }

    options {
        skipDefaultCheckout(true)
    }

    stages {

        stage('Clean Workspace') {
            steps {
                echo 'Cleaning workspace'
                deleteDir()
            }
        }

        stage('Checkout') {
            steps {
                echo 'Checking out source code'
                checkout scm
            }
        }

        stage('Build Booking Service') {
            steps {
                echo 'Building booking-service'
                dir('booking-service') {
                    sh 'mvn -version'
                    sh 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Docker Build') {
            steps {
                echo 'Building Docker image'
                dir('booking-service') {
                    sh 'docker version'
                    sh 'docker build -t booking-service:${BUILD_NUMBER} .'
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully'
        }
        always {
            echo 'Pipeline finished'
        }
    }
}
