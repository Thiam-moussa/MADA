node {
    stage('Test Docker') {
        sh 'docker version'
    }
}