pipeline {
 agent {
  label ""
 }
parameters {


  choice(name: 'tags', choices: ['@Smoke', '@Regression'], description: 'Please pass cucumber tag to run')
  choice(name: 'env', choices: ['qa','int2'], description: 'Please select environment to execute tests')

 }
 

  stages {
            stage('Automation') {
                steps {
                   
                        script {
                            
								sh "pwd"
								sh "ls -la"
                                sh "mvn clean install -Dtags=\"${tags}\" -Denv=\"${ENV}\""
                                sh "ls -la target/json"
                            
                        }
                        post {
                            always {
                                junit '**/surefire-reports/*.xml'
                            }
                        }
                    
                }
            }
        }

 }
