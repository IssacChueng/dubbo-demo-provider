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

    stage('deploy') {
        steps {
            withEnv(['JENKINS_NODE_COOKIE=dontKillMe']) {
                sh '''
                    export BUILD_ID=dontKillMe
                    echo "关闭provider"
                    pwd
                    ls
                    ssh peer1 "cd dubbo-demo/ && sh stop-provider.sh"
                    echo "传输jar"
                    scp target/provider.jar peer1:dubbo-demo/provider/
                    ssh peer1 "cd dubbo-demo/provider/ && nohup java -jar provider.jar >>/dev/null 2>&1 &"
                '''
            }
        }
    }
  }
}