pipeline{
    agent {label 'jdk21'}
    options{timeout(time:30, unit:'MINUTES')}
    parameters {
        choice(name: 'CreateBuild', choices: ['No', 'Yes'], description: 'Want to create docker image?')
    }
    environment {
        BRANCH_NAME = "${env.GIT_BRANCH ?: 'release'}"
        LS_LOKI_ENABLED = 'false'
        PROJECT_NAME = 'jenkinApp'
        BUILD_VERSION = '1.0.0'
        }

    stages {
        stage('Initialise') {
            steps {
                echo 'Initializing ...'
                stepInitialise()
            }
        }
        stage('Maven Build') {
            steps {
                echo 'Maven Build...'
                sh "mvn -f pom.xml clean package"
            }
        }
        /* stage('Code Quality') {
            parallel {
                stage('SonarQube Analysis') {
                    steps {
                        echo 'Running SonarQube Analysis...'
                        // Add your SonarQube analysis commands here
                    }
                }
                stage('Checkmarx Scan') {
                    steps {
                        echo 'Running Checkmarx Scan...'
                        // Add your Checkmarx scan commands here
                    }
                }
            }
        } */

        stage('Deploy') {
            steps {
                echo 'Deploying...'
                // Add your deploy commands here
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }