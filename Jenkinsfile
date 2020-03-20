def artifactName = "ppm-jar" // also used for nexus filePath and artifactId attributes
def artifactVersion = "2.${env.BUILD_NUMBER}"
def artifactSemVersion = "${artifactVersion}.0"
def repoName = "ppm-repo"
def packageName = "ppm-package-${env.BUILD_NUMBER}"

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
                echo "artifactName - ${artifactName}" 
                echo "artifactVersion - ${artifactVersion}" 
                echo "artifactSemVersion - ${artifactSemVersion}" 
                echo "repoName - ${repoName}" 
                snDevOpsArtifact(artifactsPayload:"""{"artifacts": [{"name": "${artifactName}","version":"${artifactVersion}","semanticVersion": "${artifactSemVersion}","repositoryName": "${repoName}"}]}""")
          }
        }

        stage('Unit test') {
            stages {
                stage('Unit test inner') {
                    steps {
                        snDevOpsStep()
                        sh 'mvn compile'
                        sh 'mvn test -Dtest=AppTest'
                    }
                }
                stage('static code test') {
                        steps {
                            snDevOpsStep()
                            sh 'mvn compile'
                            sh 'mvn verify'
                        }
                    }
                }
                //post {
                  //  success {
                   // junit '**/target/surefire-reports/*.xml' 
                 // }
             // }            
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
                        echo "packageName - ${packageName}" 
                        snDevOpsPackage(name: "${packageName}", artifactsPayload:"""{"artifacts": [{"name": "${artifactName}","version":"${artifactVersion}","semanticVersion": "${artifactSemVersion}","repositoryName": "${repoName}"}]}""")
                        snDevOpsChange()
                    }
                }
            }
        }
    }
} 
