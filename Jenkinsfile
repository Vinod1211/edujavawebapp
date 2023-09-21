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
                    sh "/opt/apache-maven-3.8.8/bin/mvn clean package sonar:sonar"
                }
            }
        }
        
        stage("Quality gate") {
            steps {
                waitForQualityGate abortPipeline: true
            }
        }

        stage("Upload artifacts to jfrog"){
            steps {
                rtUpload(
                    serverId:
                    spec: '''{
                        "files": [
                            {
                                "pattern": "./target/*.war",
                                "target": "javaapp-libs-release/"
                            }
                        ]
                    }''',
                )
            }
        }
        /*stage("build docker image") {
            steps {
                
                //sh "docker build -t 13.233.212.178:8082/eduwebapp:${BUILD_NUMBER} ."
                withCredentials([usernamePassword(credentialsId: 'nexus', passwordVariable: 'nexus_pwd', usernameVariable: 'nexus_user')]) {
                    sh "docker login -u ${nexus_user} -p ${nexus_pwd} 13.233.212.178:8081"
                    sh "docker build -t eduwebapp:${BUILD_NUMBER}"
                    sh "docker push 13.233.212.178:8081/eduwebapp:${BUILD_NUMBER}"
                }
                
            }
        }*/

		
    }
     
}