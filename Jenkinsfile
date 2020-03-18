pipeline {
  agent any
  stages {
    stage('pull') {
        steps {
            echo 'git pull'
        }
    }
    stage('build') {
      steps {
        sh 'mvn clean compile'
      }
    }

    stage('test') {
      steps {
        sh 'mvn test'
      }
    }

    stage('package') {
      steps {
        sh 'mvn package -DskipTests'
      }
    }

  }
}