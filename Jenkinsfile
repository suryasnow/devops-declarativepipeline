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
                echo "CI"
          }
        }

        stage("UAT test") {
                    steps {
                        snDevOpsStep()
                        sh 'mvn compile'
                        //sh 'mvn test -Dtest=AppTest' 
                        echo "UAT test"
                    }
            }
        
    }
}
