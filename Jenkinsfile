/*

pipeline {
    agent any

    environment {
        project = 'sbn'
        module = 'arquitectura-hexagonal-ms'
        port = '8189'
    }

    stages {
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube-Server') {
                    sh '''
                        mvn clean verify sonar:sonar
                    '''
                }
            }
        }

        stage('Quality Gate') {
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Desplegando aplicación...'
            }
        }
    }

}

*/


pipeline {

    agent any

    stages {

        stage('Build & Test') {
            steps {
                sh 'mvn clean verify'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube-Server') {
                    sh 'mvn sonar:sonar'
                }
            }
        }

        stage('Quality Gate') {
            steps {
                timeout(time: 10, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }

        stage('Docker Build') {
            when {
                anyOf {
                    branch 'qa'
                    branch 'main'
                }
            }
            steps {
                sh '''
                    docker build -t arquitectura-hexagonal:${BUILD_NUMBER} .
                '''
            }
        }

        stage('Deploy QA') {
            when {
                branch 'qa'
            }
            steps {
                echo "Deployando QA"
            }
        }

        stage('Deploy Produccion') {
            when {
                branch 'main'
            }
            steps {
                echo "Deployando Produccion"
            }
        }
    }
}