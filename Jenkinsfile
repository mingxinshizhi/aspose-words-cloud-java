parameters {		
		string(name: 'StartFromStep', defaultValue: '1', description: 'start step')	
}
node('billing-qa-ubuntu-16.04.4') {         
    try {
	   stage('0:build android sdk image') {
		if (params.StartFromStep.toInteger() < 1) {
		    checkout([$class: 'GitSCM', branches: [[name: '*/android']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '9d6c4dfa-042c-4ed1-81c7-9175179dddda', url: 'https://github.com/aspose-words-cloud/aspose-words-cloud-java.git/']]])
			sh "docker build -t asposewordsandroid.image -f ./Dockerfile . "
		}
	   }
	   
       stage('1:checkout'){
		if (params.StartFromStep.toInteger() < 2) {
		checkout([$class: 'GitSCM', branches: [[name: '*/android']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '9d6c4dfa-042c-4ed1-81c7-9175179dddda', url: 'https://github.com/aspose-words-cloud/aspose-words-cloud-java.git/']]])
           withCredentials([usernamePassword(credentialsId: '6839cbe8-39fa-40c0-86ce-90706f0bae5d', passwordVariable: 'AppKey', usernameVariable: 'AppSid')]) {
			  sh 'git checkout android'
              sh 'mkdir -p Settings'
              sh 'echo "{\\"AppSid\\": \\"$AppSid\\",\\"AppKey\\": \\"$AppKey\\", \\"BaseUrl\\": \\"https://auckland-words-cloud-staging.dynabic.com\\"}" > Settings/servercreds.json'
			  sh "git config user.email \"jenkins.aspose@gmail.com\""
			  sh "git config user.name \"jenkins\""
			}
		  }
		}
	   
	   stage('2:release'){
		if (params.StartFromStep.toInteger() < 3) {
			withCredentials([usernamePassword(credentialsId: '7a9d358a-f555-4766-81ff-62bf23ec18d4', passwordVariable: 'mavenPass', usernameVariable: 'mavenUser')]) {
					sh 'docker run --rm -v "$PWD":/application asposewordsandroid.image sh -c "gradle clean build test"'
				}
			}
	   }	   
    } finally {                       
        deleteDir()
    }
}   
