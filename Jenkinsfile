pipeline {
  agent {
    docker {
      image 'maven:alpine'
      args '-v /Users/marcelo/.m2:/root/.m2'
    }

  }
  stages {
    stage('Build') {
      parallel {
        stage('Build') {
          steps {
            echo 'Starting...'
            sh '''echo ${PATH} 
cd consumer 
mvn clean install -DskipTests'''
          }
        }
        stage('teste') {
          steps {
            echo 'teste'
          }
        }
      }
    }
    stage('UnitTests') {
      parallel {
        stage('UnitTests') {
          steps {
            sh '''cd consumer
mvn test'''
          }
        }
        stage('print') {
          steps {
            echo 'teste2'
          }
        }
      }
    }
    stage('Publish Test Reports') {
      steps {
        junit 'consumer/target/surefire-reports/**/*.xml'
      }
    }
  }
}