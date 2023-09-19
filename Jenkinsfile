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
                                bat "mvn clean install -Dtags=\"${tags}\" -Denv=\"${ENV}\""

                        }

                        post {

                                        // If Maven was able to run the tests, even if some of the test
                                        // failed, record the test results and archive the jar file.
                                        success {
                                                cucumber buildStatus: 'null',
                                                customCssFiles: '',
                                                customJsFiles: '',
                                                failedFeaturesNumber: -1,
                                                failedScenariosNumber: -1,
                                                failedStepsNumber: -1,
                                                fileIncludePattern: '**/*.json',
                                                pendingStepsNumber: -1,
                                                skippedStepsNumber: -1,
                                                sortingMethod: 'ALPHABETICAL',
                                                undefinedStepsNumber: -1
                                        }
                                    }

                    
                }
            }
        }

 }
