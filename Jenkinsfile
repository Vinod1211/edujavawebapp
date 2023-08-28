pipeline{
    agent { label 'node1'}
    parameters {
        choice(name: 'Branch_Name', choices: 'dev, master', description: 'Select the gitHub branch which you want to use')
        string(name: 'Maven_Version', defaultValue: 'maven-3.8.8', description: 'Select the gitHub branch which you want to use')
    }
    stages{
        stage ('git source code'){
            steps{
                git branch: ${params.Branch_Name}, url: 'https://github.com/Vinod1211/edujavawebapp.git'
            }
        }

        stage('build'){
            steps{
                sh "/opt/apache-${params.Maven_Version}/bin/mvn clean package"
            }
        }

        stage('artifacts'){
            steps{
                sh 'whoami'
            }
        }
    }
}