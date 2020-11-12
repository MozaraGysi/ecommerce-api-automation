pipeline {
    agent any
    tools {
        maven 'maven-3.6.3'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
        stage ('Build') {
            steps {
                sh 'mvn -Dtest=OtherServices.Tests.PrateleiraInfinita -Dbrand=Arezzo -Denv=hml test'
            }
        }
    }
}
