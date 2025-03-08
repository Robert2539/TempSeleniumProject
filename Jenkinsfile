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
}