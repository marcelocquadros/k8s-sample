pipeline {
  agent {
    docker {
      image 'maven:alpine'
    }

  }
  stages {
    stage('build') {
      steps {
        step('clone'){
          git(url: 'https://github.com/marcelocquadros/k8s-sample.git', branch: 'master')
        }
        step('build') {
          steps {
            sh 'mvn clean install'
          }
      }
    }
  }
}
