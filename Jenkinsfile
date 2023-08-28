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
                mail subject: "Build process started for Jenkins job: $env.JOB_NAME",
                    body: "Build process started for Jenkins job: $env.JOB_NAME",
                    to: 'vinoddevops24@gmail.com'
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
     post {
        always {
            echo 'Job Completed'
            mail subject: "Build Completed for Jenkins job: $env.JOB_NAME",
                    body: "Build Completed for Jenkins job: $env.JOB_NAME /n click hear: $env.JOB_URL",
                    to: 'vinoddevops24@gmail.com'
        }
        failure {
            mail subject: "Build Failed for Jenkins job: $env.JOB_NAME",
                    body: "Build Failed for Jenkins job: $env.JOB_NAME with build ID: $env.BUILD_ID",
                    to: 'vinoddevops24@gmail.com'
        }
        success {
            echo 'Job Completed successfully'
            mail subject: "Build Completed successfully for Jenkins job: $env.JOB_NAME",
                    body: "Build Completed successfully for Jenkins job: $env.JOB_NAME",
                    to: 'vinoddevops24@gmail.com'
        }
    }
}