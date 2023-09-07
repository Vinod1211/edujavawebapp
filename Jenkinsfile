pipeline{
    agent any
    parameters {
        string(name: 'Maven_Goal', defaultValue: 'clean install sonar:sonar', description: 'Enter the maven goal')
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
		
		
		stage ('Artifactory configuration') {
            steps {

                rtMavenDeployer (
                    id: "MAVEN_DEPLOYER",
                    serverId: "JfrogDemo",
                    releaseRepo: "eduwebapp-libs-release",
                    snapshotRepo: "eduwebapp-libs-snapshot"
                )
            }
        }
		
		 stage ('Exec Maven') {
            steps {
                withSonarQubeEnv('Sonar_Scanner'){
                rtMavenRun (
                    tool: 'Maven3.8.8',
                    pom: 'pom.xml',
                    goals: 'clean install sonar:sonar',
                    deployerId: "MAVEN_DEPLOYER"
                    
                )
                }
            }
        }

        stage ('Publish build info') {
            steps {
                rtPublishBuildInfo (
                    serverId: "JfrogDemo"
                )
            }
        }
		
		
		
    }
     
}