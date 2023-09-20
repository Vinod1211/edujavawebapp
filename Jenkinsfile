pipeline{
    agent any
    parameters {
        string(name: 'Maven_Goal', defaultValue: 'clean package sonar:sonar', description: 'Enter the maven goal')
    }
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
                    tool: 'Maven3.8.8',
                    pom: 'pom.xml',
                    goals: 'clean package sonar:sonar deploy',
                    deployerId: "MAVEN_DEPLOYER"
                    
                )
                }
            }
        }
		
    }
     
}