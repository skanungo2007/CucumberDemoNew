pipeline {
 agent {
  label "master"
 }
parameters {


  choice(name: 'tags', choices: ['@Smoke', '@Regression'], description: 'Please pass cucumber tag to run')
  choice(name: 'env', choices: ['qa','int2'], description: 'Please select environment to execute tests')

 }
 

  stages {
            stage('Automation') {
                steps {
                   
                        script {
                                sh "mvn clean install -Dtags=\"${tags}\" -Denv=\"${ENV}\""

                        }
                    
                }
            }
        }

 }
