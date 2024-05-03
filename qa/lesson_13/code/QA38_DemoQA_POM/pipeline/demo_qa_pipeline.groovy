def build_success = true

currentBuild.displayName = "Build " + currentBuild.displayName + " " + env.REPO_BRANCH

pipeline {
    agent { label 'mac' }
    stages {
        stage('Clean') {
            steps {
                cleanWs()
            }
        }
        stage('checkout') {
            steps {
                git branch: "${env.REPO_BRANCH}", url: 'https://github.com/SchArtur/cohort38e-qap.git'
            }
        }
        stage('test') {
            steps {
                script {
                    try {
                        sh "gradle QA38_DemoQA_POM:test -Ptags=${env.TAGS}"
                    }
                    catch (e) {
                        build_success = false
                        echo 'build failure!'
                    }
                }
            }
        }
    }
}