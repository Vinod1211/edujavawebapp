pipeline{
    agent { label 'node2'}
    parameters {
        choice(name: 'Branch_Name', choices: ['dev', 'master'], description: 'Select the gitHub branch which you want to use')
        string(name: 'Maven_Goal', defaultValue: 'clean package', description: 'Enter the maven goal')
    }
    triggers{
        pollSCM('* * * * *')
    }
    stages{
        stage ('git source code'){
            steps{
                main subject: 'Build Started',
                    body: 'Build Started',
                    to: 'chengavinod1@gmail.com'
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
    post{
        always{
            echo 'Job Completed'
            main subject: 'Build Completed',
                    body: 'Build Completed',
                    to: 'chengavinod1@gmail.com'
        }
        failure{
            main subject: 'Build Failed',
                    body: 'Build Failed',
                    to: 'chengavinod1@gmail.com'
        }
        success{
            echo 'Job Completed successfully'
            main subject: 'Build Completed successfully',
                    body: 'Build Completed successfully',
                    to: 'chengavinod1@gmail.com'
        }
    }
}