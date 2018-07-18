pipeline {
  agent {
    docker {
      image 'maven:alpine'
      args '-v /Users/marcelo/.m2:/root/.m2'
    }

  }
  stages {
    stage('Init') {
      steps {
        echo 'Starting...'
        sh '''echo ${PATH}

mvn clean install'''
      }
    }
  }
}