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
                // echo "Globalprops -- ${env.snartifacttoolid} -- ${env.snhost} -- ${env.snuser} -- ${env.snpassword} ";
                //sh 'mvn compile'
                //sh 'mvn test -Dtest=AppTest'
                // sh 'mvn clean install'
                //sh 'mvn test'
          }
        }

        stage('UAT test') {
            post {
                success {
                    junit '**/target/surefire-reports/*.xml' 
                }
            }
            stages {
                stage('UAT unit test') {
                    steps {
                        snDevOpsStep()
                        sh 'mvn compile'
                        sh 'mvn test -Dtest=AppTest'
                    }
                stage('UAT static code test') {
                    steps {
                        snDevOpsStep()
                        sh 'mvn compile'
                        sh 'mvn verify'
                    }
                }
            }
        }
      }
        
        stage('IT test') {
            steps {
                snDevOpsStep()
                sh 'mvn test -Dtest=NegativeTest'
            }
            post {
                success {
                    junit '**/target/surefire-reports/*.xml' 
                  }
              }
        }
                
        
        stage('UAT deploy') {
            stages {
                stage('UAT pre-prod deploy') { 
                    steps {
                        snDevOpsStep()     
                        // snDevOpsChange()
                        // sh 'mvn package'
                       // snDevOpsArtifact(artifactsPayload:"""{"artifacts": [{"name": "${artifactName}","version":"${artifactVersion}","semanticVersion": "${artifactSemVersion}","repositoryName": "${repoName}"}]}""")
                    }
                }
            }
        }
    }
}
