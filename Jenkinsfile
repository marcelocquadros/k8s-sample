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
        sh 'mvn test'
      }
    }
    stage('Build Image') {
      steps {
        sh 'mvn dockerfile:build'
      }
    }
  }
}