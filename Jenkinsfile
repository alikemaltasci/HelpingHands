pipeline {
  agent any
  stages{
    stage('Build'){
      steps {
        sh 'mvn -B -DskipTests clean package'
      }
    }

    stage('Test'){
      sh 'mvn test'
      post {
        always {
          junit 'target/surefire-reports/*.xml'
        }
      }
    }

    stage('Stage'){
      step {
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