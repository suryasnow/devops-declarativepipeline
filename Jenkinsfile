pipeline {
    agent any
    tools { 
        maven 'Maven' 
    }
    stages {
        stage("CI") {
            steps {
               snDevOpsStep()
              // sh 'mvn clean install'
          }
        }

        stage('UAT test') {
                    steps {
                        snDevOpsStep()
                        sh 'mvn compile'
                        sh 'mvn test -Dtest=AppTest'
                    }
                       post {
               always {
              junit '**/target/surefire-reports/*.xml' 
              }
            }
            }
        
        stage("IT Test") {
            steps {
               snDevOpsStep()
              // sh 'mvn clean install'
          }
        }
        
    }
}
