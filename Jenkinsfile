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
                sh "docker image build -t eduwebapp:1 ."
                sh "docker tag eduwebapp 192.168.0.55:8081/eduwebapp:1"
                sh "docker push 192.168.0.55:8081/eduwebapp:1"
            }
        }

		
    }
     
}