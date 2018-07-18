pipeline {
  agent {
    docker {
      image 'maven:alpine'
      args '-v /Users/marcelo/.m2:/root/.m2'
    }

  }
  stages {
    stage('Build') {
      steps {
        echo 'Starting...'
        sh '''echo ${PATH} 
cd consumer 
mvn clean install -DskipTests'''
      }
    }
    stage('UnitTests') {
      steps {
        sh '''cd consumer
mvn test'''
      }
    }
    stage('Build Image') {
      steps {
        sh '''cd consumer
mvn dockerfile:build'''
      }
    }
  }
}