parameters {		
		string(name: 'StartFromStep', defaultValue: '1', description: 'start step')	
}
node('words-linux') {         
    try {
	   stage('0:build android sdk image') {
		if (params.StartFromStep.toInteger() < 1) {
		    checkout([$class: 'GitSCM', branches: [[name: '*/android']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '361885ba-9425-4230-950e-0af201d90547', url: 'https://git.auckland.dynabic.com/words-cloud/words-cloud-java.git']]])
			sh "docker build -t asposewordsandroid.image -f ./Dockerfile . "
		}
	   }
	   
       stage('1:checkout'){
		if (params.StartFromStep.toInteger() < 2) {
		checkout([$class: 'GitSCM', branches: [[name: '*/android']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '361885ba-9425-4230-950e-0af201d90547', url: 'https://git.auckland.dynabic.com/words-cloud/words-cloud-java.git']]])
           withCredentials([usernamePassword(credentialsId: '6839cbe8-39fa-40c0-86ce-90706f0bae5d', passwordVariable: 'AppKey', usernameVariable: 'AppSid')]) {
			  sh 'git checkout android'
              sh 'mkdir -p Settings'
              sh 'echo "{\\"AppSid\\": \\"$AppSid\\",\\"AppKey\\": \\"$AppKey\\", \\"BaseUrl\\": \\"https://api-qa.aspose.cloud\\"}" > Settings/servercreds.json'
			  sh "git config user.email \"jenkins.aspose@gmail.com\""
			  sh "git config user.name \"jenkins\""
			}
		  }
		}
	   
	   stage('2:tests'){
		if (params.StartFromStep.toInteger() < 3) {
			withCredentials([usernamePassword(credentialsId: 'f0c4f9b6-8ffe-4ea8-8981-e99263fdb788', passwordVariable: 'mavenPass', usernameVariable: 'mavenUser')]) {
                    sh "chmod 777 gradlew"
					sh 'echo "target = android\\ndeployRepoUrl=https://artifact.aspose.cloud/repo/\\ndeployRepoUsername=${mavenUser}\\ndeployRepoPassword=${mavenPass}" > gradle.properties'
					sh 'docker run --rm -v "$PWD":/application asposewordsandroid.image sh -c "./gradlew clean build test"'
				}
			}
	   }	   
    } finally {                       
        cleanWs()
    }
}   
