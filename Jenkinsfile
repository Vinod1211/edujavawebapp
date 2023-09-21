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
                    serverId:'jfrog_sample',
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

        stage('publish build info') {
            steps {
                rtPublishBuildInfo(
                    serverId: 'jfrog_sample'
                )
            }
        }
        stage("build docker image") {
            steps {
                
                withCredentials([usernamePassword(credentialsId: 'jfrog1', passwordVariable: 'jfrog_pwd', usernameVariable: 'jfrog_user')]) {
                    sh "docker login -u ${jfrog_user} -p ${jfrog_pwd} vibama.jfrog.io"
                    sh "docker build -t eduwebapp:${BUILD_NUMBER} ."
                    sh "docker tag eduwebapp:${BUILD_NUMBER} vibama.jfrog.io/owndocker-docker/javawebapp:sample"
                    sh "docker push vibama.jfrog.io/owndocker-docker/javawebapp:sample"
                }
                
            }
        }

        stage('create container and run') {
            steps {
                sh "docker run -d -P vibama.jfrog.io/owndocker-docker/javawebapp:sample"
            }
        }
		
    }
     
}