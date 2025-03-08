pipeline{
agent any

parameters {
 // Define the TestType parameter to choose which test type to run
        choice(name: 'TestType', choices: ['smoke', 'regression', 'sanity', 'none'], description: 'Select Test Type')
}
    
stages{
stage('build'){
steps{
echo "Hi building project from jenkins"
}
}

stage('deploy'){
steps{
echo "Hi deploying project from jenkins"
}
}

stage('test'){
steps{
script {
 echo "Hi Testing project from jenkins"
 //bat "mvn clean install"
                    // Determine the TestNG XML file to run based on the TestType parameter
                    def testNgFile = 'testng.xml'  // Default to 'testng.xml'
                    
                    if (params.TestType == 'smoke') {
                        testNgFile = 'smoke.xml'
                    } else if (params.TestType == 'regression') {
                        testNgFile = 'regression.xml'
                    } else if (params.TestType == 'sanity') {
                        testNgFile = 'sanity.xml'
                    }
                    
                    // Prepare the Maven command based on the selected TestNG XML
                    def command = "mvn clean test -DsuiteFile=${testNgFile}"
                    
                    echo "Running tests with TestNG suite: ${testNgFile}"
                    bat command  // Run the tests with the selected TestNG XML file
 
}
}
}

}
post {
        always {
            // Archive the generated ExtentReport.html file
            archiveArtifacts allowEmptyArchive: true, artifacts: '**/ExtentReports/Report.html,**/application.log' , onlyIfSuccessful: true

            // Optionally, send an email with the report attached
            //mail to: 'recipient@example.com', 
                 //subject: "Test Execution Report - ${currentBuild.currentResult}", 
                 //body: "Please find the attached Extent Report for the latest build.", 
                 //attachmentsPattern: '**/ExtentReports/Report.html'
                 
            // Display the Extent report as an HTML page in Jenkins
            publishHTML(target: [
                reportName: 'Extent Report',
                reportDir: 'ExtentReports', // Directory containing the HTML report
                reportFiles: 'Report.html', // Name of the HTML file
                alwaysLinkToLastBuild: true
            ])
        }
        
        //success {
            // Email notification on success
            //mail to: 'your-email@example.com',
                 //subject: "Build #${env.BUILD_NUMBER} - ${env.JOB_NAME} - SUCCESS",
                 //body: "Build #${env.BUILD_NUMBER} of ${env.JOB_NAME} has completed successfully.\n\nCheck the report at: ${env.BUILD_URL}/artifact/target/ExtentReports/ExtentReport.html"
        //}
        
        //failure {
            // Email notification on failure
            //mail to: 'your-email@example.com',
                 //subject: "Build #${env.BUILD_NUMBER} - ${env.JOB_NAME} - FAILED",
                 //body: "Build #${env.BUILD_NUMBER} of ${env.JOB_NAME} has failed. Please check the logs and reports.\n\nCheck the report at: ${env.BUILD_URL}/artifact/target/ExtentReports/ExtentReport.html"
        //}
    }
}