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
		
		
		 stage('build'){
            steps{
                sh "/opt/apache-maven-3.8.8/bin/mvn clean package"
            }
        }
		
    }
     
}