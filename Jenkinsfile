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
		
		
		 stage ('Exec Maven') {
            steps {
                withSonarQubeEnv('SonarQube_Scanner'){
                rtMavenRun (
                    tool: 'Maven-3.8.8',
                    pom: 'pom.xml',
                    goals: 'clean package sonar:sonar deploy',
                    deployerId: "MAVEN_DEPLOYER"
                    
                )
                }
            }
        }
		
    }
     
}