pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'your-docker-username/maven-web-application'
        REGISTRY = 'docker.io' // Use Docker Hub, update for ECR or another registry
        K8S_NAMESPACE = 'default'
    }

    stages {
        stage('Clone Repo') {
            steps {
                checkout scm
            }
        }

        stage('Build Maven') {
            steps {
                script {
                    // Clean and build the project
                    sh 'mvn clean install'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build Docker image
                    sh "docker build -t ${DOCKER_IMAGE}:${BUILD_NUMBER} ."
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    // Login to Docker and push the image
                    sh "docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD"
                    sh "docker push ${DOCKER_IMAGE}:${BUILD_NUMBER}"
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                script {
                    // Update Kubernetes deployment to use the new image
                    sh "kubectl set image deployment/maven-web-application maven-web-application=${DOCKER_IMAGE}:${BUILD_NUMBER} --namespace=${K8S_NAMESPACE}"
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline successfully completed!'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
