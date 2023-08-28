pipeline{
    agent { label 'node1'}
    parameters {
        choice(name: 'Branch_Name', choices: ['dev', 'master'], description: 'Select the gitHub branch which you want to use')
        string(name: 'Maven_Goal', defaultValue: 'package', description: 'Enter the maven goal')
    }
    triggers{
        pollSCM('* * * * *')
    }
    stages{
        stage ('git source code'){
            steps{
                git branch: "${params.Branch_Name}", url: 'https://github.com/Vinod1211/edujavawebapp.git'
            }
        }

        stage('build'){
            steps{
                sh "/opt/apache-maven-3.8.8/bin/mvn ${params.Maven_Goal}"
            }
        }

        stage('artifacts'){
            steps{
                sh 'whoami'
            }
        }
    }
}