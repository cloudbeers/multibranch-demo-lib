def call(Map config) {
    node {
        stage('Checkout') {
            checkout scm
        }
        stage('Main') {
            echo "No-op"
        }
        stage('Post') {
            echo "Goodbye"
        }
    }
}
