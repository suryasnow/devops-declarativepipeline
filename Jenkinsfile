//def orchestrationToolId = "67d8cfe00f6200109d1a986eb4767e43"
def nexusInstanceId = "localNexus"
def nexusGroupId = "com.globex.web"
def nexusPackaging = "war"
def artifactName = "ppm-grc-client" // also used for nexus filePath and artifactId attributes
def packageName = "ppm-package"
def repoName = "ppm-artifact-repo"

def artifactVersion = "2.${env.BUILD_NUMBER}"

def artifactSemVersion = "${artifactVersion}.0"

def repoName = "ff-artifacts-repo" // also used for nexusRepositoryId attribute
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
            stages {
                stage('UAT unit test') {
                    steps {
                        snDevOpsStep()
                        sh 'mvn compile'
                        sh 'mvn test -Dtest=AppTest'
                        //sh 'mvn verify'
                        
                        // 
                    }
                    post {
                        success {
                            junit '**/target/surefire-reports/*.xml' 
                        }
                    }
                }
                stage('UAT static code test') {
                    steps {
                        snDevOpsStep()
                        sh 'mvn compile'
                        sh 'mvn verify'
                    }
                    post {
                        success {
                            junit '**/target/surefire-reports/*.xml' 
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
