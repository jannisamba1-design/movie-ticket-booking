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
                deleteDir()
            }
        }

        stage('Checkout') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/main']],
                    userRemoteConfigs: [[
                        url: 'https://github.com/jannisamba1-design/movie-ticket-booking.git'
                    ]]
                ])
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
}
