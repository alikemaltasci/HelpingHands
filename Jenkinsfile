pipeline {
  agent any
  stages{
    stage('Build'){
      steps {
        sh 'mvn -B -DskipTests clean package'
      }
      post {
        success {
          archiveArtifacts artifacts: '**/target/*.war'
        }
      }
    }

    stage('Test'){
      steps {
        sh 'mvn test'
        post {
          always {
            junit 'target/surefire-reports/*.xml'
          }
        }
      }
    }

    stage('Stage'){
      steps {
        echo "Deploying to stage."
      }
    }

    stage('Prod'){
      steps {
        echo "Deploying to prod."
      }
    }
  }
}