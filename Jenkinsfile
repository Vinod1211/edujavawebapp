pipeline{
    agent any
    
    triggers{
        pollSCM('* * * * *')
    }
    stages{
        stage ('git source code'){
            steps{
                
                git branch: 'dev', url: 'https://github.com/Vinod1211/edujavawebapp.git'
            }
        }
		
		
		stage('maven build'){
            steps{
                withSonarQubeEnv('SonarQube_Scanner'){
                    sh "/opt/apache-maven-3.8.8/bin/mvn clean package sonar:sonar deploy"
                }
            }
        }
        
        stage("Quality gate") {
            steps {
                waitForQualityGate abortPipeline: true
            }
        }

        stage("build docker image") {
            steps {
                sh "docker image build -t $env.JOB_NAME:$env.BUILD_ID ."
                sh "docker tag $env.JOB_NAME http://13.127.20.63:8081/$env.JOB_NAME:$env.BUILD_ID"
                sh "docker push http://13.127.20.63:8081/$env.JOB_NAME:$env.BUILD_ID"
            }
        }

		
    }
     
}