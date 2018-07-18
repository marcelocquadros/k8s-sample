pipeline {
  agent {
    docker {
      image 'maven:alpine'
    }
  }
  stages {
    stage('build') {
      steps {
          git(url: 'https://github.com/marcelocquadros/k8s-sample.git', branch: 'master')
     }
   }
 }
