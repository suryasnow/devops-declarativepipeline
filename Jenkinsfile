
pipeline {
    agent any
    tools { 
        maven 'Maven' 
    }
    stages {
        stage('CI') {
            steps {
               snDevOpsStep()
                echo 'Building..'
                echo "Pipeline name is ${env.JOB_NAME}"
                echo "Pipeline run rumber is ${env.BUILD_NUMBER}"
                echo "Stage name is ${env.STAGE_NAME}"
                echo "GIT branch is ${env.GIT_BRANCH}"
                echo "Globalprops -- ${env.snartifacttoolid} -- ${env.snhost} -- ${env.snuser} -- ${env.snpassword} ";
                //sh 'mvn compile'
                //sh 'mvn test -Dtest=AppTest'
                sh 'mvn clean install'
                //sh 'mvn test'
          }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml' 
                }
            }
        }

        stage('UAT test') {
                    steps {
                        snDevOpsStep()
                        sh 'mvn compile'
                        sh 'mvn test -Dtest=AppTest'
                        //sh 'mvn verify'
                        
                        // 
                    }
            }
        
    }
}
